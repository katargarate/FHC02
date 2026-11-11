namespace ExamPractice.WarehouseModule;

class Warehouse
{
    // key = article code (string), keys compared without case
    private Dictionary<string, Article> Articles { get; } = new(StringComparer.OrdinalIgnoreCase)
    {
        { "A100", new Article("A100", "Screws", 500) },
        { "A200", new Article("A200", "Hammer", 4) },
        { "F100", new PerishableArticle("F100", "Milk", 30, DateTime.Today.AddDays(5)) },
        { "F200", new PerishableArticle("F200", "Yoghurt", 12, DateTime.Today.AddDays(-2)) }
    };

    private void ShowAll()
    {
        foreach (KeyValuePair<string, Article> kvp in Articles)
        {
            Console.WriteLine(kvp.Value.Describe());
        }
    }

    private Article GetArticle(string code)
    {
        if (!Articles.TryGetValue(code, out Article? article))
        {
            throw new KeyNotFoundException($"No article with code '{code}'.");
        }
        return article;
    }

    // report: everything below a threshold
    private void ShowLowStock(int threshold)
    {
        bool any = false;
        foreach (Article article in Articles.Values)
        {
            if (article.Quantity < threshold)
            {
                Console.WriteLine(article.Describe());
                any = true;
            }
        }
        if (!any)
        {
            Console.WriteLine("Nothing below the threshold.");
        }
    }

    // ---------- input helpers ----------

    private string AskForCode()
    {
        Console.WriteLine("Article code:");
        return (Console.ReadLine() ?? "").Trim();
    }

    private int AskForInt(string prompt)
    {
        while (true)
        {
            Console.WriteLine(prompt);
            if (int.TryParse(Console.ReadLine(), out int value))
            {
                return value;
            }
            Console.WriteLine("Invalid input. Please enter a number.");
        }
    }

    private void Try(Action action)
    {
        try
        {
            action();
            Console.WriteLine("Done.");
        }
        catch (KeyNotFoundException e)
        {
            Console.WriteLine(e.Message);
        }
        catch (InvalidOperationException e)
        {
            Console.WriteLine(e.Message);
        }
        catch (Exception e)
        {
            Console.WriteLine($"Error: {e.Message}");
        }
    }

    public void Start()
    {
        bool exit = false;
        while (!exit)
        {
            Console.WriteLine("--- Warehouse ---");
            ShowAll();
            Console.WriteLine("Choose an option:");
            Console.WriteLine("a) Add stock");
            Console.WriteLine("b) Remove stock");
            Console.WriteLine("c) Search by name");
            Console.WriteLine("d) Low stock report");
            Console.WriteLine("x) Exit");

            string? choice = Console.ReadLine();
            Console.WriteLine();

            if (choice == "a")
            {
                string code = AskForCode();
                int amount = AskForInt("Amount:");
                Try(() => GetArticle(code).AddStock(amount));
            }
            else if (choice == "b")
            {
                string code = AskForCode();
                int amount = AskForInt("Amount:");
                Try(() => GetArticle(code).RemoveStock(amount));
            }
            else if (choice == "c")
            {
                Console.WriteLine("Enter (part of) the name:");
                string part = Console.ReadLine() ?? "";
                foreach (Article article in Articles.Values)
                {
                    if (article.NameContains(part)) Console.WriteLine(article.Describe());
                }
            }
            else if (choice == "d")
            {
                ShowLowStock(AskForInt("Threshold:"));
            }
            else if (choice == "x") exit = true;
            else Console.WriteLine("Invalid choice. Please try again.");
        }
    }
}
