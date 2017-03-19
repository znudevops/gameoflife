package be.cegeka.gameoflife;

public class Location {
    private final int rowNummer;
    private final int columnNummer;

    public Location(int rowNummer, int columnNummer) {
        this.rowNummer = rowNummer;
        this.columnNummer = columnNummer;
    }

    public int getRowNummer() {
        return rowNummer;
    }

    public int getColumnNummer() {
        return columnNummer;
    }
}
