package com.consciousconduit.projects.jbudge;

import java.util.UUID;

public class Transaction {

    private UUID id;
    private String description;
    private double amount;
    private UUID from;
    private UUID to;

    public Transaction(String description, double amount, UUID from, UUID to) {
        this.id = UUID.randomUUID();
        setDescription(description);
        setAmount(amount);
        setFrom(from);
        setTo(to);
    }

    public Transaction(String description) {
        this(description, 0.0, null, null);
    }

    public Transaction() {
        this("", 0.0, null, null);
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setFrom(UUID from) {
        this.from = from;
    }

    public void setTo(UUID to) {
        this.to = to;
    }

    public UUID getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public double getAmount() {
        return this.amount;
    }

    public UUID getFrom() {
        return this.from;
    }

    public UUID getTo() {
        return this.to;
    }

    @Override
    public String toString() {
        return String.format(
            "Transaction:\nID: %s\nDescription: %s\nAmount: %.2f\nFrom: %s\nTo: %s\n",
            this.id,
            this.description,
            this.amount,
            this.from,
            this.to
        );
    }
}
