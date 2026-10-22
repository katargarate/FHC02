package klatsch.krone.at;

public class Main {

    public static void main(String[] args) {

        Medienverlag klatsch = new Medienverlag();

        Artikel artikel1 = new Artikel("Titel 1: Baby Hund rettet Kind", "Kleiner Welpe überrascht uns alle mit seinem großen Mut," + "in dem er ein Baby gegen einen Hai verteidigt");
        Artikel artikel2 = new Artikel("Titel 2: Ultraspannende Rettung von einem" + " Vogel der von einem Baum herunter gefallen ist", "Es waren die furchteinfloeszendsten 20cm seines Lebens." + "Klicken Sie (hier) um zu erfahren wie es ihm geht (Webcam)");

        Abonnent Peter = new PrintAbonnent("Peter", klatsch);
        Abonnent Hans = new PrintAbonnent("Hans", klatsch);
        Abonnent Wilhelm = new SMSAbonnent("Wilhelm", klatsch);
        Abonnent Meixi = new WebAbonnent("Meixi", klatsch);

       // klatsch.addSubscriber(Meixi);
       // klatsch.addSubscriber(Wilhelm);
        System.out.println("--------Artikel 1 veroeffentlicht------");
        klatsch.veroeffentliche(artikel1);
        System.out.println("--------Artikel 2 veroeffentlicht------");
        klatsch.veroeffentliche(artikel2);


        //-- singleton test start --
        LogSingleton l = LogSingleton.getInstance();
        l.log("alsdjakls");
        System.out.println(l);
        //-- singleton test ende --
    }
}