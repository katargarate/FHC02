package Sorting_Collections;

import java.util.Arrays;

public class SortingArrays {
    static void main(String[] args) {
        String[] cars = {"BMW", "Volvo", "Ford", "Mazda"}; // [BMW, Volvo, Ford, Mazda]
        System.out.println(Arrays.toString(cars));

        // manually switch pos 0 and 1
        String temp = cars[0];
        cars[0] = cars[1];
        cars[1] = temp;

        System.out.println(Arrays.toString(cars)); // [Volvo, BMW, Ford, Mazda]

        // sort alphabetically with Arrays helper method
        Arrays.sort(cars);
        System.out.println(Arrays.toString(cars)); // [BMW, Ford, Mazda, Volvo]


        // sorting objects

        Animal a1 = new Animal("Susi", "Die Katze", 3);
        Animal a2 = new Animal("Berti", "Der Hund", 4);
        Animal a3 = new Animal("Fluffy", "Die Fliedermaus", 5);

        Animal[] animals = {a1, a2, a3};

        Arrays.sort(animals);

        for (Animal animal : animals) {
            System.out.println(animal);
        }

    }
}
