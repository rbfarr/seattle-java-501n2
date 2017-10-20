package com.codefellows;

public class ObjectCache<T> implements ICache<T> {
    T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}
