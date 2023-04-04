package ru.javarush.november.maslennikov.quest.repository;

import ru.javarush.november.maslennikov.quest.entity.Action;

public class ServiceRepository {
    private final ActionRepository repository;
    private static final int ID_INITIAL_ACTION = 1;
    private int idCurrenAction;

    public ServiceRepository() {
        this.repository = new ActionRepository();
    }

    public void setIdCurrenAction(int idCurrenAction) {
        this.idCurrenAction = idCurrenAction;
    }

    public void setCurrentActionToStart() {
        setIdCurrenAction(ID_INITIAL_ACTION);
    }

    public Action getActionById(int id) {
        for (Action repositoryOfAction : repository.getRepositoryOfActions()) {
            if (repositoryOfAction.getId() == id) {
                return repositoryOfAction;
            }
        }
        throw new RuntimeException("no action with id " + id);
    }

    public Action getCurrentAction() {
        return getActionById(idCurrenAction);
    }

    public int getIdNextAction(String answer) {
        return getCurrentAction().getAnswersForNextActionId().get(answer);
    }
}
