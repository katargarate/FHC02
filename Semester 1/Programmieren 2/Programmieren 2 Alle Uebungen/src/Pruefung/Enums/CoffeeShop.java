package Pruefung.Enums;

import java.util.ArrayList;

public class CoffeeShop {
    private String name;
    private ArrayList<Coffee> coffeesMade; // speichert alle Kaffees die gemacht werden

    public CoffeeShop(String name) {
        this.name = name;

        // die Arraylist initialisieren
        coffeesMade = new ArrayList<>();
    }

    public void makeCoffee(Coffee coffee) {
        coffeesMade.add(coffee); // zur Arraylist hinzufügen
    }

    public Coffee getMostExpensiveCoffee() {
        Coffee mostExpensive = coffeesMade.get(0); // inititalize with the first coffee in the list

        // alle Kaffees durchschleifen und mostExpensive updaten, wenn der aktuelle Kaffee teurer ist
        for (Coffee c : coffeesMade) {
            if (c.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = c;
            }
        } return mostExpensive; // teuersten zurückgeben
    }

    public double profitsMade(){
        double profit = 0; // bei null initialisieren

        // durch alle Kaffees schleifen und den Preis zum profit addieren
        for (Coffee c : coffeesMade) {
            profit += c.getPrice();
        }

        return profit; // Gesamtsumme zurückgeben
    }

    public ArrayList<Coffee> getCoffeesOfSpecifiedSize(CoffeeSize coffeeSize) {
        ArrayList<Coffee> coffees = new ArrayList<>();

        // alle Kaffees durchschleifen und nur die zur Liste hinzufügen, die die entsprechende Größe haben (ENUM)
        for (Coffee c : coffeesMade) {
            if (c.getSize() == coffeeSize) {
                coffees.add(c);
            }
        }

        return coffees;
    }

    public void printCoffeesOfSpecifiedSize(CoffeeSize coffeeSize) {
        // von der Methode getCoffeesOfSpecifiedSize die Liste der Kaffees der entsprechenden Größe zurückbekommen
        ArrayList<Coffee> coffees = getCoffeesOfSpecifiedSize(coffeeSize);
        int counter = 0;

        System.out.println("\nCoffees of size " + coffeeSize + ":");

        for (Coffee c : coffees) {
            System.out.printf("%d: %s\n", ++counter, c);// toString Methode vom aktuellen Kaffee wird ausgegeben, Counter vorm ausgeben erhöhen
        }

        System.out.printf("\nTotal coffees of size %s: %d", coffeeSize, counter);

    }


    // gesamte Liste zurückgeben
    public ArrayList<Coffee> getCoffeesMade() {
        return coffeesMade;
    }




}
