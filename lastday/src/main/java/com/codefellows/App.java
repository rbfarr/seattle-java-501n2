package com.codefellows;


import com.google.common.util.concurrent.RateLimiter;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class App
{
    public static void main( String[] args ) throws IOException
    {
        FileSystem fs = FileSystems.getDefault();
        Path p1 = fs.getPath("lastday/src/main/resources/input.txt-renamed");

        System.out.format("getFileName: %s%n", p1.getFileName());
        System.out.format("getParent: %s%n", p1.getParent());
        System.out.format("getNameCount: %d%n", p1.getNameCount());
        System.out.format("getRoot: %s%n", p1.getRoot());
        System.out.format("isAbsolute: %b%n", p1.isAbsolute());
        System.out.format("toAbsolutePath: %s%n", p1.toAbsolutePath());
        System.out.format("toURI: %s%n", p1.toUri());
        System.out.format("normalize: %s%n", p1.normalize());

        Path p2 = p1.subpath(2, 4);
        System.out.println(p2);

        Path p3 = p1.getParent().resolve("subdirectory");
        System.out.println(p3);

        Path p4 = p3.resolve("input.txt");

        //Files.createSymbolicLink(p4, p1);

        if (Files.isReadable(p1)) {
            System.out.println("readable");
        }

//        if (Files.isSameFile(p1, p4)) {
//            System.out.println("same file");
//        }

        //traversePath(Files.list(p1.getParent()));

        List<String> input = Files.readAllLines(p1);

        for (String line : input) {
            System.out.println(line);
        }

        ExecutorService es = Executors.newCachedThreadPool();

        es.execute(new HttpServer(es, 8080));

        es.execute(() -> {
            while (true) IntCounter.increment();
        });

        es.execute(() -> {
            while (true) IntCounter.increment();
        });

        es.execute(() -> {
            while (true) IntCounter.decrement();
        });

        es.execute(() -> {
            while (true) IntCounter.decrement();
        });

        es.execute(() -> {
            while (true) IntCounter.add(5);
        });

        RateLimiter rl = RateLimiter.create(1.0);

        while (true) {
            rl.acquire();
            System.out.println(IntCounter.remove());
        }

        //es.shutdown();
    }

    private static void traversePath(Stream<Path> directory) {
        directory.forEach(f -> {
            try {
                if (Files.isDirectory(f)) {
                    traversePath(Files.list(f));
                } else {
                    Files.move(f, f.getParent().resolve(f.getFileName().toString() + "-renamed"));
                }
            } catch (IOException ex) {

            }
        });
    }
}
