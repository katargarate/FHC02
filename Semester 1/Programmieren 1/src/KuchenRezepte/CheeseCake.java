package KuchenRezepte;

public class CheeseCake {
    static void main() {
        bakeCheeseCake();

        ApplePie.bakeApplePie(); // method is protected, but works because its in the same packag
        // BlueberryPie.bakeBlueberryPie // method is private, so cannot be accessed from outside the class
    }

    public static void bakeCheeseCake() {
        System.out.println("Here's a cheese cake recipe: blablabla");
    }
}
