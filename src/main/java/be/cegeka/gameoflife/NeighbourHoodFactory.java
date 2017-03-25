package be.cegeka.gameoflife;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class NeighbourHoodFactory {

    private final List<List<Boolean>> currentWorld;

    public NeighbourHoodFactory(List<List<Boolean>> currentWorld) {
        this.currentWorld = currentWorld;
    }

    public Neighbourhood create(Location location) {
        return new Neighbourhood((int) getNeighbours(location).stream().filter(neighbor -> neighbor == Cel.LIVING).count());
    }

    private List<Cel> getNeighbours(Location location) {
        return Arrays.asList(getDownStairNeighbours(location), getFellowNeighbors(location), getUpperNeighbors(location)).stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    private List<Cel> getDownStairNeighbours(Location location) {
        return Arrays.asList(getFirstDownstairNeighbor(location), getSecondDownstairNeighbor(location), getThirdDownstairNeighbor(location));
    }

    private List<Cel> getFellowNeighbors(Location location) {
        return Arrays.asList(getFirstFellowNeighbor(location), getSecondFellowNeigbor(location));
    }

    private List<Cel> getUpperNeighbors(Location location) {
        return Arrays.asList(getFirstUpperNeighbor(location), getSecondUpperNeighbor(location), getThirdUpperNeighbor(location));
    }

    private Cel getFirstUpperNeighbor(Location location) {
        return getCel(getLocationFirstUpperNeighbor(location));
    }

    private Cel getSecondUpperNeighbor(Location location) {
        return getCel(getLocationSecondUpperNeighbor(location));
    }

    private Cel getThirdUpperNeighbor(Location location) {
        return getCel(getLocationThirdUpperNeighbor(location));
    }

    private Cel getFirstFellowNeighbor(Location location) {
        return getCel(getLocationFirstFellowNeighbor(location));
    }

    private Cel getSecondFellowNeigbor(Location location) {
        return getCel(getLocationSecondFellowNeighbor(location));
    }

    private Cel getFirstDownstairNeighbor(Location location) {
        return getCel(getLocationFirstDownstairNeighbor(location));
    }

    private Cel getSecondDownstairNeighbor(Location location) {
        return getCel(getLocationSecondDownstairNeighbor(location));
    }

    private Cel getThirdDownstairNeighbor(Location location) {
        return getCel(getLocationThirdDownstairNeighbor(location));
    }

    private Cel getCel(Location location) {
        return doesCelExist(location) ? Cel.of(currentWorld.get(location.getRowNummer()).get(location.getColumnNummer())) : Cel.DEAD;
    }

    private boolean doesCelExist(Location location) {
        return doesRowExist(location) && doesColumnExist(location);
    }

    private boolean doesColumnExist(Location location) {
        return location.getColumnNummer() >= 0 && location.getColumnNummer() < currentWorld.size();
    }

    private boolean doesRowExist(Location location) {
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
}
