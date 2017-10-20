package com.codefellows;

import com.codefellows.admintools.CourseManager;
import com.codefellows.admintools.Instructor;
import com.codefellows.admintools.StudentManager;
import com.codefellows.admintools.anotherpackage.SomethingElse;
import com.google.MailService;
import java.util.ArrayList;

/* import static allows you to access static methods in the global namespace, e.g. instead of
Math.random(), you can use random() directly. */

import static java.lang.Math.random;

public class App
{
    public static void main( String[] args )
    {
        String name = args[0];
        System.out.println("Hello: " + name);

        // --verbosity=INFO --mailservice-endpoint="https://my-mailservice.google.com"

        MailService ms = new MailService();

        CourseManager cm = new CourseManager();
        StudentManager sm = new StudentManager();

        SomethingElse se = new SomethingElse();

        // Integer types
        byte b1 = 127;

        byte b2 = (byte) 0b11111111;
        byte b3 = (byte) 0xFF;

        //short s =
        int i = 100;
        long l = 150L;

        float myFloat = 5.0f;
        double myDouble = 5.0;

        long reallyBigInt = 1_000_000_000;

        // +-*/
        // %, ++, --

        int n = 5;
        int x = ++n;

        System.out.println("x is: " + x);
        String formatString = String.format("My name is %s. Age: %d", name, 25);

        boolean someTest = true || false; // && ||, & |

        int myInt = 0x000000F0;       // 11110000
        int myOtherInt = 0x0000000F;  // 00001111

        int printThisInt = myInt & myOtherInt;

        System.out.println(String.format("%s", Integer.toHexString(printThisInt)));

        if (someTest) {
            System.out.println("someTest is true");
        }

        n = 6;
        x = 5;

        String eq;

//        if (n == x) {
//            eq = "equal";
//        } else {
//            eq = "not equal";
//        }

        eq = (n == x) ? "equal" : "not equal";
        System.out.println(eq);

        if (eq instanceof Object) {
            System.out.println("eq is an instance of Object");
        }

        String color = "blue";

        switch (color) {
            case "red":
                System.out.println("Red is my favorite color");
                break;
            case "blue":
                System.out.println("I also like blue");
                break;
            default:
                break;
        }

        for (int j = 0; j < 10; j++) {
            System.out.println(j);
        }

        //System.out.println(j);
        int j = 0;

        while (j < 10) {
            System.out.println(j);
            j++;
        }

        ArrayList<String> names = new ArrayList<>();

        names.add("Brad");
        names.add("Darcy");

        for (String personName : names) {
            System.out.println(personName);
        }

        char c = 's';

        String someStr = "Brad";

        String myStr = "My name is ";
        String myStr2 = new String("Brad"); // "Brad"
        String myStr3 = "Brad"; // "Brad"

        System.out.println(myStr + myStr2);

        if (myStr2 == myStr3) {
            System.out.println("equal ==");
        } else {
            System.out.println("not equal ==");
        }

        if (myStr2.equals(myStr3)) {
            System.out.println(".equals()");
        } else {
            System.out.println("not .equals()");
        }

        StringBuilder sb = new StringBuilder();

        sb.append("hello ");
        sb.append("world");

        String sbString = sb.toString();
        System.out.println(sbString);

        Person p1 = new Person(null, 25, "000-00-0000"); // Person.Person("Brad") --> return a person object;
//        p.setName("Brad");

        Person p2 = new Person("Bob", 30);

        String name2 = "Bill";
        Person p3 = new Person(name2);

        Person p4 = p3; // p3 == p4 --> true

        System.out.println(p1.getName());

        Person p5 = new Person("Brad");
        changePersonName(p5, "Jason");
        System.out.println(p5.getName());

        int z = 5;
        changeIntValue(z);

        System.out.println(z);

        int result = (int) (5 / 2.0); // truncates 2.5 to 2
        System.out.println(result);

        //Object o = new StringBuilder();
        System.out.println(p5); // print Jason

        // Object --> .toString() and .equals()

        Person person1 = new Person("Brad");
        Person person2 = new Person("Brad");

        if (person1.equals(person2)) {
            System.out.println("same person");
        }

        ArrayList<Person> people = new ArrayList<>();

        Person person3 = new Student("Bob");
        Person person4 = new Instructor("Brad");

        people.add(person3);
        people.add(person4);

        for (Person p : people) {
            System.out.println(p.getName());

            if (p instanceof Student) {
                Student s = (Student) p;
                System.out.println("gpa: " + s.getAvgGPA());
            } else if (p instanceof Instructor) {

            } else {

            }
        }

        printInts(1, 2, 3, 4, 5, 6, 7);
        printInts(new int[] {1, 2, 3, 4, 5, 6, 7});

        String[] peopleNames = {"Brad", "Darcy", "Bob", "Bill"}; // Array
        peopleNames[1] = "George";

        for (i = 0; i < peopleNames.length; i++) {
            System.out.println(peopleNames[i]);
        }

        for (String pn : peopleNames) {
            System.out.println(pn);
        }

        //String[] peopleNames2 = new String[]{"Brad", "Whatever"};

        System.out.println(Person.getNumPeople());

        Math.abs(-5);
        Math.pow(2.0, 5.0);
        Math.ceil(5.4);

        random();

        String s = "my string";

        for (i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }
    }

    private static void printIntsArray(int[] myInts) {
        for (int i : myInts) {
            System.out.println(i);
        }
    }

    private static void printInts(int... myInts) {
        for (int i : myInts) {
            System.out.println(i);
        }
    }

    private static void changeIntValue(int myInt) {
        myInt = 7;
    }

    private static void changePersonName(Person p, String newName) {
        p.setName(newName);
    }
}
