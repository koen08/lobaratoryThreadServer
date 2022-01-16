package com.lobaratory.thread;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ManyThreadServer extends Server {
    private Map<Client, Socket> connectedClients = new ConcurrentHashMap<>();

    @Override
    public void processClient() throws IOException {
        Socket clientSocket;
        while ((clientSocket = serverSocket.accept()) != null) {
            countClient.addAndGet(1);
            long id = countClient.longValue();
            connectedClients.putIfAbsent(new Client(id), clientSocket);
        }
    }
}