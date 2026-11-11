package at.campus02.zam.sd.bsp3;

public class Protokoll {
    private static Protokoll instance = null;
    // Zähler für die Protokoll-Einträge
    public static int n = 1;

    // private Konstruktor, damit keine Instanz von außen erzeugt werden kann
    private Protokoll() {
    }

    // synchronized, damit nur ein Thread gleichzeitig auf die Instanz zugreifen kann
    public static synchronized Protokoll getInstance() {
        if (instance == null) {
            instance = new Protokoll();
        }
        return instance;
    }

    // gibt eine Meldung auf der Konsole aus, die den aktuellen Protokoll-Eintrag enthält
    public static synchronized void log(String text) {
        System.out.printf("[PROTOKOLL %d] %s\n", n++, text);
    }
}
