package at.campus02.zam.sd.bsp2.Creators;


import at.campus02.zam.sd.bsp2.Products.Auto;
import at.campus02.zam.sd.bsp2.Products.Fiat500;
import at.campus02.zam.sd.bsp2.Products.SkodaOctaviaKombi;

public class FilialeGraz extends Filiale {
    @Override
    protected Auto erstelleAuto(String typ) {
        // Auto Objekt erstellen (oder null, wenn der Typ nicht verfügbar ist)
        return switch(typ) {
            case "klein" -> new Fiat500();
            case "familie" -> new SkodaOctaviaKombi();
            default -> null;
        };
    }
}
