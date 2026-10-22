namespace NewApp;

class Program
{
    static void Main(string[] args)
    {
        // Uncomment the method(s) you want to run:

        // AskAge();
        // AskName();
        // DivisionExample();
        // CounterIncrement();
        // DayOfTheWeekArray();
        // CarBasics();
        // TripDetailsParamsAndLogging();
        // CarsWithNewConstructors();
        KonstruktorVariantenCar();
    }

    static void KonstruktorVariantenCar()
    {
        Car car1 = new Car("Red", 220, "Toyota", 6.5);
        Car car2 = new Car("Blue", 180, "Honda", 5.0);
        Car car3 = new Car("Green", "Ford"); 
        Car car4 = new Car(300, 7.0);
        Car car5 = new Car();

        Console.WriteLine("\n\n-- Five new Cars with different constructors:");

        Console.WriteLine($"Car 1: Colour: {car1.color}, Model: {car1.Model}, Max Speed: {car1.MaxSpeed} km/h, Fuel Efficiency: {car1.FuelEfficiency} L/100km");
        Console.WriteLine($"Car 2: Colour: {car2.color}, Model: {car2.Model}, Max Speed: {car2.MaxSpeed} km/h, Fuel Efficiency: {car2.FuelEfficiency} L/100km");
        Console.WriteLine($"Car 3: Colour: {car3.color}, Model: {car3.Model}, Max Speed: {car3.MaxSpeed} km/h, Fuel Efficiency: {car3.FuelEfficiency} L/100km");
        Console.WriteLine($"Car 4: Colour: {car4.color}, Model: {car4.Model}, Max Speed: {car4.MaxSpeed} km/h, Fuel Efficiency: {car4.FuelEfficiency} L/100km");
        Console.WriteLine($"Car 5: Colour: {car5.color}, Model: {car5.Model}, Max Speed: {car5.MaxSpeed} km/h, Fuel Efficiency: {car5.FuelEfficiency} L/100km");

        Console.WriteLine($"\n\nTotal number of cars created: {Car.CarCount}");
    }

    static void AskAge()
    {
        Console.WriteLine("What is your age?");
        string ageInput = Console.ReadLine();
        if (!int.TryParse(ageInput, out int ageConverted))
        {
            Console.WriteLine("Invalid input. Please enter a valid integer.");
            return;
        }
        Console.WriteLine($"You are {ageConverted} years old.");
    }

    static void AskName()
    {
        Console.WriteLine("What is your name?");
        string name = Console.ReadLine();
        Console.WriteLine($"Hello, {name}!");
    }

    static void DivisionExample()
    {
        Console.WriteLine("Dividing 3/4: " + 3.0 / 4.0);
    }

    static void CarBasics()
    {
        Car myCar = new Car("Toyota", 5.0);

        myCar.color = "Red";
        myCar.MaxSpeed = 250;

        Console.WriteLine($"\nInitial Max Speed: {myCar.MaxSpeed} km/h");
        myCar.MaxSpeed = 350; // This will be capped at 300 due to the 300km limit
        Console.WriteLine($"Updated Max Speed after attempting to bypass the 300km/h limit: {myCar.MaxSpeed} km/h");

        Console.WriteLine($"\n\nMy car is a {myCar.color} {myCar.Model} with a max speed of {myCar.MaxSpeed} km/h.\n\n");

        myCar.StartEngine();
        myCar.Drive(100);
        Console.WriteLine($"Fuel Level: {myCar.GetFuelLevel(out double maxDistance)} liters");
        Console.WriteLine($"Max Distance: {maxDistance} km");

        myCar.Drive(50, 120);
    }

    static void TripDetailsParamsAndLogging()
    {
        Console.WriteLine("\n\n--- Trip Details ---");

        Car myCar = new Car("Toyota", 5.0);
        myCar.PrintTrip(200, 80, "Berlin"); // Specifying all parameters
        myCar.PrintTrip(150); // Using default speed and destination
        myCar.PrintTrip(300, destination: "Munich"); // Using default speed

        Console.WriteLine("\n\n--- Logging Stops ---");
        myCar.LogStops("Gas Station", "Rest Area", "Restaurant");
    }

    static void CarsWithNewConstructors()
    {
        Console.WriteLine("\n\n-- Two new Cars with different constructors:");
        Car newCar1 = new Car("Blue", 220, "Honda", 6.5);
        Car newCar2 = new Car("Green", 280, "Ford", 7.0);
        Console.WriteLine($"\n\nNew Car 1: {newCar1.color} {newCar1.Model} with a max speed of {newCar1.MaxSpeed} km/h.");
        Console.WriteLine($"\n\nNew Car 2: {newCar2.color} {newCar2.Model} with a max speed of {newCar2.MaxSpeed} km/h.");
    }

    static void CounterIncrement()
    {
        Console.WriteLine("Counter Only Even Numbers: ");
        for (int i = 0; i <= 10; i++)
        {
            if (i % 2 != 0)
            {
                continue;
            }

            Console.WriteLine(i);
        }

        Console.WriteLine("\nBackwards counter: ");
        for (int i = 10; i >= 0; i--)
        {
            Console.WriteLine(i);
        }
    }

    static void DayOfTheWeekArray()
    {
        while (true)
        {
            string[] days = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

            Console.Write("Enter a number to display the corresponding day of the week (1-7): ");
            int input = int.Parse(Console.ReadLine());

            string day;

            switch (input)
            {
                case 1:
                    day = days[0];
                    break;
                case 2:
                    day = days[1];
                    break;
                case 3:
                    day = days[2];
                    break;
                case 4:
                    day = days[3];
                    break;
                case 5:
                    day = days[4];
                    break;
                case 6:
                    day = days[5];
                    break;
                case 7:
                    day = days[6];
                    break;
                default:
                    Console.WriteLine("\nInvalid input. Please enter a number between 1 and 7.\n");
                    continue;
            }
            Console.WriteLine("The day is: " + day + "\n");
            break;
        }
    }
}