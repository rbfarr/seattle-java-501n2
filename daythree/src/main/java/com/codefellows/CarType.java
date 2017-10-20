package com.codefellows;

public enum CarType {
    SEDAN("four-door car"),
    COUPE("two-door car");

    String description;

    CarType(String description) {
        this.description = description;
    }

    String getDescription() {
        return description;
    }
}
