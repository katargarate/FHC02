public class ZamCafe {


    static void main(String[] args) {
        Getraenk g1 = new CafeLatte();
        g1.setBeschreibung("Cafe Latte mit Milch und Sirup");
        g1 = new Sirup(g1);
        g1 = new Milch(g1);

        System.out.println(g1.getBeschreibung() + ": €" + g1.kostet());

    }
}
