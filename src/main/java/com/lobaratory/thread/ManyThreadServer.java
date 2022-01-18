package com.lobaratory.thread;

import java.io.IOException;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ManyThreadServer extends Server {
    private Log log = new Log(getClass().getName(), Thread.currentThread().getName());
    private final int DEFAULT_CASH = 1;

    @Override
    public void processClient() throws IOException {
        Socket clientSocket;
        while ((clientSocket = serverSocket.accept()) != null) {
            countClient.addAndGet(1);
            long id = countClient.longValue();
            ClientInfo clientInfo = new ClientInfo(id, DEFAULT_CASH);
            ClientThreadService clientThread = new ClientThreadService(clientInfo, clientSocket);
            ClientStorage.getInstance().putUser(id, clientThread);
            clientThread.start();
            log.info("User with id = " + id + " was connected");
        }
    }
}
