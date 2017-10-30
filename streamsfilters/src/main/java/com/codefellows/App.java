package com.codefellows;


import com.google.common.util.concurrent.RateLimiter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App
{
    public static void main( String[] args )
    {
        List<String> strings = new ArrayList<>();

        strings.add("Brad");
        strings.add("Darcy");
        strings.add("Art");
        strings.add("Edwin");

        strings.forEach(e -> System.out.println(e.toUpperCase()));

        Function<String, Person> strToPerson = s -> new Person(s); //or Person::new

        List<Person> people = strings.stream()
                .map(strToPerson)
                .collect(Collectors.toList());

        UnaryOperator<String> toUpper = (s) -> s.toUpperCase();

        strings.stream().map(toUpper).forEach(e -> System.out.println(e));

        List<Person> filteredPeople = new ArrayList<>();

        people.stream()
                .filter(App::filterOutBrad)
                .peek(e -> System.out.println(e))
                .forEach(e -> filteredPeople.add(e));

                //.collect(Collectors.toList());

//        List<String> peopleNames = people.stream()
//                .map(String::new)
//                .collect(Collectors.toList());

        for (Person person : people) {
            System.out.println(person);
        }

        //people.stream().filter()


        people.stream().mapToInt(e -> e.getName().length()).forEach(e -> System.out.println(e));

        Supplier<String> sup = () -> new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

        RateLimiter limiter = RateLimiter.create(1.0);
        limiter.acquire();

//        for (int i = 0; i < 100; i++) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ex) {
//
//            }
//
//            System.out.println(sup.get());
//        }

        Optional<Person> op = people.stream().filter(e -> e.getName().equals("Art")).findFirst();

        if (op.isPresent()) {
            System.out.println(op.get());
        }

        Optional<String> os = Optional.of("test");
        System.out.println(os.get());

        people.stream()
                .map(p -> p.getName())
                .sorted((x, y) -> x.length() < y.length() ? 1:-1)
                .forEach(e -> System.out.println(e));

        people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(e -> System.out.println(e));

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
        integerStream.forEach(e -> System.out.println(e));

        IntStream intStream = IntStream.of(new int[] {1, 2, 3, 4, 5, 6});

        byte[] buffer = new byte[256];

        try (InputStream inputStream = new FileInputStream("streamsfilters/src/main/resources/test.txt")) {
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    System.out.println((char)buffer[i]);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Some other error: " + ex.getMessage());
        }

        final String pathPrefix = "streamsfilters/src/main/resources/";
        final String inputFile = pathPrefix + "test.txt";
        final String outputFile = pathPrefix + "testOut.txt";

        try {
            copyFile(new FileReader(inputFile), new FileWriter(outputFile));
        } catch (IOException ex) {

        }

        System.out.println(getConsoleInput());
    }

    private static String getConsoleInput() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("type exit");
            return br.readLine();
        } catch (IOException ex) {

        }

        return null;
    }

    private static void copyFile(FileReader fr, FileWriter fw) {
        try (BufferedReader br = new BufferedReader(fr);
             BufferedWriter bw = new BufferedWriter(fw)) {

            String line;

            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException ex) {

        }
    }

    private static int getStrLen(Person s) {
        return s.getName().length();
    }

    private static boolean filterOutBrad(Person s) {
        if (s.getName().equals("Brad")) {
            return false;
        }

        return true;
    }
}
