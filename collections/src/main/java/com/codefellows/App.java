package com.codefellows;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class App
{
    public static void main( String[] args ) throws Exception
    {
        int[] myInts = {1, 2, 3, 4, 5};

        List myIntegers = new ArrayList();
        List otherInts = new ArrayList();

        myIntegers.add(5);
        myIntegers.add(3);
        myIntegers.add("someString");

        otherInts.add(1);
        otherInts.add(0);

        otherInts.get(0);

        for (Object i : myIntegers) {
            System.out.println(i);
        }

        Set<Integer> intSet = new TreeSet<>();

        intSet.add(1);
        intSet.add(-5);
        intSet.add(0);
        intSet.add(-5);

        for (Integer i : intSet) {
            System.out.println(i);
        }

        Map<String, Integer> ages = new HashMap<>();

        ages.put("Brad", 25);
        ages.put("Katie", 26);

        for (String key : ages.keySet()) {
            System.out.println(String.format("%s is %d", key, ages.get(key)));
        }

        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(5);
        stack.push(6);
        System.out.println(stack.pop());

        Deque<Integer> queue = new ArrayDeque<>();

        queue.add(5);
        queue.add(6);
        System.out.println(queue.remove());

        //myIntegers.add(new Integer(5));

        List<String> names = new ArrayList<>();

        names.add("Darcy");
        names.add("Edwin");
        names.add("Brad");
        names.add("Art");
        names.add("Aaron");

        Collections.sort(names, (s1, s2) -> {
            if (s1.length() < s2.length()) {
                return -1;
            }

            return 1;
        });

        for (String s : names) {
            System.out.println(s);
        }

        try {
            exceptionsDemo();
        } catch (Exception ex) {

        }
    }

    private static void exceptionsDemo() throws CodeFellowsException {
        try {
            System.out.println("something interesting");
            //int x = 100 / 0;
            //InputStream is = new FileInputStream("/some/file/that/does/not/exist");
            //int[] myInts = {1, 2, 3};
            //System.out.println(myInts[5]);
            //throw new IOException();
        } catch (ArithmeticException ex) {
            System.out.println("Arithmetic exception");
            throw ex;
        } catch (RuntimeException ex) {
            throw new CodeFellowsException("some message", ex);
            //System.out.println("Runtime exception");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Finally!");
        }

        InputStream is = null;

        try {
            is = new FileInputStream("src/main/resources/somefile.txt");
        } catch (IOException ex) {

        } finally {
            //is.close();
        }

        //InputStream is;

//        try (is = new FileInputStream("src/main/resources/somefile.txt")) {
//            is.read();
//            //is.close();
//        } catch (FileNotFoundException ex) {
//
//        } catch (IOException ex) {
//            is.close();
//        }

        try {
            int z = 100/0;
        } catch (ArithmeticException ex) {
            throw ex;
            //throw new CodeFellowsException("why did you divide by 0?", ex);
        }
    }

    private static class NameSorter implements Comparator<String> {
        public int compare(String s1, String s2) {
            //(new Integer(s1.length())).compareTo(s2.length());

            if (s1.length() < s2.length()) {
                return -1;
            }

            return 1;
        }
    }
}
