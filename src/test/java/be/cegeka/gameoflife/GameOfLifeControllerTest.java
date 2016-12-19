package be.cegeka.gameoflife;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class GameOfLifeControllerTest {

    private GameOfLifeController controller = new GameOfLifeController();

    @Test
    public void givenWorld_whenGetWorld_thenReturnEquallyLargeWorld() throws Exception {
        // given
        List<List<Boolean>> world = asList(
            asList(true, true, true, true),
            asList(true, true, true, true),
            asList(true, true, true, true),
            asList(true, true, true, true));

        // when
        List<List<Boolean>> result = controller.getWorld(world);

        // then
        assertThat(result).hasSize(4);
        assertThat(result.get(0)).hasSize(4);
        assertThat(result.get(1)).hasSize(4);
        assertThat(result.get(2)).hasSize(4);
        assertThat(result.get(3)).hasSize(4);
    }

    @Test
    public void givenBlinkerWorld_whenGetWorld_thenReturnOppositeBlinkerWorld() throws Exception {
        // given
        List<List<Boolean>> world = asList(
            asList(false, true, false),
            asList(false, true, false),
            asList(false, true, false));

        // when
        List<List<Boolean>> result = controller.getWorld(world);

        // then
        assertThat(result).containsExactly(asList(false, false, false), asList(true, true, true), asList(false, false, false));
    }

    @Test
    public void givenWorld_whenCountDeadNeighboursOfCell_thenReturnNumberOfDeadNeighbours() throws Exception {
        // given
        List<List<Boolean>> world = asList(
            asList(true, true, true),
            asList(true, true, true),
            asList(true, true, true));

        int numberOfDeadNeighbours = controller.countDeadNeighbours(world, 1, 1);

        Assertions.assertThat(numberOfDeadNeighbours).isEqualTo(0);
    }

    @Test
    public void givenWorld_whenCountDeadNeighboursOfCell_thenReturnNumberOfDeadNeighbours2() throws Exception {
        // given
        List<List<Boolean>> world = asList(
            asList(false, false, false),
            asList(false, false, false),
            asList(false, false, false));

        int numberOfDeadNeighbours = controller.countDeadNeighbours(world, 1, 1);

        Assertions.assertThat(numberOfDeadNeighbours).isEqualTo(8);
    }

    @Test
    public void givenWorld_whenCountDeadNeighboursOfCell_thenReturnNumberOfDeadNeighbours3() throws Exception {
        // given
        List<List<Boolean>> world = asList(
            asList(false, true, false),
            asList(false, false, false),
            asList(true, false, true));

        int numberOfDeadNeighbours = controller.countDeadNeighbours(world, 1, 1);

        Assertions.assertThat(numberOfDeadNeighbours).isEqualTo(5);
    }

    @Test
    public void givenWorld_whenCountDeadNeighboursOfCell_thenReturnNumberOfDeadNeighbours4() throws Exception {
        // given
        List<List<Boolean>> world = asList(
            asList(false, true, false),
            asList(false, false, false),
            asList(true, false, true));

        int numberOfDeadNeighbours = controller.countDeadNeighbours(world, 0, 0);

        Assertions.assertThat(numberOfDeadNeighbours).isEqualTo(7);
    }

    @Test
    public void givenWorld_whenCountDeadNeighboursOfCellAtUpperBounds_thenReturnNumberOfDeadNeighbours() throws Exception {
        // given
        List<List<Boolean>> world = asList(
            asList(false, true, false),
            asList(false, false, false),
            asList(true, false, true));

        int numberOfDeadNeighbours = controller.countDeadNeighbours(world, 2, 2);

        Assertions.assertThat(numberOfDeadNeighbours).isEqualTo(8);
    }

    @Test
    public void givenWorld_whenIsCellAliveInNextIteration_thenReturnTrueInCaseOfSustenance() throws Exception {
        boolean isAliveInNextIteration = controller.isCellAliveInNextIteration(6, true);

        assertThat(isAliveInNextIteration).isTrue();
    }

    @Test
    public void givenWorld_whenIsCellAliveInNextIteration_thenReturnTrueInCaseOfSustenance2() throws Exception {
        boolean isAliveInNextIteration = controller.isCellAliveInNextIteration(5, true);

        assertThat(isAliveInNextIteration).isTrue();
    }

    @Test
    public void givenWorld_whenIsCellAliveInNextIteration_thenReturnFalseInCaseOfStarvation() throws Exception {
        boolean isAliveInNextIteration = controller.isCellAliveInNextIteration(7, true);

        assertThat(isAliveInNextIteration).isFalse();
    }

    @Test
    public void givenWorld_whenIsCellAliveInNextIteration_thenReturnFalseInCaseOfStarvation2() throws Exception {
        boolean isAliveInNextIteration = controller.isCellAliveInNextIteration(8, true);

        assertThat(isAliveInNextIteration).isFalse();
    }

    @Test
    public void givenWorld_whenIsCellAliveInNextIteration_thenReturnFalseInCaseOfOverPopulation() throws Exception {
        boolean isAliveInNextIteration = controller.isCellAliveInNextIteration(4, true);

        assertThat(isAliveInNextIteration).isFalse();
    }

    @Test
    public void givenWorld_whenIsCellAliveInNextIteration_thenReturnFalseInCaseOfOverPopulation2() throws Exception {
        boolean isAliveInNextIteration = controller.isCellAliveInNextIteration(3, true);

        assertThat(isAliveInNextIteration).isFalse();
    }

    @Test
    public void givenWorld_whenIsCellAliveInNextIteration_thenReturnFalseInCaseOfOverPopulation3() throws Exception {
        boolean isAliveInNextIteration = controller.isCellAliveInNextIteration(2, true);

        assertThat(isAliveInNextIteration).isFalse();
    }

    @Test
    public void givenWorld_whenIsCellAliveInNextIteration_thenReturnFalseInCaseOfOverPopulation4() throws Exception {
        boolean isAliveInNextIteration = controller.isCellAliveInNextIteration(1, true);

        assertThat(isAliveInNextIteration).isFalse();
    }

    @Test
    public void givenWorld_whenIsCellAliveInNextIteration_thenReturnFalseInCaseOfOverPopulation5() throws Exception {
        boolean isAliveInNextIteration = controller.isCellAliveInNextIteration(0, true);

        assertThat(isAliveInNextIteration).isFalse();
    }

    @Test
    public void givenWorld_whenIsCellAliveInNextIteration_thenReturnTrueInCaseOfReproduction() throws Exception {
        boolean isAliveInNextIteration = controller.isCellAliveInNextIteration(5, false);

        assertThat(isAliveInNextIteration).isTrue();
    }

    @Test
    public void givenWorld_whenIsCellAliveInNextIteration_thenReturnFalseInCaseOfReproduction2() throws Exception {
        boolean isAliveInNextIteration = controller.isCellAliveInNextIteration(6, false);

        assertThat(isAliveInNextIteration).isFalse();
    }

    @Test
    public void givenWorld_whenIsCellAliveInNextIteration_thenReturnFalseInCaseOfReproduction3() throws Exception {
        boolean isAliveInNextIteration = controller.isCellAliveInNextIteration(4, false);

        assertThat(isAliveInNextIteration).isFalse();
    }
}
