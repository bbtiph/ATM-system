package kz.iitu.lw1;

public class Account {
    private int id;
    private String ownerFullName;
    private String account;
    private String pin;
    private double balance;

    public Account(int id, String ownerFullName, String account, String pin, double balance) {
        this.id = id;
        this.ownerFullName = ownerFullName;
        this.account = account;
        this.pin = pin;
        this.balance = balance;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public int getId() {
        return id;
    }

    public String getOwnerFullName() {
        return ownerFullName;
    }

    public String getAccount() {
        return account;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
