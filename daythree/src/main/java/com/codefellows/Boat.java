package com.codefellows;

public class Boat implements IVehicle {
    int maxNumPassengers;

    @Override
    public void drive() {
        System.out.println("driving a boat");
    }
}
