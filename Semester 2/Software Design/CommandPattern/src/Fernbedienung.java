import java.util.HashMap;
import java.util.Map;

public class Fernbedienung {
    private Map<Integer, Kommando> kommandos = new HashMap<Integer, Kommando>();

    public void setKommando(Integer slot, Kommando k) {
        kommandos.put(slot, k);
    }

    public void knopfGedrueckt(int knopfnummer) {
        Kommando k = kommandos.get(knopfnummer);
        k.auesfuehren();
    }
}
