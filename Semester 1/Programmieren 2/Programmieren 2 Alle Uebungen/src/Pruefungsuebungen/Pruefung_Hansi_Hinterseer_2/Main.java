package Pruefungsuebungen.Pruefung_Hansi_Hinterseer_2;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        AppTicket at1 = new AppTicket("kat", 100, "android");
        AppTicket at2 = new AppTicket("sabo", 150, "android");
        PaperTicket pt1 = new PaperTicket("cago", 100, 20, false);
        PaperTicket pt2 = new PaperTicket("lago", 100, 20, true);
        MoonBoot mb1 = new MoonBoot("bat", true);
        MoonBoot mb2 = new MoonBoot("rat", false);

        ConcertSystem concertSystem = new ConcertSystem();

        // alle Tickets zum Concert System hinzufügen
        concertSystem.addTicket(at1);
        concertSystem.addTicket(at2);
        concertSystem.addTicket(pt1);
        concertSystem.addTicket(pt2);
        concertSystem.addTicket(mb1);
        concertSystem.addTicket(mb2);


        // alle toStrings mit allen Attributen ausgeben
        System.out.println("-- TEST: DISPLAYING ALL TICKETS --");
        System.out.println(at1);
        System.out.println(at2);
        System.out.println(pt1);
        System.out.println(pt2);
        System.out.println(mb1);
        System.out.println(mb2);


        // Spenden pro Kategorie ausgeben
        System.out.println("\n-- TEST: DISPLAYING DONATIONS PER CATEGORY --");
        HashMap<Integer, Double> donationsPerCat = concertSystem.donationPerCategory();
        // display each entry in the hashmap
        for (Map.Entry<Integer, Double> entry : donationsPerCat.entrySet()) {
            System.out.printf("Category %d \t ->\t Donation: €%.2f\n", entry.getKey(), entry.getValue());
        }

        // Gewinne pro Kategorie ausgeben
        System.out.println("\n-- TEST: DISPLAYING PROFITS PER CATEGORY --");

        for (int i = 1; i <= 3; i++) {
            System.out.printf("Category %d \t -> \t Profit: €%.2f\n", i, concertSystem.profitPerCategory(i));
        }

        // Alle Namen von Ticketbesitzer, die auf die Bühne dürfen
        System.out.println("\n-- TEST: DISPLAYING ALL TICKET OWNERS INVITED ON STAGE --");
        ArrayList<String> invitedToStage = concertSystem.invitedToStage();

        for (String name : invitedToStage) {
            System.out.println(name);
        }


        System.out.println("\n-- TEST: SORTING AND DISPLAYING SORTED TICKETS --");
        concertSystem.sortAndPrintForAccounting();
    }



}
