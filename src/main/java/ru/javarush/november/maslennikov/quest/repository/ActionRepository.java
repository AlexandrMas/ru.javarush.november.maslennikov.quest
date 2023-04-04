package ru.javarush.november.maslennikov.quest.repository;

import ru.javarush.november.maslennikov.quest.entity.Action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionRepository {
    private final List<Action> repositoryOfActions;
    private static final String POSITIVE_ANSWER = "yes";
    private static final String NEGATIVE_ANSWER = "no";

    public ActionRepository() {
        repositoryOfActions = new ArrayList<>();
        fillRepository();
    }

    public List<Action> getRepositoryOfActions() {
        return repositoryOfActions;
    }

    private Map<String, Integer> setIdForNextAction(int idActionForPositiveAnswer,
                                                    int idActionForNegativeAnswer) {
        Map<String, Integer> nextAction = new HashMap<>();
        nextAction.put(POSITIVE_ANSWER, idActionForPositiveAnswer);
        nextAction.put(NEGATIVE_ANSWER, idActionForNegativeAnswer);
        return nextAction;
    }

    private Map<String, Integer> setNoNextAction() {
        return new HashMap<>();
    }

    private void fillRepository() {
        repositoryOfActions.add(Action.builder().
                id(1).
                answersForNextActionId(setIdForNextAction(3, 2)).
                headString(HEAD_TEXT_FOR_FIRST_TASK_PAGE).
                message(MESSAGE_FOR_ACTION_01).build());
        repositoryOfActions.add(Action.builder().
                id(2).
                answersForNextActionId(setNoNextAction()).
                headString(HEAD_TEXT_FOR_PAGE_BAD_JOB).
                message(MESSAGE_FOR_ACTION_02).build());
        repositoryOfActions.add(Action.builder().
                id(3).
                answersForNextActionId(setIdForNextAction(4, 5)).
                headString(HEAD_TEXT_FOR_TRANSIT_PAGE).
                message(MESSAGE_FOR_ACTION_03).build());
        repositoryOfActions.add(Action.builder().
                id(4).
                answersForNextActionId(setNoNextAction()).
                headString(HEAD_TEXT_FOR_PAGE_BAD_JOB).
                message(MESSAGE_FOR_ACTION_04).build());
        repositoryOfActions.add(Action.builder().
                id(5).
                answersForNextActionId(setIdForNextAction(6, 7)).
                headString(HEAD_TEXT_FOR_TRANSIT_PAGE).
                message(MESSAGE_FOR_ACTION_05).build());
        repositoryOfActions.add(Action.builder().
                id(6).
                answersForNextActionId(setNoNextAction()).
                headString(HEAD_TEXT_FOR_PAGE_BAD_JOB).
                message(MESSAGE_FOR_ACTION_06).build());
        repositoryOfActions.add(Action.builder().
                id(7).
                answersForNextActionId(setIdForNextAction(8, 9)).
                headString(HEAD_TEXT_FOR_TRANSIT_PAGE).
                message(MESSAGE_FOR_ACTION_07).build());
        repositoryOfActions.add(Action.builder().
                id(8).
                answersForNextActionId(setNoNextAction()).
                headString(HEAD_TEXT_FOR_PAGE_BAD_JOB).
                message(MESSAGE_FOR_ACTION_08).build());
        repositoryOfActions.add(Action.builder().
                id(9).
                answersForNextActionId(setIdForNextAction(11, 10)).
                headString(HEAD_TEXT_FOR_TRANSIT_PAGE).
                message(MESSAGE_FOR_ACTION_09).build());
        repositoryOfActions.add(Action.builder().
                id(10).
                answersForNextActionId(setNoNextAction()).
                headString(HEAD_TEXT_FOR_PAGE_BAD_JOB).
                message(MESSAGE_FOR_ACTION_10).build());
        repositoryOfActions.add(Action.builder().
                id(11).
                answersForNextActionId(setNoNextAction()).
                headString(HEAD_TEXT_FOR_PAGE_GOD_JOB).
                message(MESSAGE_FOR_ACTION_11).build());
    }

    private static final String HEAD_TEXT_FOR_FIRST_TASK_PAGE = "Твое первое задание. Справишься?";
    private static final String HEAD_TEXT_FOR_TRANSIT_PAGE = "У тебя хорошо получается, продолжай!";
    private static final String HEAD_TEXT_FOR_PAGE_BAD_JOB = "Ты провалил задание!";
    private static final String HEAD_TEXT_FOR_PAGE_GOD_JOB = "Молодец задание выполнено!";

    private static final String MESSAGE_FOR_ACTION_01 = "Так случилось, " +
            "что в твой первый рабочий день" + "<br>" +
            " у друга босса полиции, который работает очень уважаемым человеком," + "<br>" +
            " пропал его любимый кот по кличке \"Апельсин\" " + "<br>" +
            "и дело о розыске кота предложили расследовать тебе." + "<br>" + "<br>" +
            " Взяться за это дело?";
    private static final String MESSAGE_FOR_ACTION_02 =
            "Босс остался недоволен твоей работой и перевел тебя в постовые.<br><br>";
    private static final String MESSAGE_FOR_ACTION_03 =
            "Расследуя дело по загадочному исчезновению кота Апельсина, " + "<br>" +
                    "тебе показалось подозрительным поведение садовника," + "<br>" +
                    "который работал в доме друга босса полиции. " + "<br>" +
                    "Ты захотел допросить садовника, но чувствовал подвох. " + "<br>" + "<br>" +
                    "Допросить садовника? <br>";
    private static final String MESSAGE_FOR_ACTION_04 =
            "Садовник оказался почетным работником дома и пользовался непоколебимым авторитетом. " + "<br>" +
                    "Он пожаловался хозяину о том, что ты хотел его допросить. " + "<br>" +
                    "Босс полиции остался недоволен твоей работой и перевел тебя в постовые.<br> ";
    private static final String MESSAGE_FOR_ACTION_05 =
            "В ходе расследования дела к тебе обратился повар дома " + "<br>" +
                    "который предложил денежное вознаграждение за то," + "<br>" +
                    " что ты прекратишь поиски кота и спустишь это дело на тормозах," + "<br>" +
                    "повар не любил Апельсина потому что этот рыжий постоянно воровал мясо со стола. " + "<br>" +
                    "Предположения детектива: " +
                    "Вероятнее всего, повар сам был не прочь стащить кусок мяса у хозяина," +
                    " поэтому устранял конкурента. " + "<br>" + "<br>" +
                    "Пойти на соглашение с поваром? <br>";
    private static final String MESSAGE_FOR_ACTION_06 =
            "Боссу полиции стало известно о твоём заговоре с поваром. " + "<br>" +
                    "Босс остался недоволен твоей работой и перевел тебя в постовые. " + "<br>" +
                    "И вообще, коррупция это плохо.<br>";
    private static final String MESSAGE_FOR_ACTION_07 =
            "Учитывая негативное отношение повара к Апельсину, у тебя возникло предчувствие, " + "<br>" +
                    "что повар мог быть причастен к исчезновению кота и спрятать его где-то на кухне. " +
                    "<br>" + "<br>" +
                    "Обследовать кухню?<br>";
    private static final String MESSAGE_FOR_ACTION_08 =
            "При обследовании кухни, ты своим плащом зацепил ящик, стоящий на столе, " + "<br>" +
                    "заполненный бутылками дорогого коллекционного шампанского," + "<br>" +
                    " которое предназначалось для празднования юбилея жены гражданина, " +
                    "работающего уважаемым человеком." + "<br>" +
                    " Всё шампанское было разбито. " + "<br>" +
                    "Босс остался недоволен твоей работой и перевел тебя в постовые. " + "<br>" +
                    "Чтобы расплатиться за разбитое шампанское ты взял кредит на 10 лет.<br>";
    private static final String MESSAGE_FOR_ACTION_09 =
            "Ты решил допросить соседа из дома напротив," + "<br>" +
                    "который в ходе допроса рассказал, " + "<br>" +
                    "что последний раз видел Апельсина со своего балкона," + "<br>" +
                    " в гараже дома гражданина, работающего уважаемым человеком." + "<br>" + "<br>" +
                    "Обследовать гараж?<br>";
    private static final String MESSAGE_FOR_ACTION_10 =
            "В этот же день садовник нашел кота в гараже дома, о чем сразу сообщил хозяину. " + "<br>" +
                    "Об этом узнал твой босс и отсчитал тебя," + "<br>" +
                    "за то тчо ты потратил кучу времени и бюджетных средств, но так и не нашел кота, " + "<br>" +
                    "который все время был у тебя под носом. " + "<br>" +
                    "Босс остался недоволен твоей работой и перевел тебя в постовые.<br>";
    private static final String MESSAGE_FOR_ACTION_11 =
            "При обследовании гаража ты нашел Апельсина, который прятался там от повара, " + "<br>" +
                    "повар постоянно гонял кота мокрыми тряпками за то, что тот тащил еду со стола. " + "<br>" +
                    "Расследуя это дело, ты вышел на след банды воров кошачьего корма" + "<br>" +
                    "и разоблачил банду, предводителем которой оказался садовник. " + "<br>" +
                    "Работа садовником была всего лишь его прикрытием для совершения злодеяний. " + "<br>" +
                    "Часть похищенного корма садовник прятал у хозяина в гараже," + "<br>" +
                    "как раз этим кормом и питался Апельсин, когда прятался от повара. " + "<br>" +
                    "За разоблачение банды," + "<br>" +
                    "которая держала в ужасе всех продавцов кошачьего корма в городе несколько лет," + "<br>" +
                    "тебе торжественно вручили грамоту.";
}
