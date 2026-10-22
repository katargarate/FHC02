package Pizzeria.CreatorKlassen;

import Pizzeria.ProduktKlassen.GrazMushroomPizza;
import Pizzeria.ProduktKlassen.GrazVeggiePizza;
import Pizzeria.ProduktKlassen.Pizza;

public class GrazPizzaStore extends PizzaStore {
    protected Pizza createPizza(String pizzaName) {

        return switch (pizzaName) {
            case "veggie" -> new GrazVeggiePizza("Graz veggie");
            case "mushroom" -> new GrazMushroomPizza("Graz mushroom");
            default -> {
                System.err.println("Keine passende Pizza gefunden...");
                yield null;
            }
        };
    }
}
