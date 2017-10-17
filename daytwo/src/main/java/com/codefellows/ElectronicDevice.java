package com.codefellows;

public abstract class ElectronicDevice {
    protected boolean on = false;
    protected final String deviceName;

    protected PowerState powerState = PowerState.OFF;

    private static final int NUM_DEGREES_IN_CIRCLE = 360;

//    private static final Logger log;
//
//    static {
//        log = new Logger();
//    }

    public void updatePowerState(PowerState newState) {
        powerState = newState;
    }

    public String getPowerStateString() {
        return powerState.getDescription();
    }

    public ElectronicDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    abstract String getDeviceInfo();

    public void turnOn(int initialValue) {
        System.out.println(String.format("on with initial value %d", initialValue));
    }

    public void turnOn() {
        on = true;
        System.out.println(String.format("deviceName: %s is now on", deviceName));
    }

    public final void turnOff() {
        on = false;
        System.out.println(String.format("deviceName: %s is now off", deviceName));
    }
}
