package com.hengyi.japp.tools.event;

public class ThemeUpdateEvent {

    private final String theme;

    public ThemeUpdateEvent(String theme) {
        super();
        this.theme = theme;
    }

    public String getTheme() {
        return theme;
    }
}
