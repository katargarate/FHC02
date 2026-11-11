package at.campus02.zam.sd.bsp2;

import at.campus02.zam.sd.bsp2.Creators.FilialeGraz;
import at.campus02.zam.sd.bsp2.Creators.FilialeWien;

public class Main {
    public static void main(String[] args) {
        // Erstellen der Filialen
        FilialeGraz graz = new FilialeGraz();
        FilialeWien wien = new FilialeWien();

        // Vermietung von Autos
        graz.vermieten("klein", 3);
        wien.vermieten("familie", 2);
        wien.vermieten("cabrio", 1);
    }
}