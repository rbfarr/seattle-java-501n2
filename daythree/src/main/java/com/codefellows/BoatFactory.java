package com.codefellows;

public class BoatFactory implements IVehicleFactory {
    @Override
    public Boat create(String type) {
        return new Boat();
    }
}
