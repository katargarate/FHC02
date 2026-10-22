import Pizzeria.CreatorKlassen.GrazPizzaStore;
import Pizzeria.CreatorKlassen.PizzaStore;
import Pizzeria.CreatorKlassen.WienPizzaStore;
import Pizzeria.ProduktKlassen.Pizza;

public class Main {
    static void main(String[] args) {
        PizzaStore gStore = new GrazPizzaStore();
        PizzaStore wStore = new WienPizzaStore();

        System.out.println("---- Wien Mushroom Pizza");
        Pizza pizza1 = wStore.orderPizza("mushroom");
        System.out.println("\n Main: Ich habe eine '" + pizza1.getName() + "' Pizza bestellt.");

        System.out.println("\n---- Graz Veggie Pizza");
        Pizza pizza2 = gStore.orderPizza("veggie");
        System.out.println("\nMain: Ich habe eine '" + pizza2.getName() + "' Pizza bestellt.");
    }
}