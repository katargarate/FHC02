
using System;
using System.Collections.Generic;
using System.Diagnostics.CodeAnalysis;

namespace ExamHelpers;

// =====================================================================
//  1. USER INPUT  (always loop until the input is valid)
// =====================================================================
static class Input
{
    // Whole number. Asks again until valid. No crash on letters/empty/null.
    public static int ReadInt(string prompt)
    {
        while (true)
        {
            Console.Write(prompt);
            if (int.TryParse(Console.ReadLine(), out int value))
                return value;
            Console.WriteLine("Invalid input, please enter a whole number.");
        }
    }

    // Whole number between min and max (both allowed).
    public static int ReadIntInRange(string prompt, int min, int max)
    {
        while (true)
        {
            int value = ReadInt(prompt);
            if (value >= min && value <= max)
                return value;
            Console.WriteLine($"Please enter a number between {min} and {max}.");
        }
    }

    // Decimal number (uses the PC's culture: German = comma, e.g. 3,5).
    public static double ReadDouble(string prompt)
    {
        while (true)
        {
            Console.Write(prompt);
            if (double.TryParse(Console.ReadLine(), out double value))
                return value;
            Console.WriteLine("Invalid input, please enter a number.");
        }
    }

    // Text that is not empty / not only spaces.
    public static string ReadNonEmptyString(string prompt)
    {
        while (true)
        {
            Console.Write(prompt);
            string? input = Console.ReadLine();
            if (!string.IsNullOrWhiteSpace(input))
                return input.Trim();
            Console.WriteLine("Input must not be empty.");
        }
    }

    // y/n question -> true/false
    public static bool ReadYesNo(string prompt)
    {
        while (true)
        {
            Console.Write(prompt + " (y/n): ");
            string? input = Console.ReadLine()?.Trim().ToLower();
            if (input == "y" || input == "yes" || input == "j" || input == "ja") return true;
            if (input == "n" || input == "no" || input == "nein") return false;
            Console.WriteLine("Please answer y or n.");
        }
    }

    // "Enter a number, or x to finish" loops.
    // Returns false if the user typed the quit word, otherwise true + the number.
    //   while (Input.ReadIntOrQuit("Number (x = finish): ", out int n)) { ... }
    public static bool ReadIntOrQuit(string prompt, out int value, string quitWord = "x")
    {
        while (true)
        {
            Console.Write(prompt);
            string? input = Console.ReadLine();
            if (input != null && input.Trim().ToLower() == quitWord)
            {
                value = 0;
                return false;
            }
            if (int.TryParse(input, out value))
                return true;
            Console.WriteLine("Invalid input.");
        }
    }

    // Enum value from text:  Level l = Input.ReadEnum<Level>("Level: ");
    public static TEnum ReadEnum<TEnum>(string prompt) where TEnum : struct, Enum
    {
        while (true)
        {
            Console.Write(prompt);
            string? input = Console.ReadLine();
            // TryParse also accepts numbers like "42" -> IsDefined checks it really exists
            if (Enum.TryParse(input, true, out TEnum result) && Enum.IsDefined(typeof(TEnum), result))
                return result;
            Console.WriteLine($"Please enter one of: {string.Join(", ", Enum.GetNames(typeof(TEnum)))}");
        }
    }
}

// =====================================================================
//  2. DICTIONARY  (replace TKey / TValue with your types if you prefer)
// =====================================================================
static class DictHelpers
{
    // Look up safely. true = found (value is not null), false = prints message.
    //   if (DictHelpers.TryFind(items, 111, out Item? item, "Unknown number.")) item.Show();
    public static bool TryFind<TKey, TValue>(
        Dictionary<TKey, TValue> dict, TKey key,
        [NotNullWhen(true)] out TValue? value, string? notFoundMessage = null)
        where TKey : notnull
    {
        if (dict.TryGetValue(key, out value) && value is not null)
            return true;
        if (notFoundMessage != null)
            Console.WriteLine(notFoundMessage);
        return false;
    }

    // Add, but refuse duplicates (dict.Add throws ArgumentException on a duplicate key).
    public static bool AddSafe<TKey, TValue>(Dictionary<TKey, TValue> dict, TKey key, TValue value)
        where TKey : notnull
    {
        if (dict.ContainsKey(key))
        {
            Console.WriteLine($"Key {key} already exists.");
            return false;
        }
        dict.Add(key, value);
        return true;
    }

