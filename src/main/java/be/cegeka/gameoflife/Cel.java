package be.cegeka.gameoflife;

public enum Cel {
    DEAD,
    LIVING;

    public static Cel of(boolean celValue) {
        return celValue? LIVING: DEAD;
    }
}
