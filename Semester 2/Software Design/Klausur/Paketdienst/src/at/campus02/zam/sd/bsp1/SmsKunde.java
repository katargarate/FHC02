package at.campus02.zam.sd.bsp1;

public class SmsKunde implements Kunde {
    private final String name;

    public SmsKunde(String name) {
        this.name = name;
    }

    @Override
    public void update(String sendungsNr, String status) {
        System.out.printf("SMS an %s: Sendung %s is jetzt %s\n", name, sendungsNr, status);
    }

    @Override
    public String getName() {
        return name;
    }
}