    // Add OR overwrite (never throws):  dict[key] = value;

    // Remove with feedback (dict.Remove returns false if the key did not exist).
    public static bool RemoveSafe<TKey, TValue>(Dictionary<TKey, TValue> dict, TKey key)
        where TKey : notnull
    {
        if (dict.Remove(key))
            return true;
        Console.WriteLine($"Key {key} not found.");
        return false;
    }

    // Search by a PROPERTY of the value (not by key).
    //   Vehicle? v = DictHelpers.FindValue(vehicles, x => x.Model == "Tesla");
    public static TValue? FindValue<TKey, TValue>(Dictionary<TKey, TValue> dict, Predicate<TValue> match)
        where TKey : notnull
    {
        foreach (TValue value in dict.Values)
        {
            if (match(value))
                return value;
        }
        return default;
    }

    // Same, but returns the KEY of the first match (found = false if none).
    public static bool TryFindKey<TKey, TValue>(
        Dictionary<TKey, TValue> dict, Predicate<TValue> match, [MaybeNullWhen(false)] out TKey key)
        where TKey : notnull
    {
        foreach (KeyValuePair<TKey, TValue> kvp in dict)
        {
            if (match(kvp.Value))
            {
                key = kvp.Key;
                return true;
            }
        }
        key = default;
        return false;
    }

    // Print everything.  (foreach over a dictionary gives KeyValuePair, NOT the value!)
    public static void PrintAll<TKey, TValue>(Dictionary<TKey, TValue> dict) where TKey : notnull
    {
        foreach (KeyValuePair<TKey, TValue> kvp in dict)
            Console.WriteLine($"{kvp.Key}: {kvp.Value}");
    }
}

// =====================================================================
//  3. LIST
// =====================================================================
static class ListHelpers
{
    // Remove all matching items. Loops BACKWARDS so indices stay valid.
    // (foreach + Remove would throw InvalidOperationException.)
    //   int removed = ListHelpers.RemoveWhere(numbers, n => n > 10);
    public static int RemoveWhere<T>(List<T> list, Predicate<T> match)
    {
        int removed = 0;
        for (int i = list.Count - 1; i >= 0; i--)
        {
            if (match(list[i]))
            {
                list.RemoveAt(i);
                removed++;
            }
        }
        return removed;
    }

    // Remove all items of one subclass:  ListHelpers.RemoveOfType<Vehicle, ElectricCar>(vehicles);
    public static int RemoveOfType<TBase, TRemove>(List<TBase> list) where TRemove : TBase
    {
        int removed = 0;
        for (int i = list.Count - 1; i >= 0; i--)
        {
            if (list[i] is TRemove)
            {
                list.RemoveAt(i);
                removed++;
            }
        }
        return removed;
    }

    // How many items are of one subclass.
    public static int CountOfType<TBase, TCount>(List<TBase> list) where TCount : TBase
    {
        int count = 0;
        foreach (TBase item in list)
        {
            if (item is TCount)
                count++;
        }
        return count;
    }

    // Sum of one number property:  double total = ListHelpers.SumOf(items, i => i.Price);
    public static double SumOf<T>(List<T> list, Func<T, double> selector)
    {
        double sum = 0;
        foreach (T item in list)
            sum += selector(item);
        return sum;
    }

    // Print all (uses each item's ToString()).
    public static void PrintAll<T>(List<T> list)
    {
        for (int i = 0; i < list.Count; i++)
            Console.WriteLine($"{i + 1}. {list[i]}");
    }

    // Built-in, no helper needed:
    //   list.Add(x);  list.Remove(x);  list.RemoveAt(i);  list.Contains(x);  list.IndexOf(x);
    //   list.Find(x => x.Model == "Tesla");   // first match or null/default
    //   list.Count    list[0]    list.Clear()
}

// =====================================================================
//  4. EXCEPTIONS
// =====================================================================

// ---- own exception class (template) ----
class MyCustomException : Exception
{
    public int Value { get; }                         // extra data (optional)

    public MyCustomException(int value)
        : base($"Invalid value: {value}")             // message goes to the base class
    {
        Value = value;
    }
}

static class ExceptionHelpers
{
    // Run code, print the message if anything is thrown. true = success.
    //   ExceptionHelpers.TryRun(() => car.Drive(-5));
    public static bool TryRun(Action action)
    {
        try
        {
            action();
            return true;
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error: {ex.Message}");
            return false;
        }
    }

