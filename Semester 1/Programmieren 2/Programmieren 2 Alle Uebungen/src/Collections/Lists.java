package Collections;

import Generics.Animals.Animal;
import Generics.Animals.AnimalType;

import java.util.ArrayList;
import java.util.List;

public class Lists {
    static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();

        // insert 8 nums (1-8) into the list
        for (int i = 1; i <= 8; i++) {
            integerList.add(i);
        }

        // print list
        System.out.println("FULL LIST");
        System.out.println(integerList);

        // delete 1
        integerList.remove(integerList.size()-1); // remove last value (with index), could also use removeLast()

        // print updated list
        System.out.println("UPDATED LIST");
        System.out.println(integerList);




        // -- ANIMALS

        System.out.println("\n--------ANIMAL TYPE LIST----------\n");
        List<Animal>  animalList = new ArrayList<>();
        Animal dog = new Animal("Woofy", "dog", AnimalType.MAMMAL);
        Animal parrot = new Animal("Birdy", "parrot", AnimalType.BIRD);

        //  2 Animals hinzufügen
        animalList.add(dog);
        animalList.add(parrot);

        // print list
        System.out.println("FULL LIST\n");
        printList(animalList);

        // delete 1 animal
        animalList.remove(dog); // deletes first matching instance of this object

        // edit parrot name
        // since the list is just an index, it'll update in the list as well
        parrot.name = "Perry";

        // print updated list
        System.out.println("UPDATED LIST\n");
        printList(animalList);




    }

    public static void printList(List<Animal> animalList) {
        for (int i = 0; i < animalList.size(); i++) {
            System.out.println((i + 1) + ": \n" + animalList.get(i));
        }
    }


}
