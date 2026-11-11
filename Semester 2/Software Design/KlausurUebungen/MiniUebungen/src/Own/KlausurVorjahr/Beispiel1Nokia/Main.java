package Own.KlausurVorjahr.Beispiel1Nokia;

import Own.KlausurVorjahr.Beispiel1Nokia.Factories.BaseStationFactory;
import Own.KlausurVorjahr.Beispiel1Nokia.Factories.BootFactory;
import Own.KlausurVorjahr.Beispiel1Nokia.Products.Product;

public class Main {
    // bitte selbst implementieren
    static void main(String[] args) {
        BaseStationFactory baseStationFactory = new BaseStationFactory();
        BootFactory bootFactory = new BootFactory();

        System.out.println("Try to produce boots at the base station factory");
        printProduceResults(baseStationFactory.produce(ProductType.BOOTS));

        System.out.println("\nProduce boots at boots factory");
        printProduceResults(bootFactory.produce(ProductType.BOOTS));

        System.out.println("\nProduce 3G Base Station at Base Station Own.Factory");
        printProduceResults(baseStationFactory.produce(ProductType.STATION3G));

        System.out.println("\nProduce 4G Base Station at Base Station Own.Factory");
        printProduceResults(baseStationFactory.produce(ProductType.STATION4G));

        System.out.println("\nProduce 35G Base Station at Base Station Own.Factory");
        printProduceResults(baseStationFactory.produce(ProductType.STATION5G));

    }

    public static void printProduceResults(Product product) {
        if (product != null) {
            System.out.println("Product: " + product);
            System.out.println("Speed: " + product.getSpeed());
        }

        else  {
            System.out.println("Product is null");
        }
    }
}
