public class Espresso extends Getraenk{
    @Override
    public double kostet() {
        System.out.println("DEBUG: kostet() von Expresso aufgerufen. "+
                "Addiere 1.0 Euro.");
        return 1.0d;
    }

    public Espresso() {
        beschreibung = "Espresso";
    }
}