    // Same, but for code that returns a value (fallback is returned on error).
    //   int n = ExceptionHelpers.TryRun(() => int.Parse(text), -1);
    public static T TryRun<T>(Func<T> func, T fallback)
    {
        try
        {
            return func();
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error: {ex.Message}");
            return fallback;
        }
    }

    // ---- the patterns from Modul 5 (copy the part you need) ----
    public static void Patterns()
    {
        // several catch blocks: MOST SPECIFIC FIRST, Exception last (else error CS0160)
        try
        {
            int number = int.Parse("abc");
        }
        catch (FormatException)   { Console.WriteLine("Not a number."); }
        catch (OverflowException) { Console.WriteLine("Number too big or too small."); }
        catch (Exception ex)      { Console.WriteLine(ex.Message); }
        finally                   { Console.WriteLine("Always runs."); }

        // throw yourself
        // if (age < 0) throw new ArgumentOutOfRangeException(nameof(age), "Age must not be negative.");
        // ArgumentOutOfRangeException.ThrowIfNegative(age);
        // ArgumentNullException.ThrowIfNull(obj);

        // rethrow (keeps the stack trace):   catch (MyCustomException) { Log(); throw; }
        // NOT:                               catch (MyCustomException e) { throw e; }   // resets stack trace
        // wrap:                              catch (Exception e) { throw new InvalidOperationException("Context", e); }
        // filter:                            catch (MyCustomException ex) when (ex.Value > 100) { ... }
    }
}

// =====================================================================
//  5. CLASS TEMPLATES
// =====================================================================

// ---- 5a. properties / const / readonly / static ----
class PropertyTemplates
{
    public string Auto { get; set; } = "";             // read + write everywhere
    public string ReadOnly { get; } = "fixed";         // only constructor / initializer can set
    public int PrivateSet { get; private set; }        // class can change, outside only reads
    public string InitOnly { get; init; } = "";        // constructor or new X { InitOnly = ... }

    private int _speed;                                // backing field (private, _camelCase)
    public int Speed                                   // property with validation
    {
        get { return _speed; }
        set
        {
            if (value < 0)
                throw new ArgumentOutOfRangeException(nameof(value), "Speed must not be negative.");
            _speed = value;                            // NOT "Speed = value" (endless recursion!)
        }
    }

    public int Doubled => _speed * 2;                  // computed, read-only

    public const int Max = 250;                        // PropertyTemplates.Max
    public readonly int Id;                            // instance.Id, set only in constructor
    private static int _count;                         // one per class
    public static int Count => _count;                 // PropertyTemplates.Count

    public PropertyTemplates(int id)
    {
        Id = id;
        Speed = 10;                                    // goes through the setter (validation!)
        _count++;
    }
}

// ---- 5b. constructor chaining ----
class Person
{
    public string Name { get; }
    public int Age { get; }

    public Person(string name, int age)                // "main" constructor does the work
    {
        Name = name;
        Age = age;
    }

    public Person(string name) : this(name, 18) { }    // chained: default age
    public Person() : this("Unknown") { }              // chained to the chained one
}

class Student : Person
{
    public string School { get; }

    public Student(string name, int age, string school)
        : base(name, age)                              // parent constructor runs FIRST
    {
        School = school;
    }

    public Student(string name, string school)
        : this(name, 20, school) { }                   // this(...) OR base(...), never both
}

// ---- 5c. inheritance + virtual/override (same as the Probepruefung) ----
class Item
{
    protected string Name { get; }
    protected double Price { get; }
    protected int Stock { get; private set; }          // changes inside the class -> private set

    public Item(string name, double price, int stock)
    {
        Name = name;
        Price = price;
        Stock = stock;
    }

    public virtual void Show()                         // virtual: child may override
        => Console.WriteLine($"{Name} - {Price:F2} - {Stock} in stock");

    public virtual double Take()                       // returns the price
    {
        if (Stock <= 0)
            throw new InvalidOperationException($"{Name} is out of stock.");
        Stock--;
        return Price;
    }
}

class SaleItem : Item
{
    private double DiscountPercent { get; }

    public SaleItem(string name, double price, int stock, double discountPercent)
        : base(name, price, stock)
    {
        DiscountPercent = discountPercent;
    }

    public override void Show()                        // same signature as the parent
    {
        base.Show();                                   // call the parent version
        Console.WriteLine($"   SALE -{DiscountPercent}%");
    }

