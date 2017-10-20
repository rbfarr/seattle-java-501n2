package com.codefellows;

import java.util.ArrayList;

public class MobileDeviceWebService extends ElectronicDevice implements IComplexWebService {
    public String serveContent() {
        return "some content";
    }

    public MobileDeviceWebService() {
        super("mobile service");
    }

    public String getDeviceInfo() {
        return null;
    }

    public void doSomethingComplicated() {

    }

    public ArrayList<Person> getAllPeople() {
        ArrayList<Person> people = new ArrayList<Person>();

        people.add(getPerson(1));
        // add other people


        return people;
    }

    public Person getPerson(int id) {
        Person p = Person.builder()
                .age(25)
                .city("Seattle, WA")
                .favoriteColor("Blue")
                .name("Brad")
                .build();

        return p;
    }
}
