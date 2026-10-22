package Generics;

import Generics.Animals.Animal;
import Generics.Animals.AnimalType;
import Generics.Fruits.Color;
import Generics.Fruits.Fruit;
import Generics.Fruits.FruitPrinter;

import java.time.LocalDate;

public class GenMain {
    static void main(String[] args) {

        StringPrinter sp = new StringPrinter();
        IntPrinter ip = new IntPrinter();
        DoublePrinter dp = new DoublePrinter();
        FruitPrinter  fp = new FruitPrinter();
        GenericPrinter<Fruit> gpFruit = new GenericPrinter<>(); // instance has to say what datatype were using
        GenericPrinter<Double> gpDouble = new GenericPrinter<>(); // cannot take primitive types, so have to use Double, not double
        GenericPrinter<Integer> gpInt = new GenericPrinter<>();
        GenericPrinter<String> gpString = new GenericPrinter<>();
        GenericPrinter<Animal> gpAnimal = new GenericPrinter<>();


        System.out.println("--- PRINT WITH INDIVIDUAL PRINTERS ---");
        sp.printString("Hallo von StringPrinter");
        ip.printInt(123);
        dp.printDouble(0.123d);

        Fruit fr = new Fruit("Kiwi", LocalDate.now(), Color.GREEN);
        Animal animal = new Animal("Woofy","Dog", AnimalType.MAMMAL);

        fp.print(fr); // print with fruit printer

        System.out.println("--- PRINT WITH GENERIC PRINTERS ---");

        gpString.print("Hallo von GenericPrinter");
        gpInt.print(123);
        gpDouble.print(0.123d);
        gpFruit.print(fr); // print fruit with generic printer
        gpAnimal.print(animal);



    }
}
