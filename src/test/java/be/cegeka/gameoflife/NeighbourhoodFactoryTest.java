package be.cegeka.gameoflife;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class NeighbourhoodFactoryTest {

    private List<List<Boolean>> currentWorld;

    @Before
    public void setup() {
        currentWorld = Arrays.asList(
            Arrays.asList(true, false, true),
            Arrays.asList(false, true, false),
            Arrays.asList(true, false, true));
    }

    @Test
    public void givenLocation00_whenCreatingNeighbourhood_NeigbourhoodWithCorrectAmountOfLivingNeigborsIsCreated() {
        Assertions.assertThat(NeighbourHoodFactory.create(currentWorld, new Location(0, 0)).getAmountOfLivingNeigbours()).isEqualTo(1);
    }

    @Test
    public void givenLocation01_whenCreatingNeighbourhood_NeigbourhoodWithCorrectAmountOfLivingNeigborsIsCreated() {
        Assertions.assertThat(NeighbourHoodFactory.create(currentWorld, new Location(0, 1)).getAmountOfLivingNeigbours()).isEqualTo(3);
    }

    @Test
    public void givenLocation02_whenCreatingNeighbourhood_NeigbourhoodWithCorrectAmountOfLivingNeigborsIsCreated() {
        Assertions.assertThat(NeighbourHoodFactory.create(currentWorld, new Location(0, 2)).getAmountOfLivingNeigbours()).isEqualTo(1);
    }

    @Test
    public void givenLocation10_whenCreatingNeighbourhood_NeigbourhoodWithCorrectAmountOfLivingNeigborsIsCreated() {
        Assertions.assertThat(NeighbourHoodFactory.create(currentWorld, new Location(1, 0)).getAmountOfLivingNeigbours()).isEqualTo(3);
    }

    @Test
    public void givenLocation11_whenCreatingNeighbourhood_NeigbourhoodWithCorrectAmountOfLivingNeigborsIsCreated() {
        Assertions.assertThat(NeighbourHoodFactory.create(currentWorld, new Location(1, 1)).getAmountOfLivingNeigbours()).isEqualTo(4);
    }

    @Test
    public void givenLocation12_whenCreatingNeighbourhood_NeigbourhoodWithCorrectAmountOfLivingNeigborsIsCreated() {
        Assertions.assertThat(NeighbourHoodFactory.create(currentWorld, new Location(1, 2)).getAmountOfLivingNeigbours()).isEqualTo(3);
    }

    @Test
    public void givenLocation20_whenCreatingNeighbourhood_NeigbourhoodWithCorrectAmountOfLivingNeigborsIsCreated() {
        Assertions.assertThat(NeighbourHoodFactory.create(currentWorld, new Location(2, 0)).getAmountOfLivingNeigbours()).isEqualTo(1);
    }

    @Test
    public void givenLocation21_whenCreatingNeighbourhood_NeigbourhoodWithCorrectAmountOfLivingNeigborsIsCreated() {
        Assertions.assertThat(NeighbourHoodFactory.create(currentWorld, new Location(2, 1)).getAmountOfLivingNeigbours()).isEqualTo(3);
    }

    @Test
    public void givenLocation22_whenCreatingNeighbourhood_NeigbourhoodWithCorrectAmountOfLivingNeigborsIsCreated() {
        Assertions.assertThat(NeighbourHoodFactory.create(currentWorld, new Location(2, 2)).getAmountOfLivingNeigbours()).isEqualTo(1);
    }
}
