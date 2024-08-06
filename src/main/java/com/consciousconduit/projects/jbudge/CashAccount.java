package com.consciousconduit.projects.jbudge;

public class CashAccount extends Account {

    private double balance;
    private double minBalance;

    public CashAccount(
        String name,
        String number,
        double balance,
        double minBalance
    ) {
        super(name, number);
        setBalance(balance);
        setMinBalance(minBalance);
    }

    public CashAccount(String name, String number, double balance) {
        CashAccount(name, number, balance, 0);
    }

    public CashAccount(String name, double balance) {
        CashAccount(name, "", balance, 0);
    }

    public CashAccount(String name, String number) {
        CashAccount(name, number, 0, 0);
    }

    public CashAccount(String name) {
        CashAccount(name, "", 0, 0);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public double getMinBalance() {
        return minBalance;
    }
}
