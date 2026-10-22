using System;

namespace ProbePruefung;

public class Shop
{
    private Dictionary<int, Product> Inventory { get; } = new()
    {
        { 111, new Product("Laptop", 999.99m, 3) },
        { 112, new DiscountedProduct("Phone", 499.99m, 2, 10) },
        { 113, new Product("Mouse", 25.35m, 0) },
        { 114, new DiscountedProduct("Monitor", 199.0m, 5, 20) }
    };

    private void ShowProducts()
    {
        foreach (KeyValuePair<int, Product> kvp in Inventory)
        {
            Console.Write($"Nr. {kvp.Key}: ");
            kvp.Value.ShowProductLabel();
        }
    }

    private decimal Buy(int ProductNumber)
    {
        if (!Inventory.TryGetValue(ProductNumber, out Product? product))
        {
            Console.WriteLine("Unknown product number.");
            return 0;
        }
        try
        {
            return product.AddToCart();
        }
        catch (InvalidOperationException ex)
        {
            Console.WriteLine(ex.Message);
            return 0;
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error: {ex.Message}");
            return 0;
        }

    }

    public void Start()
    {
        ShowProducts();
        decimal totalSpent = 0;
        Boolean exit = false;

        do
        {
            Console.Write("\nEnter a product number to purchase it: ");
            string? input = Console.ReadLine();

            if (input == "x")
            {
                exit = true;
            }
            else if (int.TryParse(input, out int productNumber))
            {
                totalSpent += Buy(productNumber);
            }
            else
            {
                Console.WriteLine("Please enter a valid product number to select it, or 'x' to exit.");
            }

        } while (!exit);

        System.Console.WriteLine($"You spent €{totalSpent}.");

    }

}
