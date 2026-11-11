namespace ExamPractice.ShopModule;

// Probepruefung Aufgabe 2 + 6
class DiscountedProduct : Product
{
    // nur innerhalb der Klasse sichtbar
    private double DiscountPercentage { get; }

    public DiscountedProduct(string name, double price, int stock, double discountPercentage)
        : base(name, price, stock)
    {
        DiscountPercentage = discountPercentage;
    }

    public override void ShowProductLabel()
    {
        base.ShowProductLabel();
        Console.WriteLine($"**DISCOUNT -{DiscountPercentage}%**");
    }

    // same signature AND return type as in Product
    public override double AddToCart()
    {
        double fullPrice = base.AddToCart();   // reduces stock, throws if sold out
        return fullPrice * (1 - DiscountPercentage / 100);
    }
}
