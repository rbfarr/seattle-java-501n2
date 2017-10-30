package com.codefellows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class IntCounter {
    private static int value = 0;
    private static List<Integer> ints = new ArrayList<>();

    private static AtomicInteger ai = new AtomicInteger(0);

    private static List<Integer> ints2 = Collections.synchronizedList(new ArrayList<>());

    public void add(int i) {
        ints2.add(i);
    }

    public static int remove() {
        return ints2.remove(ints.size()-1);
    }

    public static void increment() {
        ai.incrementAndGet();
    }

    public static void decrement() {
        ai.decrementAndGet();
    }

    public synchronized static int getValue() {
        return value;
    }
}
