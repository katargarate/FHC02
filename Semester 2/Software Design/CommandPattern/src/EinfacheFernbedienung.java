public class EinfacheFernbedienung {
    private Kommando slot;

    public void setKommando(LichtAnKommando k) {
        slot = k;
    }

    public void knopfGedrueckt() {
        slot.auesfuehren();
    }
}
