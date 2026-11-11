package Own.Decorator.Beverage;

public class Main {
    static void main(String[] args) {
        Beverage b1 = new Caramel(new Milk(new Espresso()));
        System.out.println("Cost: " + b1.getCost() + " euros");
        System.out.println("Description: " + b1.getDescription());
    }
}
