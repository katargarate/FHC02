public abstract class ZutatDecorator extends Getraenk{
    protected Getraenk getraenk;

    public ZutatDecorator(Getraenk getraenk) {
        this.getraenk = getraenk;
    }

    //zwinge abgeleitete Klassen diese Methode zu überschreiben
    public abstract String getBeschreibung();
}
