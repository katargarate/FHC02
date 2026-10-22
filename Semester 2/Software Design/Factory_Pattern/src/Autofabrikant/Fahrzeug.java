package Autofabrikant;

public class Fahrzeug {
    private String name;

    public Fahrzeug(String name) {
        this.name = name;
    }

    public void huppen() {
        System.out.println("BEEP BEEP");
    }

    public void waschen() {
        System.out.println("WISCH WASCH");
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Fahrzeug: %s", name);
    }
}
