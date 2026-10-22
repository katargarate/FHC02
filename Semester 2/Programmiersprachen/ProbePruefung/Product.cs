namespace ProbePruefung;
public class Product
{
    protected string Name { get; set; }
    protected decimal Price { get; set; }
    protected int Stock { get; set; }

    public Product(string Name, decimal Price, int Stock)
    {
        this.Name = Name;
        this.Price = Price;
        this.Stock = Stock;
    }

    public virtual void ShowProductLabel()
    {
        Console.WriteLine($"Product: {Name}, Price: {Price:C}, Stock: {Stock}");
    }

    public virtual decimal AddToCart()
    {
        if (Stock > 0)
        {
            Console.WriteLine($"Added {Name} to cart. There are now {Stock - 1} items left in stock.");
            Stock--;
        } else
        {
            throw new InvalidOperationException($"Cannot add {Name} to cart. The product is out of stock.");
        }

        return Price;
    }
}
