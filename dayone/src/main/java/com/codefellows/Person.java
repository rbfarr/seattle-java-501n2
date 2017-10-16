package com.codefellows;

public class Person {
    protected String name;
    private int age;
    private String ssn;
    private String city;


    /* static member variables belong to the class itself, rather than objects of that class */
    private static int numPeople = 0;
    // Address

    /* constructor chaining allows you to set default values */
    public Person(String name) {
        this(name, 25);
    }

    public Person(String name, int age) {
        this(name, age, "000-00-0000");
    }

    public Person(String name, int age, String ssn) {
        if (name == null) {
            this.name = "Mr. NoName";
        } else {
            this.name = name;
        }

        this.age = age;
        this.ssn = ssn;

        numPeople++;
    }

    public static int getNumPeople() {
        return numPeople;
    }

    public void setCity(String city, StringBuilder sb) {
        // do something with the StringBuilder
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // convert name to ALL CAPS
        this.name = name;
    }

    private String convertToAllCaps(String str) {
        return str.toUpperCase();
    }

    /* Since all complex types derive from Object, we can override the toString() and equals()
       methods to define our own functionality. */

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Person) {
            if (name.equals(((Person) o).getName())) {
                return true;
            }
        }

        return false;
    }
}
