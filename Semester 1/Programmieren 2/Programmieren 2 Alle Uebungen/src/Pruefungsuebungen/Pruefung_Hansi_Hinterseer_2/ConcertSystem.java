package Pruefungsuebungen.Pruefung_Hansi_Hinterseer_2;
import java.util.ArrayList;
import java.util.HashMap;

/*
TODO:
public void sortAndPrintForAccounting(): Sortieren Sie die ArrayList mit dem Comparator
AccountingComparator.
Geben Sie danach in der Methode für jedes Ticket Kategorie und Sicherheitscode aus. Ihnen
steht frei wie genau, solange beide Werte separat nebeneinander oder untereinander
ausgegeben werden (und damit die Sortierung nachvollziehbar ist). (6 Punkte)
 */

public class ConcertSystem {

    protected ArrayList<NFCTicket> allTickets;

    public ConcertSystem() {
        allTickets = new ArrayList<>();
    }

    public boolean addTicket(NFCTicket ticket) {
        // wenn die Karte schon im ArrayList dabei ist, false zurückgeben
        if (allTickets.contains(ticket)) {
            return false;
        }

        // dann erst prüfen, ob das Ticket gültig ist
        if (TicketFraudSystem.checkTicket(ticket)) {
            allTickets.add(ticket); // wenn es gültig ist, zu Arraylist hinzufügen
            return true; // und true zurückgeben
        } else return false; // bei ungültige Tickets false zurückgeben
    }

    public double profitPerCategory(int category) {
        double totalProfit = 0;
        int counter = 0;

        // alle Tickets durchschleifen und die Summe von allen mit der passenden Kategorie summieren
        for (NFCTicket ticket : allTickets) {
            if (ticket.getCategory() == category) {
                totalProfit += ticket.getProfit();
                counter++;
            }
        }

        // durchschnitt berechnen und zurückgeben
        return totalProfit / counter;
    }

    public ArrayList<String> invitedToStage() {
        ArrayList<String> invitedToStage = new ArrayList<>();
        for (NFCTicket ticket : allTickets) {
            // alle Moon Boot Namen hinzufügen
            if (ticket.getSecret().startsWith("M")) {
                invitedToStage.add(ticket.getTicketOwner());
            }

            // alle App Ticket mit Kat 1 Namen hinzufügen
            if (ticket.getSecret().startsWith("A") && ticket.getCategory() == 1) {
                invitedToStage.add(ticket.getTicketOwner());
            }
        }

        return invitedToStage;
    }

    public HashMap<Integer, Double> donationPerCategory() {
       HashMap<Integer, Double> donationPerCategory = new HashMap<>();

       donationPerCategory.put(1, (profitPerCategory(1) * 0.3));
       donationPerCategory.put(2, (profitPerCategory(2) * 0.2));
       donationPerCategory.put(3, (profitPerCategory(3) * 0.1));

       return donationPerCategory;
    }

    public void sortAndPrintForAccounting() {
        AccountingComparator accountingComparator = new AccountingComparator();
        allTickets.sort(accountingComparator);

        for (NFCTicket ticket : allTickets) {
            System.out.printf("Category. %d | Secret: %s\n", ticket.getCategory(), ticket.getSecret());
        }

    }


}
