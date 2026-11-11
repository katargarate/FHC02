public class Decaf extends Getraenk{
    @Override
    public double kostet() {
        System.out.println("DEBUG: kostet() von Decaf aufgerufen. "+
                "Addiere 2.60 Euro.");
        return 2.6d;
    }

    public Decaf() {
        beschreibung = "Decaf";
    }
}
