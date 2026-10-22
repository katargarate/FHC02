public class KanalRaufKommando implements Kommando {
    private TV tv;

    public KanalRaufKommando(TV tv) {
        this.tv = tv;
    }

    @Override
    public void auesfuehren() {
        tv.kanalErhoehen();
    }
}
