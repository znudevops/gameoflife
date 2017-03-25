package be.cegeka.gameoflife;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Neighbourhood {
    private int amountOfNeighbors;

    public Neighbourhood(int amountOfNeighbors) {
        this.amountOfNeighbors = amountOfNeighbors;
    }

    public int getAmountOfLivingNeigbours() {
        return amountOfNeighbors;
    }
}
