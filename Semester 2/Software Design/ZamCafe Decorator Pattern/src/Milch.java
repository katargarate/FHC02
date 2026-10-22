public class Milch extends ZutatDecorator {

    public Milch(Getraenk g) {
        super(g);
    }

    @Override
    public double kostet() {
        return getraenk.kostet() + 0.5;
    }

    @Override
    public String getBeschreibung() {
        return getraenk.getBeschreibung();
    }

}
