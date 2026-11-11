package at.campus02.fernbedienung;

// Kommando Licht an muss Interface implementiere
public class LichtAnKommando implements Kommando {
    private Licht licht;

    // Konstruktor bekommt Licht mit auf welches Kommando
    // angewendet werden soll - dieses Licht ist der
    // Empfänger (Receiver) der Anfrage
    public LichtAnKommando(Licht licht){
        this.licht = licht;
    }

    // Ruft die Methode des Empfänger (=das kontrollierte Licht) auf
    @Override
    public void ausfuehren() {
        licht.an();
    }

    @Override
    public void undo() {
        licht.aus();
    }
}
