package ru.javarush.november.maslennikov.quest;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "QuestServlet", value = {"/start", "/restart", "/transit"})
public class QuestServlet extends HttpServlet {
}
