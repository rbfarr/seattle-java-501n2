package com.codefellows;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // "hello", "goodbye", "Brad", "Farr"
        // <expression> to return strings that contain substring

        String vehicleType = args[0];

        List<String> myStrings = Arrays.asList(new String[] {"hello", "goodbye", "Brad", "Farr"});

        doForEachString(myStrings, new IStringAnalyzer() {
            @Override
            public boolean analyze(String myString, String subString) {
                return myString.contains(subString);
            }
        }, "el");

        // more compact
        IStringAnalyzer a = (x, y) -> x.contains(y);
        doForEachString(myStrings, a, "el");

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        if (s1 == s2) {
            System.out.println("Same singleton");
        }

        CarFactory cf = new CarFactory();
        cf.create("sedan");

        IVehicleFactory factory = null;

        switch (vehicleType) {
            case "car":
                factory = new CarFactory();
                break;
            case "boat":
                factory = new BoatFactory();
                break;
            default:
                System.out.println("unknown vehicle type: " + vehicleType);
                System.exit(1);
                break;
        }

        IVehicle vehicle = factory.create("sedan");
        vehicle.drive();
    }

    private static void doForEachString(List<String> strings, IStringAnalyzer analyzer,
            String subString) {

        for (String s : strings) {
            if (analyzer.analyze(s, subString)) {
                System.out.println(s);
            }
        }
    }

    @FunctionalInterface
    private interface IStringAnalyzer {
        boolean analyze(String myString, String subString);
    }

    private static class StringAnalyzer implements IStringAnalyzer {
        public boolean analyze(String myString, String subString) {
            return myString.contains(subString);
        }
    }
}
