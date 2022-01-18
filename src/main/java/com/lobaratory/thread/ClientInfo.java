package com.lobaratory.thread;

public class ClientInfo {
    private long id;
    private int balance;

    public ClientInfo(long id, int cash) {
        this.id = id;
        this.balance = cash;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
