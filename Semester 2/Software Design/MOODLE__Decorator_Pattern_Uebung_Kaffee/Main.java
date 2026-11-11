public class Main {
    public static void main(String[] args) {
        System.out.println("Das Kaffee hat geöffnet!");
        Getraenk g = new Decaf(); //1.00
        g = new Milch(g); // 0.80
        g = new Milch(g); // 0.8
        g = new Sirup(g); // 0.5
        //HIER
        System.out.println("Beschreibung: " + g.getBeschreibung());
        System.out.println("Kosten: " + g.kostet());
    }
}