package Generic_Shop;

import java.util.Map;

public class DeliveryService<T> {

    private Map<String, T> productsToDeliver;

    public DeliveryService(Map<String, T> products) {
        this.productsToDeliver = products;
    }

    public Map<String, T> getProductsToDeliver() {
        return productsToDeliver;
    }

    public void setProductsToDeliver(Map<String, T> productsToDeliver) {
        this.productsToDeliver = productsToDeliver;
    }
}
