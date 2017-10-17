package com.codefellows;

public class OneBigElectronicDevice {
    private int channel;
    private boolean on = false;
    private String deviceName;
    private String currentApp = null;

    public OneBigElectronicDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    public void turnOn() {
        on = true;
        System.out.println(String.format("deviceName: %s is now on", deviceName));
    }

    public void turnOn(int channel) {
        turnOn();
        this.channel = channel;

        System.out.println(String.format("deviceName: %s is set to channel %d", deviceName,
                channel));
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public int getChannel() {
        return channel;
    }

    public void setCurrentApp(String currentApp) {
        this.currentApp = currentApp;
    }

    public String getCurrentApp() {
        return currentApp;
    }

    public void turnOff() {
        on = false;
        System.out.println(String.format("deviceName: %s is now off", deviceName));
    }

    public boolean isOn() {
        return on;
    }
}
