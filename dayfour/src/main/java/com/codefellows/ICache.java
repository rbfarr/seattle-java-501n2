package com.codefellows;

public interface ICache<T> {
    void add(T objToAdd);
    T get();
}
