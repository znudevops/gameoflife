package be.cegeka.gameoflife;

import static be.cegeka.gameoflife.Cel.DEAD;
import static be.cegeka.gameoflife.Cel.LIVING;

public class CelDeterminator {

    public Cel determineNextStatus(Cel cel, int amountOfLivingNeighbors) {
        validateAmountOfLivingNeigbors(amountOfLivingNeighbors);
        if (amountOfLivingNeighbors == 2) {
            return cel;
        }
        if(amountOfLivingNeighbors == 3) {
            return LIVING;
        }
        return DEAD;
    }

    private void validateAmountOfLivingNeigbors(int amountOfLivingNeighbors) {
        validateAmountOfLivingNeigborsNotGreaterThenEight(amountOfLivingNeighbors);
        validateAmountOfLivingNeigborsNotSmallerThenZero(amountOfLivingNeighbors);
    }

    private void validateAmountOfLivingNeigborsNotSmallerThenZero(int amountOfLivingNeighbors) {
        if(amountOfLivingNeighbors < 0) {
            throw new IllegalArgumentException("A cell can't have less than 0 living neighbors");
        }
    }

    private void validateAmountOfLivingNeigborsNotGreaterThenEight(int amountOfLivingNeighbors) {
        if(amountOfLivingNeighbors > 8) {
            throw new IllegalArgumentException("A cell has only 8 neighbors in total and therefore can't have " + amountOfLivingNeighbors + " living neighbors");
        }
    }


}
