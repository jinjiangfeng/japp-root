package com.hengyi.japp.tools.exception;

public class LoginUsedException extends AppException {

    private final String loginId;

    public LoginUsedException(String loginId, String usedName) {
        super();
        this.loginId = loginId;
    }

    public String getLoginId() {
        return loginId;
    }

}
