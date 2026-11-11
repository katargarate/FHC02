package at.campus02.zam.sd.bsp2.Creators;

import at.campus02.zam.sd.bsp2.Products.Auto;

public abstract class Filiale {
    protected abstract Auto erstelleAuto(String typ);

    // darf laut Angabe nicht überschrieben werden also final
    public final Auto vermieten(String typ, int tage) {
        // Auto Objekt erstellen (oder null, wenn der Typ nicht verfügbar ist)
        Auto auto = erstelleAuto(typ);

        // Ausgabe, ob das Auto verfügbar ist oder nicht
        if (auto == null) {
            System.out.println("Typ " + typ + " ist nicht verfügbar.");
        }

        else {
            System.out.printf("Vermietet: %s für %d Tage = %.2f EUR\n", auto.info(), tage, auto.getTagespreis() * tage);
        }

        return auto; // entweder null oder ein Auto Objekt
    }

}
