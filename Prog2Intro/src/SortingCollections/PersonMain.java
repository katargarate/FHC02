package SortingCollections;

import java.util.Arrays;

public class PersonMain {

    static void main(String[] args) {

        Person[] people = {
                new Person(4321, "Max", "Mustermann"),
                new Person(3456, "Silvia", "Musterfrau")
        };

        // uses compareTo method of Comparable Interface
        Arrays.sort(people);

        for (Person p : people) {
            System.out.println(p);
        }



    }
}
