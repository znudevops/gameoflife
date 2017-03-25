package be.cegeka.gameoflife;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class NeighbourHoodFactory {

    public static Neighbourhood create(List<List<Boolean>> currentWorld, Location location) {
        return new Neighbourhood((int) getNeighbours(currentWorld, location).stream().filter(neighbor -> neighbor == Cel.LIVING).count());
    }

    private static List<Cel> getNeighbours(List<List<Boolean>> currentWorld, Location location) {
        return Arrays.asList(getDownStairNeighbours(currentWorld, location), getFellowNeighbors(currentWorld, location), getUpperNeighbors(currentWorld, location)).stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    private static List<Cel> getDownStairNeighbours(List<List<Boolean>> currentWorld, Location location) {
        return Arrays.asList(getFirstDownstairNeighbor(currentWorld, location), getSecondDownstairNeighbor(currentWorld, location), getThirdDownstairNeighbor(currentWorld, location));
    }

    private static List<Cel> getFellowNeighbors(List<List<Boolean>> currentWorld, Location location) {
        return Arrays.asList(getFirstFellowNeighbor(currentWorld, location), getSecondFellowNeigbor(currentWorld, location));
    }

    private static List<Cel> getUpperNeighbors(List<List<Boolean>> currentWorld, Location location) {
        return Arrays.asList(getFirstUpperNeighbor(currentWorld, location), getSecondUpperNeighbor(currentWorld, location), getThirdUpperNeighbor(currentWorld, location));
    }

    private static Cel getFirstUpperNeighbor(List<List<Boolean>> currentWorld, Location location) {
        return getCel(currentWorld, getLocationFirstUpperNeighbor(location));
    }

    private static Cel getSecondUpperNeighbor(List<List<Boolean>> currentWorld, Location location) {
        return getCel(currentWorld, getLocationSecondUpperNeighbor(location));
    }

    private static Cel getThirdUpperNeighbor(List<List<Boolean>> currentWorld, Location location) {
        return getCel(currentWorld, getLocationThirdUpperNeighbor(location));
    }

    private static Cel getFirstFellowNeighbor(List<List<Boolean>> currentWorld, Location location) {
        return getCel(currentWorld, getLocationFirstFellowNeighbor(location));
    }

    private static Cel getSecondFellowNeigbor(List<List<Boolean>> currentWorld, Location location) {
        return getCel(currentWorld, getLocationSecondFellowNeighbor(location));
    }

    private static Cel getFirstDownstairNeighbor(List<List<Boolean>> currentWorld, Location location) {
        return getCel(currentWorld, getLocationFirstDownstairNeighbor(location));
    }

    private static Cel getSecondDownstairNeighbor(List<List<Boolean>> currentWorld, Location location) {
        return getCel(currentWorld, getLocationSecondDownstairNeighbor(location));
    }

    private static Cel getThirdDownstairNeighbor(List<List<Boolean>> currentWorld, Location location) {
        return getCel(currentWorld, getLocationThirdDownstairNeighbor(location));
    }

    private static Cel getCel(List<List<Boolean>> currentWorld, Location location) {
        return doesCelExist(currentWorld, location) ? Cel.of(currentWorld.get(location.getRowNummer()).get(location.getColumnNummer())) : Cel.DEAD;
    }

    private static boolean doesCelExist(List<List<Boolean>> currentWorld, Location location) {
        return doesRowExist(currentWorld, location) && doesColumnExist(currentWorld, location);
    }

    private static boolean doesColumnExist(List<List<Boolean>> currentWorld, Location location) {
        return location.getColumnNummer() >= 0 && location.getColumnNummer() < currentWorld.size();
    }

    private static boolean doesRowExist(List<List<Boolean>> currentWorld, Location location) {
        return location.getRowNummer() >= 0 && location.getRowNummer() < currentWorld.get(0).size();
    }

    private static Location getLocationFirstUpperNeighbor(Location location) {
        return new Location(location.getRowNummer() - 1, location.getColumnNummer() - 1);
    }

    private static Location getLocationSecondUpperNeighbor(Location location) {
        return new Location(location.getRowNummer() - 1, location.getColumnNummer());
    }

    private static Location getLocationThirdUpperNeighbor(Location location) {
        return new Location(location.getRowNummer() - 1, location.getColumnNummer() + 1);
    }

    private static Location getLocationFirstFellowNeighbor(Location location) {
        return new Location(location.getRowNummer(), location.getColumnNummer() - 1);
    }

    private static Location getLocationSecondFellowNeighbor(Location location) {
        return new Location(location.getRowNummer(), location.getColumnNummer() + 1);
    }

    private static Location getLocationFirstDownstairNeighbor(Location location) {
        return new Location(location.getRowNummer() + 1, location.getColumnNummer() - 1);
    }

    private static Location getLocationSecondDownstairNeighbor(Location location) {
        return new Location(location.getRowNummer() + 1, location.getColumnNummer());
    }

    private static Location getLocationThirdDownstairNeighbor(Location location) {
        return new Location(location.getRowNummer() + 1, location.getColumnNummer() + 1);
    }
}
