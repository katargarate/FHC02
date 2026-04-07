package Generics.Animals;

public class Animal {
    public String name;
    public String species;
    public AnimalType animalType;


    public Animal(String name, String species, AnimalType animalType) {
        this.name = name;
        this.species = species;
        this.animalType = animalType;
    }

    @Override
    public String toString() {
        return String.format("""
                Animal: %s
                Species: %s
                Animal Type: %s
                """, name, species, animalType);

    }
}
