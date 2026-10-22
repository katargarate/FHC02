public class Sirup extends ZutatDecorator {

    public Sirup(Getraenk g) {
        super(g);
    }

    @Override
    public double kostet() {
        return getraenk.kostet() + 0.3;
    }

    @Override
    public String getBeschreibung() {
        return getraenk.getBeschreibung();
    }


}
