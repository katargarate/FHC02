public class Milch extends ZutatDecorator{
    public Milch(Getraenk getraenk) {
        super(getraenk);
    }

    @Override
    public double kostet() {
        System.out.println("DEBUG: kostet() von Milch aufgerufen. "+
                "Addiere 0.8 Euro.");
        return getraenk.kostet() + 0.8d;
    }

    @Override
    public String getBeschreibung() {
        return getraenk.getBeschreibung() + ", Milch";
    }
}
