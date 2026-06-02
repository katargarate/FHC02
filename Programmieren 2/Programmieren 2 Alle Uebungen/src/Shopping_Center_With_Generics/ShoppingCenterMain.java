package Shopping_Center_With_Generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCenterMain {
    public static void main(String[] args) {
        System.out.println("Shopping Center is open!");
        GenericShop<Candy> candyShop = new GenericShop<>("SweetPoint");
        //GenericShop<Book> bookShop = new GenericShop<>("Fitch");

        // Schritt 1: lokale HashMap mit Candies darin erstellen
        HashMap<String, Candy> candies = new HashMap<>();
        candies.put("pinkCandy", new Candy("pink", "pinkCandy", 2.1, "sour", "round"));
        candies.put("redCandy", new Candy("red", "redCandy", 2.1, "sour", "round"));
        candies.put("greenCandy", new Candy("green", "greenCandy", 2.1, "sour", "round"));

        candyShop.showProducts();
        //Schritt 2: Diese HashMap dem Delivery Service übergen
        DeliveryService<Candy> deliveryService = new DeliveryService<>(candies);
        //Schritt 3: Deliver Service übergibt candies an CandyShop
        candyShop.addProductsFromDelivery((HashMap) deliveryService.getProductsToDeliver());
        //Schritt 4: Candies sind im CandyShop angekommen
        //HashMap wird vom Shop ausgegeben
        candyShop.showProducts();
        //Schritt 5: ein Produkt verkaufen
        candyShop.sellAProduct("redCandy");
        //Schritt 6: Erneut ausgeben -> redCandy fehlt
        candyShop.showProducts();
        System.out.println("Shopping Center is closed!");
    }
}