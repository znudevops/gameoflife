package be.cegeka.gameoflife;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Neighbourhood {
    private final List<Cel> neighbors;

    public Neighbourhood(List<List<Boolean>> currentWorld, Location location) {
        neighbors = new ArrayList<>();
        neighbors.addAll(getUpperNeighbors(currentWorld, location));
        neighbors.addAll(getFellowNeighbors(currentWorld, location));
        neighbors.addAll(getDownStairNeighbours(currentWorld, location));
    }

    private List<Cel> getDownStairNeighbours(List<List<Boolean>> currentWorld, Location location) {
        return Arrays.asList(getFirstDownstairNeighbor(currentWorld, location), getSecondDownstairNeighbor(currentWorld, location), getThirdDownstairNeighbor(currentWorld, location));
    }

    private List<Cel> getFellowNeighbors(List<List<Boolean>> currentWorld, Location location) {
        return Arrays.asList(getFirstFellowNeighbor(currentWorld, location), getSecondFellowNeigbor(currentWorld, location));
    }

    private List<Cel> getUpperNeighbors(List<List<Boolean>> currentWorld, Location location) {
        return Arrays.asList(getFirstUpperNeighbor(currentWorld, location), getSecondUpperNeighbor(currentWorld, location), getThirdUpperNeighbor(currentWorld, location));
    }

    private Cel getFirstUpperNeighbor(List<List<Boolean>> currentWorld, Location location) {
        return getCel(currentWorld, getLocationFirstUpperNeighbor(location));
    }

    private Cel getSecondUpperNeighbor(List<List<Boolean>> currentWorld, Location location) {
        return getCel(currentWorld, getLocationSecondUpperNeighbor(location));
    }

    private Cel getThirdUpperNeighbor(List<List<Boolean>> currentWorld, Location location) {
        return getCel(currentWorld, getLocationThirdUpperNeighbor(location));
    }

    private Cel getFirstFellowNeighbor(List<List<Boolean>> currentWorld, Location location) {
        return getCel(currentWorld, getLocationFirstFellowNeighbor(location));
    }

    private Cel getSecondFellowNeigbor(List<List<Boolean>> currentWorld, Location location) {
        return getCel(currentWorld, getLocationSecondFellowNeighbor(location));
    }

    private Cel getFirstDownstairNeighbor(List<List<Boolean>> currentWorld, Location location) {
        return getCel(currentWorld, getLocationFirstDownstairNeighbor(location));
    }

    private Cel getSecondDownstairNeighbor(List<List<Boolean>> currentWorld, Location location) {
        return getCel(currentWorld, getLocationSecondDownstairNeighbor(location));
    }

    private Cel getThirdDownstairNeighbor(List<List<Boolean>> currentWorld, Location location) {
        return getCel(currentWorld, getLocationThirdDownstairNeighbor(location));
    }

    private Cel getCel(List<List<Boolean>> currentWorld, Location location) {
        return doesCelExist(currentWorld, location) ? Cel.of(currentWorld.get(location.getRowNummer()).get(location.getColumnNummer())) : Cel.DEAD;
    }

    private boolean doesCelExist(List<List<Boolean>> currentWorld, Location location) {
        return doesRowExist(currentWorld, location) && doesColumnExist(currentWorld, location);
    }

    private boolean doesColumnExist(List<List<Boolean>> currentWorld, Location location) {
        return location.getColumnNummer() >= 0 && location.getColumnNummer() < currentWorld.size();
    }

    private boolean doesRowExist(List<List<Boolean>> currentWorld, Location location) {
        return location.getRowNummer() >= 0 && location.getRowNummer() < currentWorld.get(0).size();
    }

    private Location getLocationFirstUpperNeighbor(Location location) {
        return new Location(location.getRowNummer() - 1, location.getColumnNummer() - 1);
    }

    private Location getLocationSecondUpperNeighbor(Location location) {
        return new Location(location.getRowNummer() - 1, location.getColumnNummer());
    }

    private Location getLocationThirdUpperNeighbor(Location location) {
        return new Location(location.getRowNummer() - 1, location.getColumnNummer() + 1);
    }

    private Location getLocationFirstFellowNeighbor(Location location) {
        return new Location(location.getRowNummer(), location.getColumnNummer() - 1);
    }

    private Location getLocationSecondFellowNeighbor(Location location) {
        return new Location(location.getRowNummer(), location.getColumnNummer() + 1);
    }

    private Location getLocationFirstDownstairNeighbor(Location location) {
        return new Location(location.getRowNummer() + 1, location.getColumnNummer() - 1);
    }

    private Location getLocationSecondDownstairNeighbor(Location location) {
        return new Location(location.getRowNummer() + 1, location.getColumnNummer());
    }

    private Location getLocationThirdDownstairNeighbor(Location location) {
        return new Location(location.getRowNummer() + 1, location.getColumnNummer() + 1);
    }

    public int getAmountOfLivingNeigbours() {
        return (int) neighbors.stream().filter(neighbor -> neighbor == Cel.LIVING).count();
    }
}
