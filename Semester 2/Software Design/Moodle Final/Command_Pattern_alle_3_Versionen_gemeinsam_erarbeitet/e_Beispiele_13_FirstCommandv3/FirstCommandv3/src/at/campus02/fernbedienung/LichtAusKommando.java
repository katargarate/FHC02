package at.campus02.fernbedienung;

// Kommando Licht an muss Interface implementiere
public class LichtAusKommando implements Kommando {
    private Licht licht;

    // Konstruktor bekommt Licht mit auf welches Kommando
    // angewendet werden soll - dieses Licht ist der
    // Empfänger (Receiver) der Anfrage
    public LichtAusKommando(Licht licht){
        this.licht = licht;
    }

    // Ruft die Methode des Empfänger (=das kontrollierte Licht) auf
    @Override
    public void ausfuehren() {
        licht.aus();
    }

    @Override
    public void undo() {
        licht.an();
    }
}
