package at.campus02.enums;

import java.util.ArrayList;

public class Main {
    // insantiate the coffee shop
    public static CoffeeShop shop = new CoffeeShop("Java Beans");

    static void main(String[] args) {
        // make 4 different coffees using the enum CofffeSize
        Coffee c1 = new Coffee("Espresso", CoffeeSize.Small, 2.50);
        Coffee c2 = new Coffee("Latte", CoffeeSize.Medium, 3.50);
        Coffee c3 = new Coffee("Americano", CoffeeSize.ExtraLarge, 4.50);
        Coffee c4 = new Coffee("Cappuccino", CoffeeSize.Large, 4.00);
        Coffee c5 = new Coffee("Cappucino", CoffeeSize.Medium, 3.50);
        Coffee c6 = new Coffee("Latte", CoffeeSize.ExtraLarge, 4.50);

        // print the list of all coffees made
        printCoffeesMade(); // still empty

        // make 1 of each coffee
        shop.makeCoffee(c1);
        shop.makeCoffee(c2);
        shop.makeCoffee(c3);
        shop.makeCoffee(c4);
        shop.makeCoffee(c5);
        shop.makeCoffee(c6);

        // print the list of all coffees made
        printCoffeesMade();

        // display most expensive coffee
        System.out.printf("\nThe most expensive coffee is: %s\n", shop.getMostExpensiveCoffee());

        // display total profits made
        System.out.println("\nTotal profits made: €" + shop.profitsMade());


        // Kaffees mit der Größe Medium ausgeben
        shop.printCoffeesOfSpecifiedSize(CoffeeSize.Medium);

    }

    public static void printCoffeesMade() {
        // print the list of all coffees made
        ArrayList<Coffee> coffeesMade = shop.getCoffeesMade();

        // if the list is empty, print an error message, otherwise loop through all the coffees and print them
        if (coffeesMade.isEmpty()) {
            System.err.println("\nNo coffees have been made yet.");
        } else {
            System.out.println("\nCoffees made:");
            for (Coffee coffee : coffeesMade) {
                System.out.println(coffee);
            }
        }
    }
}
