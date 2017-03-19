package be.cegeka.gameoflife;

import java.util.Arrays;

public enum Cel {
    DEAD(false),
    LIVING(true);

    private boolean celValue;

    Cel(boolean celValue) {
        this.celValue = celValue;
    }

    public boolean getCelValue() {
        return celValue;
    }

    public static Cel of(boolean celValue) {
        return Arrays.stream(Cel.values()).filter(cel -> cel.celValue == celValue).findFirst().get();
    }
}
