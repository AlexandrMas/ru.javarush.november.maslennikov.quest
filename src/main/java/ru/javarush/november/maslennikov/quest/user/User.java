package ru.javarush.november.maslennikov.quest.user;

import lombok.Data;

@Data
public class User {

    private final String name;

    private final String ip;

    private int numberOfGamesPlayed;

    public User(String name, String ip) {
        this.name = name;
        this.ip = ip;
    }
}
