public class ZamCafe {


    static void main(String[] args) {
        Getraenk g1 = new CafeLatte();
        g1.setBeschreibung("Cafe Latte mit Milch und Sirup");
        // sending the current drink as a parameter for a new one thats overwriting the current one
        g1 = new Sirup(g1);
        g1 = new Milch(g1);

        Getraenk g2 = new Milch(new Sirup(new CafeLatte()));

        System.out.println(g1.getBeschreibung() + ": €" + g1.kostet());
        System.out.println(g2.getBeschreibung() + ": €" + g2.kostet());

    }
}
