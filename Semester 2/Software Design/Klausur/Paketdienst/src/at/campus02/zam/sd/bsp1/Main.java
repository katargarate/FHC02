package at.campus02.zam.sd.bsp1;

public class Main {
    public static void main(String[] args) {
        // Sendung und Kunden erstellen
        Sendung s = new Sendung("AT-4711");
        Kunde anna = new SmsKunde("Anna");
        Kunde ben = new EmailKunde("Ben");

        // beide Kunden abonnieren die Sendung
        s.abonnieren(anna);
        s.abonnieren(ben);

        // Statusänderungen durchführen
        s.setCurrStatus("Im Verteilzentrum");

        // Ben möchte keine Benachrichtigungen mehr erhalten
        s.abbestellen(ben);
        // Statusänderungen durchführen
        s.setCurrStatus("In Zustellung");
        // Statusänderungen durchführen, aber der Status ist unverändert
        s.setCurrStatus("In Zustellung");

        // Statusänderungen nochmals durchführen
        s.setCurrStatus("Zugestellt");
    }
}