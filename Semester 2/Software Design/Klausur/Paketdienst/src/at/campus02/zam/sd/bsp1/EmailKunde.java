package at.campus02.zam.sd.bsp1;

public class EmailKunde implements Kunde {
    // final weil der Name sich nach der Erstellung des Objekts nicht mehr ändern soll, bzw. kann
    private final String name;

    public EmailKunde(String name) {
        this.name = name;
    }

    @Override
    public void update(String sendungsNr, String status) {
        // E-Mail an NAME: NR STATUS
        System.out.printf("E-Mail an %s: %s %s\n", name, sendungsNr, status);
    }

    @Override
    public String getName() {
        return name;
    }
}
