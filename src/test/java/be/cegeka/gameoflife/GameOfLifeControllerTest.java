package be.cegeka.gameoflife;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class GameOfLifeControllerTest {

    @Test
    public void GivenWorld_WhenGetWorld_NewGenerationIsReturned() {
        List<List<Boolean>> newWorld = new GameOfLifeController().getWorld(Arrays.asList(
            Arrays.asList(true, false, true),
            Arrays.asList(false, true, false),
            Arrays.asList(true, false, true)));

        Assertions.assertThat(newWorld.get(0)).containsExactly(false, true, false);
        Assertions.assertThat(newWorld.get(1)).containsExactly(true, false, true);
        Assertions.assertThat(newWorld.get(2)).containsExactly(false, true, false);
    }
}
