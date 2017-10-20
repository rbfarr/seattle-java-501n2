package com.codefellows;

public class StringCache implements ICache<String> {
    public void add(String string) {
        System.out.println(String.format("string: %s added to cache", string));
    }

    public String get() {
        return null;
    }
}
