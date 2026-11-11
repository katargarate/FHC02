package Own.KlausurVorjahr.Beispiel1Nokia.Factories;

import Own.KlausurVorjahr.Beispiel1Nokia.ProductType;
import Own.KlausurVorjahr.Beispiel1Nokia.Products.BaseStation3G;
import Own.KlausurVorjahr.Beispiel1Nokia.Products.BaseStation4G;
import Own.KlausurVorjahr.Beispiel1Nokia.Products.BaseStation5G;
import Own.KlausurVorjahr.Beispiel1Nokia.Products.Product;

public class BaseStationFactory extends NokiaFactory{
    @Override
    public Product produce(ProductType productType) {
        return switch (productType) {
            case STATION3G -> new BaseStation3G();
            case STATION4G -> new BaseStation4G();
            case STATION5G -> new BaseStation5G();
            default -> null;
        };
    }
}