    public override double Take()                      // same return type as the parent!
    {
        double fullPrice = base.Take();                // reduces stock, throws if empty
        return fullPrice * (1 - DiscountPercent / 100);
    }
}

// ---- 5d. abstract class + interface ----
abstract class Shape
{
    public abstract double Area();                     // no body
    public virtual string Describe() => $"Shape with area {Area():F2}";
}

class Circle : Shape
{
    public double Radius { get; }
    public Circle(double radius) { Radius = radius; }
    public override double Area() => Math.PI * Radius * Radius;   // abstract -> override REQUIRED
}

interface IPrintable                                   // I-prefix, members are public implicitly
{
    void Print();
}

class Report : IPrintable
{
    public void Print() => Console.WriteLine("Report");          // `public` REQUIRED, no override
}

// ---- 5e. enum ----
enum Level { Low, Medium, High }                       // 0, 1, 2

// =====================================================================
//  6. METHOD TEMPLATES
// =====================================================================
static class MethodTemplates
{
    public static void AddOne(ref int x) { x++; }      // call: AddOne(ref a);

    public static double Divide(int a, int b, out bool ok)   // out: MUST be assigned
    {
        ok = b != 0;
        return ok ? (double)a / b : 0;                 // (double) cast: avoid integer division
    }                                                  // call: Divide(5, 2, out bool ok);

    public static int Sum(params int[] numbers)        // Sum(1, 2, 3)  or  Sum()
    {
        int total = 0;
        foreach (int n in numbers) total += n;
        return total;
    }

    public static void Greet(string name, string greeting = "Hello")   // optional parameter
    {
        Console.WriteLine($"{greeting} {name}");       // Greet("Anna");  Greet("Anna", greeting: "Hi");
    }

    // Type checks (pattern matching)
    public static void Describe(object o)
    {
        if (o is Circle c)                  Console.WriteLine($"Circle r={c.Radius}");
        else if (o is IPrintable p)         p.Print();
        else if (o is int i && i > 10)      Console.WriteLine("big int");
        else                                Console.WriteLine(o.GetType().Name);
        // Car? car = o as Car;  if (car != null) { ... }
    }
}

// =====================================================================
//  7. MANAGER CLASS: dictionary + menu loop + try/catch
// =====================================================================
class Catalog
{
    private Dictionary<int, Item> Items { get; } = new()
    {
        { 1, new Item("Pen", 1.5, 10) },
        { 2, new SaleItem("Book", 20.0, 3, 25) },
        { 3, new Item("Lamp", 35.0, 0) }
    };

    public void ShowAll()
    {
        foreach (KeyValuePair<int, Item> kvp in Items)
        {
            Console.Write($"Nr {kvp.Key}: ");          // Write = same line as the label
            kvp.Value.Show();                          // polymorphic call
        }
    }

    private double Take(int number)
    {
        if (!DictHelpers.TryFind(Items, number, out Item? item, "Unknown number."))
            return 0;

        try
        {
            return item.Take();
        }
        catch (InvalidOperationException ex)           // specific first
        {
            Console.WriteLine(ex.Message);
            return 0;
        }
        catch (Exception ex)                           // everything else
        {
            Console.WriteLine($"Error: {ex.Message}");
            return 0;
        }
    }

    public void Start()
    {
        double total = 0;
        while (true)
        {
            ShowAll();
            if (!Input.ReadIntOrQuit("Number (x = finish): ", out int number))
                break;
            total += Take(number);
        }
        Console.WriteLine($"Total: {total:F2}");
    }
}

// =====================================================================
//  DEMO (delete this class if your project already has Main)
// // =====================================================================
// static class Program
// {
//     static void Main()
//     {
//         // non-interactive demo
//         Catalog catalog = new Catalog();
//         catalog.ShowAll();

//         var numbers = new List<int> { 5, 12, 7, 20 };
//         int removed = ListHelpers.RemoveWhere(numbers, n => n > 10);
//         Console.WriteLine($"Removed {removed}, left: {numbers.Count}");

//         ExceptionHelpers.TryRun(() => throw new MyCustomException(5));

//         Student s = new Student("Anna", "FH");
//         Console.WriteLine($"{s.Name}, {s.Age}, {s.School}");

//         // interactive (uncomment to try):
//         // int age = Input.ReadIntInRange("Age (1-120): ", 1, 120);
//         // catalog.Start();
//     }
// }
