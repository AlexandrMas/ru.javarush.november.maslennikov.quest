package ru.javarush.november.maslennikov.quest.filter;

public class UserCheck {

    public boolean checkName(String name) {
        boolean empty = name.trim().isEmpty() || name.isEmpty() || name.isBlank();
        if (empty) {
            return false;
        }
        for (char c : name.toCharArray()) {
            if (Character.isLetter(c)) {
                continue;
            }
            return false;
        }
        return true;
    }
}
