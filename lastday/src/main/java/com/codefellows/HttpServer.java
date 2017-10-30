package com.codefellows;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class HttpServer implements Runnable {
    private final int port;
    private final ExecutorService es;

    public HttpServer(ExecutorService es, int port) {
        this.es = es;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("listening on port " + port);

            while (true) {
                try (Socket socket = server.accept()) {
                    Future<Date> today = es.submit(new DateCallable());
                    String response = "HTTP/1.1 200 OK\r\n\r\n" + today.get();
                    socket.getOutputStream().write(response.getBytes("UTF-8"));
                }
            }
        } catch (ExecutionException|InterruptedException ex) {
            System.out.println(ex.getCause());
        } catch (IOException ex) {

        }
    }
}
