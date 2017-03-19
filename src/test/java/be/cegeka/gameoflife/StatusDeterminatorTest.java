package be.cegeka.gameoflife;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static be.cegeka.gameoflife.Status.DEAD;
import static be.cegeka.gameoflife.Status.LIVING;

public class StatusDeterminatorTest {

    @Test
    public void GivenZeroLivingNeighbor_WhenDetermineNextStatus_ThenNextStatusIsDead() {
        Assertions.assertThat(new StatusDeterminator().determineNextStatus(0)).isEqualTo(DEAD);
    }

    @Test
    public void GivenOneLivingNeighbor_WhenDetermineNextStatus_ThenNextStatusIsDead() {
        Assertions.assertThat(new StatusDeterminator().determineNextStatus(1)).isEqualTo(DEAD);
    }

    @Test
    public void GivenTwoLivingNeighbor_WhenDetermineNextStatus_ThenNextStatusIsDead() {
        Assertions.assertThat(new StatusDeterminator().determineNextStatus(2)).isEqualTo(LIVING);
    }

    @Test
    public void GivenThreeLivingNeighbor_WhenDetermineNextStatus_ThenNextStatusIsDead() {
        Assertions.assertThat(new StatusDeterminator().determineNextStatus(3)).isEqualTo(LIVING);
    }

    @Test
    public void GivenFourLivingNeighbor_WhenDetermineNextStatus_ThenNextStatusIsDead() {
        Assertions.assertThat(new StatusDeterminator().determineNextStatus(4)).isEqualTo(DEAD);
    }

    @Test
    public void GivenEightLivingNeighbor_WhenDetermineNextStatus_ThenNextStatusIsDead() {
        Assertions.assertThat(new StatusDeterminator().determineNextStatus(8)).isEqualTo(DEAD);
    }

    @Test
    public void GivenMoreThanEightLivingNeigbors_WhenDetermineNextStatus_ThenExceptionIsThrown() {
        Assertions.assertThatThrownBy(() -> new StatusDeterminator().determineNextStatus(9))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("A cell has only 8 neighbors in total and therefore can't have 9 living neighbors");
    }

    @Test
    public void GivenLessThan0tLivingNeigbors_WhenDetermineNextStatus_ThenExceptionIsThrown() {
        Assertions.assertThatThrownBy(() -> new StatusDeterminator().determineNextStatus(-1))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("A cell can't have less than 0 living neighbors");
    }
}
