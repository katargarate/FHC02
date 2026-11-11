using System;
using System.Collections.Generic;

static class Helpers
{
    // ************************************************************
    // INPUT
    // ************************************************************

    // 1. plain string input
    public static string AskString(string prompt)
    {
        Console.Write(prompt);
        return Console.ReadLine() ?? "";
    }

    // 2. int input with TryParse, repeats until valid
    public static int AskInt(string prompt)
    {
        int number;
        bool ok;
        do
        {
            Console.Write(prompt);
            ok = int.TryParse(Console.ReadLine(), out number);
            if (!ok)
            {
                Console.WriteLine("Invalid input, please enter a whole number.");
            }
        } while (!ok);
        return number;
    }

    // 3. int input with int.Parse + try/catch/finally, repeats until valid
    public static int AskIntTryCatch(string prompt)
    {
        int number = 0;
        bool ok = false;
        do
        {
            Console.Write(prompt);
            try
            {
                number = int.Parse(Console.ReadLine() ?? "");
                ok = true;
            }
            catch (FormatException)
            {
                Console.WriteLine("Error: not a valid number.");
            }
            catch (OverflowException)
            {
                Console.WriteLine($"Error: number too big/small ({int.MinValue} to {int.MaxValue}).");
            }
            finally
            {
                Console.WriteLine("Input processed."); // runs always
            }
        } while (!ok);
        return number;
    }

    // 4. menu loop: number = do something, x = quit (like Shop.Start)
    public static void MenuLoopWithX()
    {
        double total = 0;
        while (true)
        {
            // ShowProducts(); // show the list every round
            Console.Write("Enter number (x to finish): ");
            string input = Console.ReadLine() ?? "";

            if (input.ToLower() == "x")
            {
                break;
            }

            if (!int.TryParse(input, out int number))
            {
                Console.WriteLine("Invalid input.");
                continue; // back to start of loop
            }

            // total += Buy(number); // Buy returns the price
        }
        Console.WriteLine($"Total: {total:F2}"); // F2 = 2 decimals
    }

    // ************************************************************
    // DICTIONARY
    // ************************************************************

    // 5. iterate through a dictionary
    public static void ShowDictionary<K, V>(Dictionary<K, V> dict) where K : notnull
    {
        foreach (KeyValuePair<K, V> pair in dict)
        {
            Console.WriteLine($"{pair.Key}: {pair.Value}");
            // for objects with a method: pair.Value.ShowProductLabel();
        }
        // alternative: foreach (var (key, value) in dict) { ... }
    }

    // 6. look something up safely with TryGetValue
    public static bool FindInDictionary<K, V>(Dictionary<K, V> dict, K key, out V? value) where K : notnull
    {
        if (dict.TryGetValue(key, out value))
        {
            return true;
        }
        Console.WriteLine($"'{key}' not found.");
        return false;
    }
    // usage: if (FindInDictionary(dict, 111, out var item)) { item.DoSomething(); }

    // 7. remove from a dictionary (Remove returns true if it existed)
    public static void RemoveFromDictionary<K, V>(Dictionary<K, V> dict, K key) where K : notnull
    {
        if (dict.Remove(key))
        {
            Console.WriteLine($"'{key}' removed.");
        }
        else
        {
            Console.WriteLine($"'{key}' not found.");
        }
    }

    // 8a. check if key exists (like Shop.Buy)
    public static bool ContainsKeyCheck<K, V>(Dictionary<K, V> dict, K key) where K : notnull
    {
        if (!dict.ContainsKey(key))
        {
            Console.WriteLine("Error: key does not exist.");
            return false;
        }
        return true;
    }

    // 8b. dictionary initializer with mixed base/derived objects
    public static Dictionary<int, Vehicle> DictionaryInitExample()
    {
        var dict = new Dictionary<int, Vehicle>
        {
            { 111, new Car("Red", "Toyota", 180, 6.5, 2022) },
            { 112, new ElectricCar("Blue", "Tesla", 200, 75.0, 18.0) }
        };
        dict.Add(113, new Car("Green", "Honda", 160, 5.0, 2020)); // Add throws if key exists
        dict[114] = new Car("Black", "Ford", 170, 7.0, 2019);     // indexer adds or overwrites
        return dict;
    }

    // ************************************************************
    // LIST
    // ************************************************************

    // 9. iterate through a list, print type name
    public static void ShowList<T>(List<T> list)
    {
        foreach (T item in list)
        {
            Console.WriteLine($"{item?.GetType().Name}: {item}");
        }
    }

    // 10. delete all items of a type (loop backwards so indexes stay valid)
    public static void DeleteOfType<T>(List<Vehicle> list) where T : Vehicle
    {
        for (int i = list.Count - 1; i >= 0; i--)
        {
            if (list[i] is T)
            {
                list.RemoveAt(i);
            }
        }
    }
    // ************************************************************
    // EXCEPTIONS
    // ************************************************************

