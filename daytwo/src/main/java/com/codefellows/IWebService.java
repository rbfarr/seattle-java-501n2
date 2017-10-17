package com.codefellows;

import java.util.ArrayList;

public interface IWebService {
    ArrayList<Person> getAllPeople();
    Person getPerson(int id);
}
