package com.codefellows;

public class CarFactory implements IVehicleFactory {
    @Override
    public Car create(String type) {
        switch (type) {
            case "sedan":
                return new Sedan();
            case "coupe":
                return new Coupe();
            default:
                System.out.println("warning: invalid car type");
                return null;
        }
    }
}