package Own.Decorator.Autokonfigurator;

public class Main {
    static void main(String[] args) {
        // Hier ist das Own.Decorator Pattern viel besser als für jede Kombination eine eigene Klasse zu haben,
        // weil wir nur alle Teile definieren müssen und dann können alle mögliche Kombinationen erstellt werden.
        // Es ist natürlich sehr leicht wartbar, da z.B. Preisänderungen nur in eine Stelle passieren müssen, und ebenso
        // leicht zu erweitern, z.B. mit neuen Komponenten

        Car deckedOutCar = new AirConditioning(new NavigationSystem(new HeatedSeats(new BasicCar())));
        Car heatedCar = new HeatedSeats(new BasicCar());
        Car naviCar = new NavigationSystem(new BasicCar());
        Car airConCar = new AirConditioning(new BasicCar());

        System.out.println("\nCar with all components: " + printCar(deckedOutCar));
        System.out.println("\nCar with only heated seats: " + printCar(heatedCar));
        System.out.println("\nCar with only navigation system: " + printCar(naviCar));
        System.out.println("\nCar with only air conditioning: " + printCar(airConCar));

    }

    public static String printCar(Car car) {
        return String.format("Description: %s, Price: €%.2f", car.getDescription(), car.getPrice());
    }
}
