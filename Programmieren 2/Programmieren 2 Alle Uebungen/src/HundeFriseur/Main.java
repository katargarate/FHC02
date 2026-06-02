package HundeFriseur;

import HundeFriseur.Dogs.Beagle;
import HundeFriseur.Dogs.Corgi;
import HundeFriseur.Dogs.GoldenRetriever;

public class Main {
    static void main(String[] args) {
        // --- make dog instances
        Beagle beagle = new Beagle("Buddy", 4, true);
        Corgi corgi = new Corgi("Smoochie", 2, true);
        GoldenRetriever gr = new GoldenRetriever("Goldie", 5, false);

        // --- make groomer instance
        Groomer groomer = new Groomer("Johann", 50);

        // test breed specific methods
        beagle.isAGoodBoy(true);
        corgi.kissGroomer();
        gr.bark();

        // -- test cutting the dogs hair, first with a valid length, then with an invalid one
        System.out.println("\n---- CUT BEAGLE'S HAIR");
        groomer.cutDogHair(beagle, 2);
        groomer.cutDogHair(beagle, 5);

        System.out.println("\n---- CUT CORGIS'S HAIR");
        groomer.cutDogHair(corgi, 1);
        groomer.cutDogHair(corgi, 5);

        System.out.println("\n---- CUT GOLDIE'S HAIR");
        groomer.cutDogHair(gr, 1);
        groomer.cutDogHair(gr, 6);

    }



}
