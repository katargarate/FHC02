namespace ExamPractice.ShopModule;

// Probepruefung Aufgabe 3, 4, 5, 6
class Shop
{
    // Aufgabe 3: Dictionary, nicht ausserhalb der Klasse sichtbar
    private Dictionary<int, Product> Inventory { get; } = new()
    {
        { 111, new Product("Laptop", 999.0, 3) },
        { 112, new DiscountedProduct("Phone", 499.0, 2, 10) },
        { 113, new Product("Mouse", 25.0, 0) },
        { 114, new DiscountedProduct("Monitor", 199.0, 5, 20) }
    };

    private void ShowProducts()
    {
        foreach (KeyValuePair<int, Product> kvp in Inventory)
        {
            Console.Write($"*** Nr {kvp.Key}: ");   // Write: label on the same line
            kvp.Value.ShowProductLabel();
        }
    }

    // Aufgabe 4 + 6
    private double Buy(int productNumber)
    {
        if (!Inventory.TryGetValue(productNumber, out Product? product))
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

    // Aufgabe 5
    public void Start()
    {
        double total = 0;
        while (true)
        {
            ShowProducts();
            Console.Write("Product number (x = finish): ");
            string? input = Console.ReadLine();

            if (input == "x")
            {
                break;
            }

            if (int.TryParse(input, out int number))
            {
                total += Buy(number);
            }
            else
            {
                Console.WriteLine("Invalid input.");
            }
        }
        Console.WriteLine($"Total: {total:F2} EUR");
    }
}
