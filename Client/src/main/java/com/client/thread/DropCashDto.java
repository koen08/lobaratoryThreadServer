package com.client.thread;

public class DropCashDto {
    private long fromUserId;
    private long toUserId;
    private int cash;

    public DropCashDto(long fromUserId, long toUserId, int cash) {
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.cash = cash;
    }

    public long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public long getToUserId() {
        return toUserId;
    }

    public void setToUserId(long toUserId) {
        this.toUserId = toUserId;
    }

    public DropCashDto(int cash) {
        this.cash = cash;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "DropCashDto{" +
                "fromUserId=" + fromUserId +
                ", toUserId=" + toUserId +
                ", cash=" + cash +
                '}';
    }
}
