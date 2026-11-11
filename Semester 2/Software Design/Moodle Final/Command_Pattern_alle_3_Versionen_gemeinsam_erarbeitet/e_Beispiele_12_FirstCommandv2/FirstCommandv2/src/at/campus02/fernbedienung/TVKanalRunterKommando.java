package at.campus02.fernbedienung;

public class TVKanalRunterKommando implements Kommando {

    private TV tv;


    public TVKanalRunterKommando(TV tv) {
        this.tv = tv;
    }

    @Override
    public void ausfuehren() {
        if (!tv.istEin()) {
            tv.ein();
        } else {
            tv.runter();
        }
    }



}
