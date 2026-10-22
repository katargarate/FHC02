package Pruefungsuebungen.Pruefung_Beispiel_Fuchs_3.Instrumente;

public class Instrument implements Comparable<Instrument> {
    private String name;
    private double lautstaerke;

    public Instrument(String name, double lautstaerke) {
        this.name = name;
        this.lautstaerke = lautstaerke;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLautstaerke() {
        return lautstaerke;
    }

    public void setLautstaerke(double lautstaerke) {
        this.lautstaerke = lautstaerke;
    }

    @Override
    public int compareTo(Instrument o) {
        if (this.lautstaerke > o.lautstaerke) return 1; // diese Lauter als Vergleichsinstrument
        else if (this.lautstaerke < o.lautstaerke) return -1; // diese weniger laut
        else return 0; // beide gleich laut
    }

    @Override
    public String toString() {
        return String.format("%s (Lautstärke: %.2f)", name, lautstaerke);
    }
}
