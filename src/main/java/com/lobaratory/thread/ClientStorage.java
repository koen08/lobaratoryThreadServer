package com.lobaratory.thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClientStorage {
    private final Map<Long, ClientThreadService> connectedClients = new ConcurrentHashMap<>();
    private static ClientStorage clientStorage = new ClientStorage();

    public static ClientStorage getInstance() {
        return clientStorage;
    }

    public ClientThreadService getUserById(long id) {
        return connectedClients.get(id);
    }

    public void putUser(long id, ClientThreadService clientThreadService) {
        connectedClients.putIfAbsent(id, clientThreadService);
    }
}
