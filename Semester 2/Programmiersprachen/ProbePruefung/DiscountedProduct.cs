using System;

namespace ProbePruefung;

public class DiscountedProduct : Product
{
    private decimal DiscountPercentage { get; set; }

    public DiscountedProduct(string Name, decimal Price, int Stock, decimal DiscountPercentage) :base(Name, Price, Stock)
    {
        
        this.DiscountPercentage = DiscountPercentage;
    }

    public override void ShowProductLabel()
    {
        Console.WriteLine($"Product: {Name}, Original Price: {Price:C}, Stock: {Stock}, Discount -{DiscountPercentage}%");
    }

    public override decimal AddToCart()
    {
        decimal basePrice = base.AddToCart();
        return basePrice - (basePrice * DiscountPercentage / 100);
    }
}
