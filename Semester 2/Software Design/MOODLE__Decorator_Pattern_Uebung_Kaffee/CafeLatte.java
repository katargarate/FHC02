public class CafeLatte extends Getraenk{
    @Override
    public double kostet() {
        System.out.println("DEBUG: kostet() von CafeLatte aufgerufen. "+
                "Addiere 3.6 Euro.");
        return 3.6d;
    }

    public CafeLatte() {
        beschreibung = "Cafe Latte";
    }
}
