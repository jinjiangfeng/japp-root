package com.hengyi.japp.tools;

import java.io.IOException;
import java.io.StringReader;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.trimToNull;
import static org.apache.commons.lang3.StringUtils.upperCase;
import org.apache.commons.lang3.Validate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class JappUtil {

    public static String deletePrefZero(String s) {
        if (isBlank(s)) {
            return s;
        }
        if (s.startsWith("0")) {
            return deletePrefZero(s.substring(1));
        }
        return s;
    }

    public static NodeList getNodeListFromXml(String xmlText, String tagName) throws ParserConfigurationException, SAXException, IOException {
        try (StringReader sr = new StringReader(xmlText)) {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(sr);
            Document document = db.parse(is);
            Element root = document.getDocumentElement();
            return root.getElementsByTagName(tagName);
        }
    }

    public static String convertUnique(String unique) {
        Validate.notBlank(unique);
        return trimToNull(upperCase(unique));
    }

    public static final ResourceBundle resourceBundle(String baseName) {
        return ResourceBundle.getBundle(baseName, Locale.CHINA);
    }

    public static final ResourceBundle resourceBundle(String baseName, Locale locale) {
        try {
            return ResourceBundle.getBundle(baseName, locale);
        } catch (Exception e) {
            // TODO resource 需要改进
            return ResourceBundle.getBundle(baseName, Locale.CHINA);
        }
    }

    public static final <T> T getJndi(String jndi) throws NamingException {
        Validate.notBlank(jndi);
        InitialContext initCtx = new InitialContext();
        return (T) initCtx.lookup(jndi);
    }
}
