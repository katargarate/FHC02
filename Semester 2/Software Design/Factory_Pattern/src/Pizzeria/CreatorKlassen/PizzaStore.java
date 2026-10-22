package Pizzeria.CreatorKlassen;

import Pizzeria.ProduktKlassen.Pizza;

public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);

        if (pizza == null) {
            return null;
        }

        pizza.prepare();
        pizza.bake();
        pizza.box();
        pizza.cut();
        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}
