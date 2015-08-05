package com.hengyi.japp.tools.exception;

import com.google.common.collect.Lists;
import java.util.List;

public class AppMultiException extends Exception {

    private List<AppException> appExceptions;

    public List<AppException> getAppExceptions() {
        return appExceptions;
    }

    public void add(AppException appException) {
        if (appExceptions == null) {
            appExceptions = Lists.newArrayList(appException);
        } else {
            appExceptions.add(appException);
        }
    }

}
