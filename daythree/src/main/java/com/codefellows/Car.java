package com.codefellows;

public abstract class Car implements IVehicle {
    protected String make;
    protected String model;

    @Override
    public void drive() {
        System.out.println("driving a car");
    }
}
