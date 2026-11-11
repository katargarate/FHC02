package at.campus02.zam.sd.bsp3;

public class ScanAuftrag implements Auftrag{
    private String dokument;
    private Drucker drucker = new Drucker();
    // kann gleich hier initialisiert werden, da es ein Singleton ist und immer nur eine Instanz existiert
    private Protokoll protokoll = Protokoll.getInstance();


    public ScanAuftrag(String dokument) {
        this.dokument = dokument;
        System.out.println("ScanAuftrag erstellt: " + dokument);
    }

    @Override
    public void ausfuehren() {
        drucker.scanne(dokument);
        protokoll.log(String.format("ausgeführt: Scan %s\n", dokument));
    }
}
