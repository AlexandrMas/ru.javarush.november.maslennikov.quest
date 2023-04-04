package ru.javarush.november.maslennikov.quest;

import ru.javarush.november.maslennikov.quest.gamer.Gamer;
import ru.javarush.november.maslennikov.quest.repository.ServiceRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.net.InetAddress.getLocalHost;
import static java.util.Objects.isNull;

@WebServlet(name = "QuestServlet", value = {"/start", "/restart", "/transit"})
public class QuestServlet extends HttpServlet {
    private Gamer gamer;
    private ServiceRepository service;
    private HttpSession session;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().equalsIgnoreCase("/start")) {
            doStart(request, response);
        } else if (request.getRequestURI().equalsIgnoreCase("/transit")) {
            doTransit(request, response);
        } else if (request.getRequestURI().equalsIgnoreCase("/restart")) {
            doRestart(request, response);
        }
    }

    public void doStart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (isNull(gamer)) {
            session = request.getSession(true);
            gamer = Gamer.builder().
                    name((request.getParameter("gamerName"))).
                    ip(getLocalHost().getHostAddress()).build();
            service = new ServiceRepository();
            service.setCurrentActionToStart();
            session.setAttribute("service", service);
            session.setAttribute("gamer", gamer);
        } else if (gamer.getName().equalsIgnoreCase(request.getParameter("gamerName"))) {
            service.setCurrentActionToStart();
        } else {
            gamer = Gamer.builder().
                    name((request.getParameter("gamerName"))).
                    ip(getLocalHost().getHostAddress()).build();
            session.setAttribute("gamer", gamer);
            service.setCurrentActionToStart();
        }
        request.getRequestDispatcher("jsp/transitAction.jsp").forward(request, response);
    }

    public void doTransit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String answer = request.getParameter("answer");
        int nextActionId = service.getIdNextAction(answer);
        service.setIdCurrenAction(nextActionId);
        if (service.getActionById(nextActionId).getAnswersForNextActionId().isEmpty()) {
            gamer.increaseNumberGamesPlayed();
            request.getRequestDispatcher("jsp/end.jsp").forward(request, response);
        }
        request.getRequestDispatcher("jsp/transitAction.jsp").forward(request, response);
    }

    public void doRestart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        service.setCurrentActionToStart();
        request.getRequestDispatcher("/").forward(request, response);
    }
}
