package com.hengyi.japp.tools.event;

import com.hengyi.japp.tools.data.UserType;

public class LoginEvent {

    private final UserType userType;
    private final Object bindId;

    public LoginEvent(UserType userType, Object bindId) {
        super();
        this.userType = userType;
        this.bindId = bindId;
    }

    public UserType getUserType() {
        return userType;
    }

    public Object getBindId() {
        return bindId;
    }
}
