package Generic_Shop;

import java.util.HashMap;

public class ShoppingCenterMain {

    static void main(String[] args) {
        System.out.println("Shopping center is open!");

        // make a shop instance
        GenericShop<Candy> candyShop = new GenericShop<>("Sweet Point");

        // make local candy list
        HashMap<String, Candy> candies = new HashMap<>();
        candies.put("skittles", new Candy("red", "red skittles", 1.6, "sour", "round"));
        candies.put("starburst", new Candy("rainbow", "starburst", 3.9, "sweet", "squared"));
        candies.put("airheads", new Candy("silver", "mystery airhead", 1.0, "unknown", "rectangular"));

        // display products in shop
        candyShop.showProducts(); // candy shop still empty in this case

        // give the local list to a delivery service instance
        DeliveryService<Candy> deliveryService = new DeliveryService<>(candies);

        // delivery service gives the candies HashMap to the cay shop
        candyShop.addProductsFromDelivery((HashMap) deliveryService.getProductsToDeliver());

        // Candies are now in the candy shop and can be displayed via the candy shop instance directly
        candyShop.showProducts();


    }
}
