public abstract class ZutatDecorator extends Getraenk{
    public Getraenk getraenk;

    public ZutatDecorator(Getraenk g) {
        this.getraenk = g;
    }


    public abstract String getBeschreibung();
}
