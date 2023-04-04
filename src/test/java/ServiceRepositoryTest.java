import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.javarush.november.maslennikov.quest.entity.Action;
import ru.javarush.november.maslennikov.quest.repository.ActionRepository;
import ru.javarush.november.maslennikov.quest.repository.ServiceRepository;

import java.lang.reflect.Field;

import static java.util.Objects.nonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ServiceRepositoryTest {
    static ServiceRepository service;

    @BeforeAll
    static void createNewServiceRepository() {
        service = new ServiceRepository();
    }

    @Test
    void serviceRepositoryConstructorShouldToCreateNewActionRepository() {
        try {
            Field actionRepository = ServiceRepository.class.getDeclaredField("repository");
            actionRepository.setAccessible(true);
            boolean expected = nonNull(actionRepository.get(service));
            assertTrue(expected);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 2})
    void setCurrentActionToStartShouldAssignTheFieldIdCurrenActionTheValueIdInitialAction(int id) {
        service.setIdCurrenAction(id);
        service.setCurrentActionToStart();
        try {
            Field idInitialAction = ServiceRepository.class.getDeclaredField("ID_INITIAL_ACTION");
            Field idCurrenAction = ServiceRepository.class.getDeclaredField("idCurrenAction");
            idInitialAction.setAccessible(true);
            idCurrenAction.setAccessible(true);
            assertEquals(idInitialAction.get(service), idInitialAction.get(service));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 7})
    void getActionByIdShouldReturnActionFromActionRepositoryWithIdSpecifiedInParameter(int id) {
        Action action = service.getActionById(id);
        assertEquals(id, action.getId());
    }

    @ParameterizedTest
    @ValueSource(ints = {0})
    void getActionByIdShouldThrowRuntimeException(int id) {
        assertThrows(RuntimeException.class, () -> service.getActionById(id));
    }

    @ParameterizedTest
    @ValueSource(ints = {0})
    void getActionByIdShouldThrowRuntimeExceptionWithMessageNoActionWithId(int id) {
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> service.getActionById(id));
        String expected = "no action with id " + id;
        assertEquals(expected, runtimeException.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 2})
    void getCurrentActionShouldReturnCurrentAction(int id) {
        service.setIdCurrenAction(id);
        Action currentAction = service.getCurrentAction();
        boolean expected = currentAction == service.getActionById(id);
        assertTrue(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"yes", "no"})
    void getIdNextActionShouldReturnIdNextActionOnStringResponse(String answer) {
        try {
            Field actionRepository = ServiceRepository.class.getDeclaredField("repository");
            actionRepository.setAccessible(true);
            ActionRepository repository = (ActionRepository) actionRepository.get(service);
            for (Action repositoryOfAction : repository.getRepositoryOfActions()) {
                if (repositoryOfAction.getAnswersForNextActionId().isEmpty()) {
                    continue;
                }
                service.setIdCurrenAction(repositoryOfAction.getId());
                assertEquals(service.getIdNextAction(answer),
                        repositoryOfAction.getAnswersForNextActionId().get(answer));
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
