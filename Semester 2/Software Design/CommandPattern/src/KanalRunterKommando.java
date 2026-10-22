public class KanalRunterKommando implements Kommando{
    private TV tv;

    public KanalRunterKommando(TV tv) {
       this.tv = tv;
    }

    @Override
    public void auesfuehren() {
        tv.kanalErniedrigen();
    }
}
