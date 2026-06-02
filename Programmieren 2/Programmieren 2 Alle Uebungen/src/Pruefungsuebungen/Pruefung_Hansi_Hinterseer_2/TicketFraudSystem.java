package Pruefungsuebungen.Pruefung_Hansi_Hinterseer_2;
import java.util.ArrayList;
import java.util.Random;

// DO NOT CHANGE THIS CLASS - JUST USE THE METHODS

public class TicketFraudSystem {
    private static ArrayList<String> knownTickets = new ArrayList<String>();

    public static String createNewTicket(String type)
    {
        String key = null;
        switch(type){
            case "paper":
                key = "P_"+ randomHelper("0123456789", 8);
                break;
            case "app":
                key = "A_"+ randomHelper("0123456789ABCDEF", 16);
                break;
            case "moonboot":
                key = "M_"+ randomHelper("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 8);
                break;
        }
        if(key != null && knownTickets.contains(key))
        {
            return createNewTicket(type);
        }
        knownTickets.add(key);
        return key;
    }
    public static boolean checkTicket(NFCTicket ticket){
        return knownTickets.contains(ticket.getSecret());
    }
    private static String randomHelper(String alphabet, int nrChar){
        Random r = new Random();
        String key = "";
        for (int i = 0; i < nrChar; ++i) {
            key = key + alphabet.charAt(r.nextInt(alphabet.length()));
        }
        return key;
    }
}
