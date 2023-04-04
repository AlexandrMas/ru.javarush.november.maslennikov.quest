import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.javarush.november.maslennikov.quest.gamer.Gamer;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GamerTest {

    @ParameterizedTest
    @ValueSource(ints = {-3, 0, 3})
    void increaseNumberGamesPlayedShouldSettNumberOfGamesPlayedOneMore(int numberOfGamesPlayed) {
        Gamer gamer = Gamer.builder().build();
        gamer.setNumberOfGamesPlayed(numberOfGamesPlayed);
        gamer.increaseNumberGamesPlayed();
        int actual = gamer.getNumberOfGamesPlayed();
        int expected = numberOfGamesPlayed + 1;
        assertEquals(expected, actual);
    }
}
