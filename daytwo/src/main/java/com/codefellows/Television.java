package com.codefellows;

public class Television extends ElectronicDevice {
    private int channel;

//    public Television() {
//        super();
//    }

    public Television() {
        super("television");
    }

    public String getDeviceInfo() {
        return String.format("I'm a television on channel %d", channel);
    }

    public Television(int channel) {
        this();
        this.channel = channel;
    }

    public void turnOn(int channel) {
        super.turnOn(channel);
        this.channel = channel;

        System.out.println(String.format("deviceName: %s is set to channel %d", deviceName,
                channel));
    }
}
