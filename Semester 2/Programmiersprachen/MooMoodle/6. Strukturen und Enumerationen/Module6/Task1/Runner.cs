namespace Module6.Task1;

// Aufgabe 1: Enumerationen
// Erstelle eine Enumeration VehicleType, die verschiedene Fahrzeugtypen enthält: Sedan, SUV, Truck, etc..
// Erweitere die Klasse Vehicle um eine Eigenschaft Type vom Typ VehicleType.
// Füge eine Methode DescribeVehicle zur Klasse Vehicle hinzu, die den Fahrzeugtyp überprüft und auf der
// Konsole ausgibt.
// Erstelle eine Instanz der Klasse wie Car oder ElectricCar, setze den Fahrzeugtyp und rufe die
// DescribeVehicle Methode auf.
static class Runner
{
    public static void Run()
    {
        var car = new Car("Red", "Roadster", 220, 5.0, 2022);
        car.Type = VehicleType.Convertible;
        car.DescribeVehicle();

        var electricCar = new ElectricCar("Silver", "Volt", 200, 75.0, 18.0)
        {
            Type = VehicleType.Suv // Object initializer - sets the property right after the constructor
        };
        electricCar.DescribeVehicle();

        // Type was never set, so it has the enum's default value (0 = Unknown).
        var defaultCar = new Car();
        defaultCar.DescribeVehicle();

        // An enum is stored as a number - it can be cast to int and printed by name.
        Console.WriteLine($"{car.Type} has the value {(int)car.Type}");
    }
}
