public class Sirup extends ZutatDecorator{
    public Sirup(Getraenk getraenk) {
        super(getraenk);
    }
    @Override
    public double kostet() {
        System.out.println("DEBUG: kostet() von Sirup aufgerufen. "+
                "Addiere 0.5 Euro.");
        return getraenk.kostet() + 0.5d;
    }
    @Override
    public String getBeschreibung() {
        return getraenk.getBeschreibung() + ", Sirup";
    }
}
