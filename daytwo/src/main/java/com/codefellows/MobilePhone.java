package com.codefellows;

public class MobilePhone extends ElectronicDevice {
    private String currentApp;

    public MobilePhone() {
        super("mobile phone");
    }

    public String getDeviceInfo() {
        return String.format("I'm a phone running %s", currentApp);
    }
}
