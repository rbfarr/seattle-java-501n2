package com.codefellows;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return String.format("Hi, I'm %s", name);
    }
}
