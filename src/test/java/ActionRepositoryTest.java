import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.javarush.november.maslennikov.quest.repository.ActionRepository;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class ActionRepositoryTest {

    @ParameterizedTest
    @CsvSource({"3, 2", "4, 5",})
    void setIdForNextActionShouldReturnHashMapWhereKeysAreYesAndNoStringsAndValuesArePassedParameters
            (int idActionForPositiveAnswer, int idActionForNegativeAnswer) {

        Map<String, Integer> expectedMap = new HashMap<>();
        try {
            Field yes = ActionRepository.class.getDeclaredField("POSITIVE_ANSWER");
            Field no = ActionRepository.class.getDeclaredField("NEGATIVE_ANSWER");
            Method method =
                    ActionRepository.class.getDeclaredMethod("setIdForNextAction", int.class, int.class);
            yes.setAccessible(true);
            no.setAccessible(true);
            method.setAccessible(true);
            expectedMap.put((String) yes.get(ActionRepository.class), idActionForPositiveAnswer);
            expectedMap.put((String) no.get(ActionRepository.class), idActionForNegativeAnswer);

            assertEquals(expectedMap, method.invoke(mock(ActionRepository.class),
                    idActionForPositiveAnswer, idActionForNegativeAnswer));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException | IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void setNoNextActionShouldReturnEmptyHashMap() {
        try {
            Method method =
                    ActionRepository.class.getDeclaredMethod("setNoNextAction");
            method.setAccessible(true);
            Map<String, Integer> expectedMap = new HashMap<>();
            assertEquals(expectedMap, method.invoke(mock(ActionRepository.class)));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
