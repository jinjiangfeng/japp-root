package com.hengyi.japp.tools;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.InjectionTarget;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"unchecked", "rawtypes"})
public class CDIUtil {

    private static final Logger log = LoggerFactory.getLogger(CDIUtil.class);
    private static BeanManager _manager;

    /**
     * Returns the CDI BeanManager. Default implementation use JNDI to lookup
     * "java:comp/env/BeanManager".
     */
    public static BeanManager getBeanManager() {
        if (_manager != null) {
            return _manager;
        }

        try {
            final InitialContext initialContext = new InitialContext();
            _manager = (BeanManager) initialContext
                    .lookup("java:comp/BeanManager");
        } catch (NamingException e) { // Error getting the home interface
            log.error("Cannot locate the BeanManager for JavaEE 6.", e);
        }
        return _manager;
    }

    public static <T> void inject(BeanManager beanManager, Object obj) {
        // CDI uses an AnnotatedType object to read the annotations of a class
        AnnotatedType<T> type = (AnnotatedType<T>) beanManager
                .createAnnotatedType(obj.getClass());

        // The extension uses an InjectionTarget to delegate instantiation,
        // dependency injection
        // and lifecycle callbacks to the CDI container
        InjectionTarget<T> it = beanManager.createInjectionTarget(type);
        // each instance needs its own CDI CreationalContext
        CreationalContext instanceContext = beanManager
                .createCreationalContext(null);

        it.inject((T) obj, instanceContext); // call initializer methods and
        // perform field injection
        it.postConstruct((T) obj); // call the @PostConstruct method
    }

    public static <T> void inject(Object obj) {
        inject(getBeanManager(), obj);
    }
}
