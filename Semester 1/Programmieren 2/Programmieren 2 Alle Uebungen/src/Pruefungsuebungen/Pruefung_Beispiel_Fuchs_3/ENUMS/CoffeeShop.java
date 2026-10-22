package Pruefungsuebungen.Pruefung_Beispiel_Fuchs_3.ENUMS;

import java.util.ArrayList;

public class CoffeeShop {
    private String name;
    private ArrayList<Coffee> coffeesMade;

    public CoffeeShop(String name) {
        this.name = name;

        coffeesMade = new ArrayList<>();
    }

    public Coffee makeCoffee(Coffee coffee) {
        coffeesMade.add(coffee);
        return coffee;
    }

    public Coffee getMostExpensiveCoffee() {
        Coffee mostExpensive = coffeesMade.get(0); // inititalize with the first coffee in the list

        // loop through all coffees and if the current coffee is more expensive than mostExpensive,
        // update the most expensive one
        for (Coffee c : coffeesMade) {
            if (c.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = c;
            }
        } return mostExpensive; // return msot expensive
    }

    public double profitsMade(){
        double profit = 0;

        // loop through all the coffees and add their prices to the sum
        for (Coffee c : coffeesMade) {
            profit += c.getPrice();
        }

        return profit; // return the total sum
    }

    public ArrayList<Coffee> getCoffeesMade() {
        return coffeesMade;
    }




}
