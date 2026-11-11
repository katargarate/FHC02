namespace ExamPractice.ShopModule;

// Probepruefung Aufgabe 1 + 6
class Product
{
    // "nur innerhalb der Klasse oder abgeleiteter Klassen sichtbar", im Konstruktor gesetzt
    protected string Name { get; }
    protected double Price { get; }
    // Stock changes inside AddToCart -> private set (a plain { get; } would not compile)
    protected int Stock { get; private set; }

    public Product(string name, double price, int stock)
    {
        Name = name;
        Price = price;
        Stock = stock;
    }

    public virtual void ShowProductLabel()
    {
        Console.WriteLine($"{Name} - {Price:F2} EUR - {Stock} in stock");
    }

    // Task 1: void. Task 6: returns the price of the product
    public virtual double AddToCart()
    {
        if (Stock <= 0)
        {
            throw new InvalidOperationException($"{Name} is sold out.");
        }
        Stock--;
        return Price;
    }
}
