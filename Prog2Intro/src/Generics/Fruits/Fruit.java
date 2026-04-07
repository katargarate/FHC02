package Generics.Fruits;

import java.time.LocalDate;

public class Fruit {
    String name;
    LocalDate dateBought;
    Color colour;

    public Fruit(String name, LocalDate dateBought, Color colour) {
        this.name = name;
        this.dateBought = dateBought;
        this.colour = colour;
    }

    @Override
    public String toString() {
        return String.format("""
                Name: %s
                Date Bought: %s
                Colour: %s
                """, name,dateBought.toString(), colour);

    }
}
