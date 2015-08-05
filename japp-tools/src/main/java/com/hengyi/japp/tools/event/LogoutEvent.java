package com.hengyi.japp.tools.event;

import com.hengyi.japp.tools.data.UserType;

public class LogoutEvent {

    private final UserType userType;
    private final Object bindId;

    public LogoutEvent(UserType userType, Object bindId) {
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
