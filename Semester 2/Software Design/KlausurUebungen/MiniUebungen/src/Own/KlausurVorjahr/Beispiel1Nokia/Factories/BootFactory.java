package Own.KlausurVorjahr.Beispiel1Nokia.Factories;

import Own.KlausurVorjahr.Beispiel1Nokia.ProductType;
import Own.KlausurVorjahr.Beispiel1Nokia.Products.*;


public class BootFactory extends NokiaFactory {
    @Override
    public Product produce(ProductType productType) {
        return switch(productType) {
            case BOOTS -> new Boots();
            default -> null;
        };
    }

}
