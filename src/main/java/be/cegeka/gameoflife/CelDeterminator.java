package be.cegeka.gameoflife;

import java.util.Arrays;
import java.util.Collection;

public class CelDeterminator {

    private interface Rule {
        boolean applies(Cel cel, int amountOfLivingNeigbors);

        Cel getResult(Cel cel);
    }

    private class UnderPopulation implements Rule {

        @Override
        public boolean applies(Cel cel, int amountOfLivingNeigbors) {
            return amountOfLivingNeigbors < 2;
        }

        @Override
        public Cel getResult(Cel cel) {
            return Cel.DEAD;
        }
    }

    private class OverPopulation implements Rule {

        @Override
        public boolean applies(Cel cel, int amountOfLivingNeigbors) {
            return amountOfLivingNeigbors > 3;
        }

        @Override
        public Cel getResult(Cel cel) {
            return Cel.DEAD;
        }
    }

    private class Sustenance implements Rule {

        @Override
        public boolean applies(Cel cel, int amountOfLivingNeigbors) {
            return amountOfLivingNeigbors == 2;
        }

        @Override
        public Cel getResult(Cel cel) {
            return cel;
        }
    }

    private class Reproduction implements Rule {

        @Override
        public boolean applies(Cel cel, int amountOfLivingNeigbors) {
            return amountOfLivingNeigbors == 3;
        }

        @Override
        public Cel getResult(Cel cel) {
            return Cel.LIVING;
        }
    }

    private Collection<Rule> rules = Arrays.asList(new UnderPopulation(), new OverPopulation(), new Reproduction(), new Sustenance());



    public Cel determineNextStatus(Cel cel, int amountOfLivingNeighbors) {
        validateAmountOfLivingNeigbors(amountOfLivingNeighbors);
        return rules.stream().filter(rule -> rule.applies(cel, amountOfLivingNeighbors)).findFirst().get().getResult(cel);
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
