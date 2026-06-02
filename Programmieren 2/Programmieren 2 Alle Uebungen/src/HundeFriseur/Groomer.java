package HundeFriseur;

import HundeFriseur.Dogs.Dog;

public class Groomer {
    private String name;
    private int age;

    public Groomer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void cutDogHair(Dog goodBoy, int lengthToCut) {
        int newHairLength = lengthToCut - goodBoy.getHairLength();
        goodBoy.setHairLength(newHairLength);
    }
}
