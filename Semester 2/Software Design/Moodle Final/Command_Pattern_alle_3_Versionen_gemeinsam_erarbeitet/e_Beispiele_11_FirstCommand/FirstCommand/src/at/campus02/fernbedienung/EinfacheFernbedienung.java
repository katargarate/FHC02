package at.campus02.fernbedienung;

// warum einfach? weil wir nur ein Kommando merken können
public class EinfacheFernbedienung {
    // Kann ein Kommando fuer eine Taste speichern
    private Kommando slot;

    public EinfacheFernbedienung(){}

    // Eine Methode um der Taste ein Kommando zuzuweisen
    // kann durch mehrfaches Aufrufen Kommando verändern ("Fernbedienung programmieren")
    public void setKommando(Kommando k){
        slot = k;
    }

    // wird aufgerufen wenn Knopf auf Fernbedienung gedrueckt wird
    public void knopfGedrueckt(){
        slot.ausfuehren();
    }
}
