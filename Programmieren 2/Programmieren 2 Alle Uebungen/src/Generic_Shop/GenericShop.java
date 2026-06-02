package Generic_Shop;

import java.util.HashMap;
import java.util.Map;

public class GenericShop<T> {

    private String name;
    private Map<String, T> products;

    public GenericShop(String name) {
        this.name = name;
        products = new HashMap<>();
    }

    public void showProducts() {

        if(products.isEmpty()) {
            System.out.println("\n" +name+ " is sold out.");
            return;
        }

        System.out.println("\n" + name + "Products:");
        for (String s : products.keySet()) {
            System.out.println("  - "+s);
        }

    }

    public void addProductsFromDelivery(HashMap ds) {
        products.putAll(ds);
    }
}
