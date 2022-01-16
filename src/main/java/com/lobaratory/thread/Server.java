package com.lobaratory.thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Server {
    Log log = new Log(getClass().getName(), Thread.currentThread().getName());
    protected ServerSocket serverSocket;
    protected AtomicInteger countClient;

    public void start() throws IOException {
        serverSocket = new ServerSocket(8000);
        log.info("Server was started with port = " + 8000);
        processClient();
    }

    public abstract void processClient() throws IOException;
}
