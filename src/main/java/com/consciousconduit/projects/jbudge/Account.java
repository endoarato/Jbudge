package com.consciousconduit.projects.jbudge;

import java.util.UUID;

public abstract class Account {

    private UUID id;
    private String name;
    private String number;

    public Account(String name, String number) {
        this.id = UUID.randomUUID();
        setName(name);
        setNumber(number);
    }

    public Account(String name) {
        this(name, "");
    }

    public Account() {
        this("");
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return this.number;
    }

    @Override
    public String toString() {
        return String.format(
            "Account\nID: %s\nName: %s\nNumber: %s\n",
            this.id,
            this.name,
            this.number
        );
    }
}
