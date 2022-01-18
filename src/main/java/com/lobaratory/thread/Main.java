package com.lobaratory.thread;

import java.io.IOException;

public class Main {
    static Log log = new Log(Main.class.getName(), Thread.currentThread().getName());

    public static void main(String[] args) {
        try {
            log.info("Server starting work...");
            Server server = new ManyThreadServer();
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
