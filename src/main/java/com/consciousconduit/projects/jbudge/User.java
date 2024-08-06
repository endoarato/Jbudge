package com.consciousconduit.projects.jbudge;

import java.util.ArrayList;
import java.util.UUID;

public class User {

    private UUID id;
    private String name;
    private ArrayList<Account> accounts;

    public User(String name) {
        this.id = UUID.randomUUID();
        setName(name);
        setAccounts(accounts);
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
    }
}
