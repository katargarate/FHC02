namespace ExamPractice.LibraryModule;

// Aufgabe 3, 4, 5, 6
class Library
{
    private Dictionary<int, Medium> Catalog { get; } = new()
    {
        { 201, new Medium("Clean Code", 2.00, 2) },
        { 202, new Dvd("Inception", 3.00, 1, 148) },
        { 203, new Medium("Design Patterns", 2.50, 0) },
        { 204, new Dvd("The Matrix", 3.00, 3, 136) }
    };

    private void ShowMedia()
    {
        foreach (KeyValuePair<int, Medium> kvp in Catalog)
        {
            Console.Write($"*** Nr {kvp.Key}: ");
            kvp.Value.ShowMediumLabel();
        }
    }

    private double Lend(int mediaNumber)
    {
        if (!Catalog.TryGetValue(mediaNumber, out Medium? medium))
        {
            Console.WriteLine("Unknown media number.");
            return 0;
        }

        try
        {
            return medium.Borrow();
        }
        catch (NoCopiesAvailableException ex)
        {
            Console.WriteLine($"Sorry, '{ex.Title}' is currently not available.");
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
        double total = 0;
        while (true)
        {
            ShowMedia();
            Console.Write("Media number (x = finish): ");
            string? input = Console.ReadLine();

            if (input == "x")
            {
                break;
            }

            if (int.TryParse(input, out int number))
            {
                total += Lend(number);
            }
            else
            {
                Console.WriteLine("Invalid input.");
            }
        }
        Console.WriteLine($"Total fees: {total:F2} EUR");
    }
}
