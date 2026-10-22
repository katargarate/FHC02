import Model.Ente;
import Model.FlugVerhalten.FlatterflugVerhalten;
import Model.FlugVerhalten.FlugVerhalten;
import Model.FlugVerhalten.SegelnflugVerhalten;
import Model.Rotkopfente;
import Model.Stockente;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Ente> alleEnten = new ArrayList<>();


        alleEnten.add(new Stockente("Stocky", new FlatterflugVerhalten()));

        alleEnten.add(new Rotkopfente("Roty", new SegelnflugVerhalten()));

        alleEnten.add(new Rotkopfente("Gummi", null));


        for (Ente e : alleEnten) {
           e.anzeigen();
           e.quaken();
           e.schwimmen();
           e.fliegen();
           System.out.println();
        }

        System.out.println("-- Flugverhalten von Gummi auf 1 flattern ändern: ");
        alleEnten.get(2).flugVerhalten =  new FlatterflugVerhalten() ;
        alleEnten.get(2).fliegen();


    }
}