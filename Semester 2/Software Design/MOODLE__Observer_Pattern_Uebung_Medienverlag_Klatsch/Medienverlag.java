package klatsch.krone.at;


import java.util.ArrayList;
import java.util.List;

// Sollte ein Interface implementieren
 class Medienverlag {

    private List<Abonnent> abonnenten = new ArrayList<Abonnent>();

    public void veroeffentliche(Artikel artikel1) {

        for(Abonnent einAbonnent : abonnenten) {
            einAbonnent.erhalte(artikel1);
        }
    }

    public void addSubscriber(Abonnent einAbonnent){
        abonnenten.add(einAbonnent);
        System.out.println("Medianverlag: +Subscriber " + einAbonnent.getName() +
                " hinzugefügt");
    }

    public void removeSubscriber(Abonnent einAbonnent){
        abonnenten.remove(einAbonnent);
    }
}
