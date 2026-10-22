package Logistic_Manager_With_Interface;

public class Main {
    static void main(String[] args) {
        LogisticManager manager = new LogisticManager();
        Shirt shirt = new Shirt("Uniqlo", 'M', "White");
        Car car = new Car("BMW", "Blue", 1000.4);

        System.out.println(" --- Empty List: ");
        manager.moveAll("Graz");

        System.out.println("\n --- Filled List: ");
        manager.addMoveable(car);
        manager.addMoveable(shirt);

        manager.moveAll("Graz");

        InterfaceWithStaticMethod.main();

    }
}
