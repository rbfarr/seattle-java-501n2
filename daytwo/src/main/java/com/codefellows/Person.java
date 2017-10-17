package com.codefellows;

public class Person {
    private final int age;
    private final String name;
    private final String city;
    private final String favoriteColor;

    public Person(int age, String name, String city, String favoriteColor) {
        this.age = age;
        this.name = name;
        this.city = city;
        this.favoriteColor = favoriteColor;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int age;
        private String name;
        private String city;
        private String favoriteColor;

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder favoriteColor(String favoriteColor) {
            this.favoriteColor = favoriteColor;
            return this;
        }

        public Person build() {
            return new Person(age, name, city, favoriteColor);
        }
    }
}
