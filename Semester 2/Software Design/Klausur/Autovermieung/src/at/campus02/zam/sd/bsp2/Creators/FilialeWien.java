package at.campus02.zam.sd.bsp2.Creators;


import at.campus02.zam.sd.bsp2.Products.Auto;
import at.campus02.zam.sd.bsp2.Products.VwPolo;
import at.campus02.zam.sd.bsp2.Products.VwTouran;

public class FilialeWien extends Filiale {
    @Override
    protected Auto erstelleAuto(String typ) {
        // Auto Objekt erstellen (oder null, wenn der Typ nicht verfügbar ist)
        return switch(typ) {
            case "klein" -> new VwPolo();
            case "familie" -> new VwTouran();
            default -> null;
        };
    }
}
