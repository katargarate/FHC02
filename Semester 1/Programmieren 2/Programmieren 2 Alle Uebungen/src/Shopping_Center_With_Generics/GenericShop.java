package Shopping_Center_With_Generics;

import java.util.HashMap;
import java.util.Map;

public class GenericShop<T> {
    private final String name;
    private Map<String, T> products;

    public GenericShop(String name) {
        this.name = name;
        products = new HashMap<>();
    }

    public void addProductsFromDelivery(HashMap<String, T> deliveredProducts) {
        products.putAll(deliveredProducts);
    }


    public void sellAProduct(String productName) {
        products.remove(productName);
    }


    public void showProducts() {
        if(products.isEmpty()){
            System.out.println("Shop: Sorry, we are sold out today.");
            return;
        }
        System.out.println("Shop Products: ");
        for (String key : products.keySet()) {
            System.out.println(key);
        }
    }
}