    // 11. try/catch/finally skeleton (specific catches first, general last)
    public static void ExceptionSkeleton()
    {
        try
        {
            int number = int.Parse(Console.ReadLine() ?? "");
            Console.WriteLine(10 / number);
        }
        catch (FormatException)
        {
            Console.WriteLine("Not a number.");
        }
        catch (OverflowException)
        {
            Console.WriteLine("Number too big.");
        }
        catch (DivideByZeroException)
        {
            Console.WriteLine("Cannot divide by 0.");
        }
        catch (Exception ex) // everything else
        {
            Console.WriteLine($"Error: {ex.Message}");
        }
        finally
        {
            Console.WriteLine("Done."); // always runs
        }
    }

    // 12. throwing exceptions
    public static void ThrowExamples(int distance)
    {
        // long form
        if (distance < 0)
        {
            throw new ArgumentOutOfRangeException(nameof(distance), "The distance must not be negative.");
        }

        // short form (same exception, auto message)
        ArgumentOutOfRangeException.ThrowIfNegative(distance);

        // other common ones:
        // throw new InvalidOperationException("Sold out!");
        // throw new ArgumentException("Invalid value.");
        // throw new ArgumentNullException(nameof(distance));
    }

    // 14a. rethrow with "throw;" (keeps the original stack trace)
    public static Car CreateCarRethrow(int maxSpeed)
    {
        try
        {
            return new Car("Red", "Rocket", maxSpeed, 6.0, 2024);
        }
        catch (SpeedLimitExceededException)
        {
            Console.WriteLine("Error logged.");
            throw; // NOT "throw e;" -> that resets the stack trace
        }
    }

    // 14b. wrap the exception (original stays in InnerException)
    public static Car CreateCarWrapped(int maxSpeed)
    {
        try
        {
            return new Car("Red", "Rocket", maxSpeed, 6.0, 2024);
        }
        catch (SpeedLimitExceededException e)
        {
            throw new InvalidOperationException("The car could not be created.", e);
        }
        // reading it: catch (InvalidOperationException ex) { ex.Message; ex.InnerException?.Message; }
    }

    // 14c. exception filter with "when" (filtered catch must come BEFORE the unfiltered one)
    public static void ExceptionFilter(int maxSpeed)
    {
        try
        {
            var car = new Car("Red", "Rocket", maxSpeed, 6.0, 2024);
        }
        catch (SpeedLimitExceededException ex) when (ex.AttemptedSpeed > 400)
        {
            Console.WriteLine("That's not a car, that's an airplane!");
        }
        catch (SpeedLimitExceededException ex)
        {
            Console.WriteLine($"Error: {ex.Message}");
        }
    }

    // ************************************************************
    // TYPE CHECKS
    // ************************************************************

    // 16. is / as / cast / GetType
    public static void TypeChecks(Vehicle vehicle)
    {
        // "is" with pattern (best, cast included)
        if (vehicle is Car car)
        {
            car.ReplaceFuelFilter();
        }
        else if (vehicle is ElectricCar electricCar)
        {
            electricCar.CheckBatteryHealth();
        }

        // "as" gives null if it doesn't fit
        Car? c = vehicle as Car;
        if (c != null)
        {
            Console.WriteLine("It's a Car.");
        }

        // is with extra condition
        if (vehicle is Car red && red.Color == "Red")
        {
            Console.WriteLine("Red car.");
        }

        // hard cast (throws InvalidCastException if wrong)
        // Car hard = (Car)vehicle;

        // type name as string
        Console.WriteLine(vehicle.GetType().Name);

        // interface check
        if (vehicle is IMaintenance maintenance)
        {
            maintenance.ServiceCar();
        }
    }

    // ************************************************************
    // SYNTAX ODDS AND ENDS
    // ************************************************************

    // 17a. params = any number of arguments
    public static void ParamsExample(params string[] items)
    {
        foreach (string item in items)
        {
            Console.WriteLine(item);
        }
    }
    // usage: ParamsExample("a", "b", "c");

    // 17b. out = return an extra value
    public static double OutExample(double fuel, double efficiency, out double maxDistance)
    {
        maxDistance = efficiency > 0 ? fuel / efficiency * 100 : 0; // ternary: cond ? yes : no
        return fuel;
    }
    // usage: double fuel = OutExample(50, 5, out double dist);

    // 17c. optional parameters (must be last), named arguments when calling
    public static void OptionalExample(int distance, int speed = 100, string destination = "Unknown")
    {
        Console.WriteLine($"Trip to {destination}: {distance} km at {speed} km/h");
    }
    // usage: OptionalExample(300, destination: "Munich");

    // 17d. generic method with constraint
    public static int CountOfType<T>(List<Vehicle> list) where T : Vehicle
    {
        int count = 0;
        foreach (Vehicle v in list)
        {
            if (v is T)
            {
                count++;
            }
        }
        return count;
    }
    // usage: int n = CountOfType<ElectricCar>(vehicles);
}

