package com.lobaratory.thread;

import java.net.Socket;

public class ClientThread extends Thread {
    private ClientInfo clientInfo;
    private Socket socket;

    private ClientThread(ClientInfo clientInfo, Socket socket) {
        this.clientInfo = clientInfo;
        this.socket = socket;
    }

    @Override
    public void run() {

    }
}
