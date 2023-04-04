package ru.javarush.november.maslennikov.quest.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Builder
@Data
public class Action {
    private final Integer id;
    private final String headString;
    private final String message;
    private final Map<String, Integer> answersForNextActionId;
}
