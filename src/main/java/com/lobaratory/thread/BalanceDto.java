package com.lobaratory.thread;

public class BalanceDto {
    private long fromUserId;
    private int balance;

    public BalanceDto(long fromUserId, int balance) {
        this.fromUserId = fromUserId;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(int fromUserId) {
        this.fromUserId = fromUserId;
    }
}
