package com.consciousconduit.projects.jbudge;

import java.util.ArrayList;
import java.util.UUID;

public class User {

    private UUID id;
    private String name;
    private ArrayList<Account> accounts;
    private ArrayList<Transaction> transactions;

    public User(String name) {
        this.id = UUID.randomUUID();
        setName(name);
        setAccounts(new ArrayList<Account>());
        setTransactions(new ArrayList<Transaction>());
    }

    public User() {
        this("");
    }

    public void setUUID(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Account> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public void deleteAccount() {
        //TODO: to be implemented
        assert false : "Not yet implemented";
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public void deleteTransaaction() {
        //TODO: to be implemented
        assert false : "Not yet implemented";
    }

    @Override
    public String toString() {
        String output = String.format(
            "=============================\nUser\nID: %s\nName: %s\n",
            this.id,
            this.name
        );
        output += "Accounts:\n";
        for (Account account : accounts) {
            output += "----------------------\n";
            output += account.toString();
            output += "----------------------\n";
        }
        output += "Transactions:\n";
        for (Transaction transaction : transactions) {
            output += "-----------------------\n";
            output += transaction.toString();
            output += "-----------------------\n";
        }
        output += "\n==========================\n";
        return output;
    }
}
