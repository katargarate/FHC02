package at.campus02.fernbedienung;


public class TVKanalRaufKommando implements Kommando {

    private TV tv;

    public TVKanalRaufKommando(TV tv) {
        super();
        this.tv = tv;
    }

    @Override
    public void ausfuehren() {
        if (!tv.istEin()) {
            tv.ein();
        } else {
            tv.rauf();
        }
    }

}
