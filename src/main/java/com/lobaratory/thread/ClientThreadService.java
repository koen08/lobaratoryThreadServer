package com.lobaratory.thread;

import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;

public class ClientThreadService extends Thread {
    Log log = new Log(getClass().getName(), Thread.currentThread().getName());
    private ClientInfo clientInfo;
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    ClientThreadService(ClientInfo clientInfo, Socket socket) throws IOException {
        this.clientInfo = clientInfo;
        this.socket = socket;
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    @Override
    public void run() {
        while (true) {
            try {
                DropCashDto dropCashDto = new Gson().fromJson(bufferedReader.readLine(), DropCashDto.class);
                log.info(dropCashDto.toString());
                ClientThreadService clientThreadService =
                        ClientStorage.getInstance().getUserById(dropCashDto.getToUserId());
                ClientInfo toUser = clientThreadService.getClientInfo();
                int balanceCurrent = toUser.getBalance();
                toUser.setBalance(balanceCurrent + dropCashDto.getCash());
                BalanceDto balanceDto = new BalanceDto(dropCashDto.getFromUserId(), toUser.getBalance());
                String msg = new Gson().toJson(balanceDto, BalanceDto.class);
                clientThreadService.sendMsg(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void sendMsg(String msg) {
        try {
            bufferedWriter.write(msg);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            log.info("Fail to sendMsg... with msg = " + msg);
            e.printStackTrace();
        }
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }
}
