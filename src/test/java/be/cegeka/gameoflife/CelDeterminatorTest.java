package be.cegeka.gameoflife;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static be.cegeka.gameoflife.Cel.DEAD;
import static be.cegeka.gameoflife.Cel.LIVING;

public class CelDeterminatorTest {

    @Test
    public void GivenZeroLivingNeighborAndCelIsDead_WhenDetermineNextStatus_ThenNextStatusIsDead() {
        Assertions.assertThat(new CelDeterminator().determineNextStatus(Cel.DEAD, 0)).isEqualTo(DEAD);
    }

    @Test
    public void GivenZeroLivingNeighborAndCelIsLiving_WhenDetermineNextStatus_ThenNextStatusIsDead() {
        Assertions.assertThat(new CelDeterminator().determineNextStatus(Cel.LIVING, 0)).isEqualTo(DEAD);
    }

    @Test
    public void GivenOneLivingNeighborAndCelIsDead_WhenDetermineNextStatus_ThenNextStatusIsDead() {
        Assertions.assertThat(new CelDeterminator().determineNextStatus(Cel.DEAD, 1)).isEqualTo(DEAD);
    }

    @Test
    public void GivenOneLivingNeighborAndCelIsLiving_WhenDetermineNextStatus_ThenNextStatusIsDead() {
        Assertions.assertThat(new CelDeterminator().determineNextStatus(Cel.LIVING, 1)).isEqualTo(DEAD);
    }

    @Test
    public void GivenTwoLivingNeighborAndCelIsDead_WhenDetermineNextStatus_ThenNextStatusIsDead() {
        Assertions.assertThat(new CelDeterminator().determineNextStatus(Cel.DEAD, 2)).isEqualTo(DEAD);
    }

    @Test
    public void GivenTwoLivingNeighborAndCelIsLiving_WhenDetermineNextStatus_ThenNextStatusIsLiving() {
        Assertions.assertThat(new CelDeterminator().determineNextStatus(Cel.LIVING, 2)).isEqualTo(LIVING);
    }

    @Test
    public void GivenThreeLivingNeighborAndCelIsDead_WhenDetermineNextStatus_ThenNextStatusIsDead() {
        Assertions.assertThat(new CelDeterminator().determineNextStatus(Cel.DEAD, 3)).isEqualTo(LIVING);
    }

    @Test
    public void GivenThreeLivingNeighborAndCelIsLiving_WhenDetermineNextStatus_ThenNextStatusIsDead() {
        Assertions.assertThat(new CelDeterminator().determineNextStatus(Cel.LIVING, 3)).isEqualTo(LIVING);
    }

    @Test
    public void GivenFourLivingNeighborAndCelIsDead_WhenDetermineNextStatus_ThenNextStatusIsDead() {
        Assertions.assertThat(new CelDeterminator().determineNextStatus(Cel.DEAD, 4)).isEqualTo(DEAD);
    }

    @Test
    public void GivenFourLivingNeighborAndCelIsLiving_WhenDetermineNextStatus_ThenNextStatusIsDead() {
        Assertions.assertThat(new CelDeterminator().determineNextStatus(Cel.LIVING, 4)).isEqualTo(DEAD);
    }

    @Test
    public void GivenEightLivingNeighborAndCelIsDead_WhenDetermineNextStatus_ThenNextStatusIsDead() {
        Assertions.assertThat(new CelDeterminator().determineNextStatus(Cel.DEAD, 8)).isEqualTo(DEAD);
    }

    @Test
    public void GivenEightLivingNeighborAndCelIsLiving_WhenDetermineNextStatus_ThenNextStatusIsDead() {
        Assertions.assertThat(new CelDeterminator().determineNextStatus(Cel.LIVING, 8)).isEqualTo(DEAD);
    }

    @Test
    public void GivenMoreThanEightLivingNeigbors_WhenDetermineNextStatus_ThenExceptionIsThrown() {
        Assertions.assertThatThrownBy(() -> new CelDeterminator().determineNextStatus(Cel.DEAD, 9))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("A cell has only 8 neighbors in total and therefore can't have 9 living neighbors");
    }

    @Test
    public void GivenLessThan0tLivingNeigbors_WhenDetermineNextStatus_ThenExceptionIsThrown() {
        Assertions.assertThatThrownBy(() -> new CelDeterminator().determineNextStatus(Cel.DEAD, -1))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("A cell can't have less than 0 living neighbors");
    }
}
