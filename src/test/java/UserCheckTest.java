import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.javarush.november.maslennikov.quest.filter.UserCheck;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserCheckTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n", "\t", "<", ">", "/", "\"", ";", " name ", "name1"})
    void checkNameShouldReturnFalse(String name) {
        UserCheck userCheck = new UserCheck();
        boolean expected = userCheck.checkName(name);
        assertFalse(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"name", "n", "Name", "NAME"})
    void checkNameShouldReturnTrue(String name) {
        UserCheck userCheck = new UserCheck();
        boolean expected = userCheck.checkName(name);
        assertTrue(expected);
    }
}