// 13. CUSTOM EXCEPTION

class SpeedLimitExceededException : Exception
{
    public int AttemptedSpeed { get; } // extra data on the exception

    public SpeedLimitExceededException(int attemptedSpeed)
        : base($"The speed of {attemptedSpeed} km/h exceeds the limit of {Vehicle.MaxAllowedSpeed} km/h.")
    {
        AttemptedSpeed = attemptedSpeed;
    }
}

// 15. OOP TEMPLATES

// interface: only says WHAT, no code
interface IMaintenance
{
    void ServiceCar();
}

// abstract base class: cannot be instantiated
abstract class Vehicle
{
    public const int MaxAllowedSpeed = 250; // constant
    private int _maxSpeed;                  // private field behind property

    public string Color = "";               // public field
    public string Model { get; }            // read-only, set in constructor only

    public int MaxSpeed
    {
        get => _maxSpeed;
        set
        {
            if (value > MaxAllowedSpeed)
            {
                throw new SpeedLimitExceededException(value); // validate in setter
            }
            _maxSpeed = value;
        }
    }

    public Vehicle(string color, string model, int maxSpeed)
    {
        Color = color;
        Model = model;
        MaxSpeed = maxSpeed; // goes through the setter
    }

    public virtual void Drive(int distance) // virtual = can be overridden
    {
        ArgumentOutOfRangeException.ThrowIfNegative(distance);
        Console.WriteLine($"{Model} ({Color}) drove {distance} km.");
    }

    public abstract void Refuel(double amount); // abstract = MUST be overridden

    public static bool IsFaster(Vehicle v1, Vehicle v2) // static = called on class
    {
        return v1.MaxSpeed > v2.MaxSpeed;
    }

    public void CheckBrakes()
    {
        Console.WriteLine("Brakes checked.");
    }
}

class Car : Vehicle, IMaintenance // base class first, then interfaces
{
    private static int _carCount;      // static = shared by all cars
    private double _fuelInTank = 50.0;

    public double FuelEfficiency { get; }
    public readonly int ManufacturedYear; // readonly = only set in constructor

    // main constructor: base(...) calls the Vehicle constructor
    public Car(string color, string model, int maxSpeed, double fuelEfficiency, int manufacturedYear)
        : base(color, model, maxSpeed)
    {
        FuelEfficiency = fuelEfficiency;
        ManufacturedYear = manufacturedYear;
        _carCount++;
    }

    // constructor chaining: this(...) calls the main constructor above
    public Car(string color, string model) : this(color, model, 150, 5.0, DateTime.Now.Year) { }
    public Car() : this("Unknown", "Standard", 150, 5.0, DateTime.Now.Year) { }

    public static int GetCarCount()
    {
        return _carCount;
    }

    public override void Drive(int distance) // override + call base first
    {
        base.Drive(distance);
        Console.WriteLine($"Fuel used: {FuelEfficiency * distance / 100} L");
    }

    public void Drive(int distance, int speed) // overload (same name, other parameters)
    {
        Console.WriteLine($"Drove {distance} km at {speed} km/h.");
    }

    public override void Refuel(double amount)
    {
        _fuelInTank += amount;
        Console.WriteLine($"Fuel level: {_fuelInTank} L");
    }

    public void ReplaceFuelFilter()
    {
        Console.WriteLine("Fuel filter replaced.");
    }

    public void ServiceCar() // from IMaintenance
    {
        CheckBrakes();
        ReplaceFuelFilter();
    }
}

class ElectricCar : Vehicle, IMaintenance
{
    public double BatteryCapacity { get; }
    public double EnergyConsumption { get; }
    public double BatteryLevel { get; private set; } // readable outside, settable only inside

    public ElectricCar(string color, string model, int maxSpeed, double batteryCapacity, double energyConsumption)
        : base(color, model, maxSpeed)
    {
        BatteryCapacity = batteryCapacity;
        EnergyConsumption = energyConsumption;
    }

    public override void Drive(int distance)
    {
        base.Drive(distance);
        Console.WriteLine($"Energy used: {EnergyConsumption * distance / 100} kWh");
    }

    public override void Refuel(double amount)
    {
        BatteryLevel += amount;
        Console.WriteLine($"Battery level: {BatteryLevel} kWh");
    }

    public void CheckBatteryHealth()
    {
        Console.WriteLine("Battery health checked.");
    }

    public void ServiceCar()
    {
        CheckBrakes();
        CheckBatteryHealth();
    }
}

class Program
{
    static void Main(string[] args)
    {
        // just for testing, call whatever you want to try:
        // int n = Helpers.AskInt("Number: ");
        // Helpers.ShowDictionary(Helpers.DictionaryInitExample());
    }
}