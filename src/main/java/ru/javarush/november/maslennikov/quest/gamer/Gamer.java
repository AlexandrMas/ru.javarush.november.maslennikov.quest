package ru.javarush.november.maslennikov.quest.gamer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Gamer {
    private final String name;
    private final String ip;
    private int numberOfGamesPlayed;

    public void increaseNumberGamesPlayed() {
        numberOfGamesPlayed++;
    }
}
