package Shopping_Center_With_Generics;

import java.util.HashMap;
import java.util.Map;

public class DeliveryService<T> {
    private Map<String, T> productsToDeliver = new HashMap<>();

    public DeliveryService(Map<String, T> productsToDeliver) {
        this.productsToDeliver = productsToDeliver;
    }
    public Map<String, T> getProductsToDeliver() {
        return productsToDeliver;
    }
    public void setProductsToDeliver(Map<String, T> productsToDeliver) {
        this.productsToDeliver = productsToDeliver;
    }
}
