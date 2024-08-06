package com.consciousconduit.projects.jbudge;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<User>();
        User user = new User("JHK");
        CashAccount ca = new CashAccount("Chase Checking", "1234", 0.0);
        user.addAccount(ca);
        Transaction transaction = new Transaction(
            "Initial transfer",
            100.0,
            null,
            ca.getId()
        );
        user.addTransaction(transaction);
        users.add(user);
        printUsers(users);

        PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
            .allowIfSubType("com.consciousconduit.projects.jbudge")
            .allowIfSubType("java.util.ArrayList")
            .build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.activateDefaultTyping(ptv, ObjectMapper.DefaultTyping.NON_FINAL);

        System.out.println("Saving " + users.size() + " users.......");
        saveUsers(users, mapper);
        System.out.println("Saved users........");

        System.out.println("Attempting to read users");
        users = readUsers(mapper);
        printUsers(users);
    }

    public static void printUsers(ArrayList<User> users) {
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    public static void saveUsers(
        ArrayList<User> users,
        ObjectMapper objectMapper
    ) {
        try {
            File targetDir = new File("target/users");
            if (!targetDir.exists()) {
                targetDir.mkdirs();
            }
        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
        for (User user : users) {
            saveUser(user, objectMapper);
        }
    }

    public static void saveUser(User user, ObjectMapper objectMapper) {
        try {
            objectMapper.writeValue(
                new File("target/users/" + user.getId() + ".json"),
                user
            );
        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }

    public static ArrayList<User> readUsers(ObjectMapper objectMapper) {
        ArrayList<User> users = new ArrayList<User>();
        try {
            File dir = new File("target/users");
            File[] files = dir.listFiles(
                new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return name.toLowerCase().endsWith(".json");
                    }
                }
            );
            for (File file : files) {
                User user = objectMapper.readValue(file, User.class);
                users.add(user);
            }
        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
        return users;
    }
}
