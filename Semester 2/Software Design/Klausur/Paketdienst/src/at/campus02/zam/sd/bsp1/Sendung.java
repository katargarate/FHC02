package at.campus02.zam.sd.bsp1;

import java.util.ArrayList;

public class Sendung {
    private ArrayList<Kunde> alleKunden = new ArrayList<>();
    private String currStatus;
    private String sendungsNr;

    public Sendung(String sendungsNr) {
        this.sendungsNr = sendungsNr;
    }

    public void abonnieren(Kunde k) {
        // kunde zu der Liste hinzufügen und eine Nachricht ausgeben
        alleKunden.add(k);
        System.out.println(k.getName() + " hat abonniert.");
    }

    public void abbestellen(Kunde k) {
        // wenn der Kunde in der Liste ist, dann entfernen und eine Nachricht ausgeben
        if (alleKunden.remove(k)) {
            System.out.println(k.getName() + " hat abbestellt.");
        } else { // ansonsten eine andere Nachricht ausgeben
            System.out.println(k.getName() + " wurde nicht gefunden.");
        }
    }

    public void setCurrStatus(String status) {
        // wenn der Status nicht null sit (noch nicht gesetzt) und der Status unverändert ist,
        // dann eine Nachricht ausgeben
        if (currStatus != null && currStatus.equals(status)) {
            System.out.println("Status unverändert.");
        } else { // ansonsten den Status setzen und alle Kunden benachrichtigen
            currStatus = status;
            notifyAllClients();
        }
    }

    private void notifyAllClients() {
        // alle abonnierten Kunden durchlaufen und die update Methode aufrufen
        for (Kunde k : alleKunden) {
            k.update(sendungsNr, currStatus);
        }
    }
}
