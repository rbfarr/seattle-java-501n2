package com.codefellows;

public enum PowerState {
    ON("power is on"),
    OFF("power is off"),
    SUSPENDED,
    HIBERNATED,
    UNKNOWN;

    private String description;

    PowerState() {
        description = null;
    }

    PowerState(String d) {
        description = d;
    }

    public String getDescription() {
        return description;
    }
}
