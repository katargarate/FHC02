package at.campus02.zam.sd.bsp3;

public class Main {
    public static void main(String[] args) {
        // Aufträge erstellen
        DruckAuftrag druckAuftrag = new DruckAuftrag("Skriptum.pdf", 2);
        ScanAuftrag scanAuftrag = new ScanAuftrag("Rechnung.jpg");
        DruckAuftrag druckAuftrag2 = new DruckAuftrag("Plakat.pdf", 1);

        // Warteschlange erstellen und Aufträge hinzufügen
        Warteschlange warteschlange = new Warteschlange();
        warteschlange.hinzufuegen(druckAuftrag);
        warteschlange.hinzufuegen(scanAuftrag);
        warteschlange.hinzufuegen(druckAuftrag2);

        // soll die Warteschlange abarbeiten und die Aufträge ausführen
        System.out.println("\n-- erstes mal Warteschlange abarbeiten mit 3 Aufträgen --");
        warteschlange.abarbeiten();

        // soll gleich "Nichts zu tun." ausgeben, da die Warteschlange leer ist
        System.out.println("\n-- zweites mal Warteschlange abarbeiten mit 0 Aufträgen --");
        warteschlange.abarbeiten();
    }
}