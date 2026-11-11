package at.campus02.zam.sd.bsp3;

public class DruckAuftrag implements Auftrag{
    private String dokument;
    private int kopien;
    private Drucker drucker = new Drucker();
    // kann gleich hier initialisiert werden, da es ein Singleton ist und immer nur eine Instanz existiert
    private Protokoll protokoll = Protokoll.getInstance();

    public DruckAuftrag(String dokument, int kopien) {
        this.dokument = dokument;
        this.kopien = kopien;
        // beim Instanziieren des DruckAuftrags wird eine Meldung ausgegeben
        System.out.println("DruckAuftrag erstellt: " + dokument);
    }

    @Override
    public void ausfuehren() {
        // fuehrt den Druckauftrag aus
        drucker.drucke(dokument, kopien);
        // Protokollierung des Auftrags
        protokoll.log(String.format("ausgeführt: Druck %s (%dx)\n", dokument, kopien));
    }
}
