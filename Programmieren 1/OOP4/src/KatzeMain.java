import Models.Hund;
import Models.Katze;

public class KatzeMain {

    static void main() {
        Katze meowy = new Katze("Mogli", 3, "Maine Coone");
        Hund hund1 = new Hund("Tessa", 7, "Mudi", "Grau");
        Hund hund2 = new Hund("Foxi", 5, "Bernadiner", "Schwarz");

        meowy.hundWeglaufen(hund1);
        meowy.hundWeglaufen(hund2);

        meowy.knurren();
    }
}
