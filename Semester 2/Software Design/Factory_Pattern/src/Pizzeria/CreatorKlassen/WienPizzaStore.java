package Pizzeria.CreatorKlassen;

import Pizzeria.ProduktKlassen.*;

public class WienPizzaStore extends PizzaStore {

    protected Pizza createPizza(String pizzaName) {

        return switch (pizzaName) {
            case "veggie" -> new WienVeggiePizza("Wien veggie");
            case "mushroom" -> new WienMushroomPizza("Wien mushroom");
            default -> {
                System.err.println("Keine passende Pizza gefunden...");
                yield null;
            }
        };
    }
}
