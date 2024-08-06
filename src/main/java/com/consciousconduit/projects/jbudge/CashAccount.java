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
        this(name, number, balance, 0.0);
    }

    public CashAccount(String name, double balance) {
        this(name, "", balance, 0.0);
    }

    public CashAccount(String name, String number) {
        this(name, number, 0.0, 0.0);
    }

    public CashAccount(String name) {
        this(name, "", 0.0, 0.0);
    }

    public CashAccount() {
        this("");
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

    @Override
    public String toString() {
        return (
            super.toString() +
            String.format(
                "Balance: %.2f\nMin Balance: %.2f\n",
                this.balance,
                this.minBalance
            )
        );
    }
}
