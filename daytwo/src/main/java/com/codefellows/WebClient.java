package com.codefellows;

import java.util.ArrayList;

public class WebClient {
    private IWebService ws;

    public WebClient(IWebService ws) {
        this.ws = ws;
    }

    public ArrayList<Person> getAllPeople() {
        return ws.getAllPeople();
    }
}
