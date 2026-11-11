namespace ExamPractice;

// One program that starts every practice module.
// Each module lives in its own folder + namespace (XyzModule) and has a Runner class with Run().
static class Program
{
    static void Main()
    {
        bool exit = false;
        while (!exit)
        {
            Console.WriteLine();
            Console.WriteLine("=== C# exam practice projects ===");
            Console.WriteLine("1) Shop            (Probepruefung: Product, DiscountedProduct, Dictionary)");
            Console.WriteLine("2) Todo            (List by index, abstract TaskManager, menu a/b/x)");
            Console.WriteLine("3) Contacts        (Dictionary<phone, Contact>, search/update/remove)");
            Console.WriteLine("4) Students        (Dictionary<Matrikelnummer, Student>, ExchangeStudent)");
            Console.WriteLine("5) Library         (Medium/Dvd, own exception, fees)");
            Console.WriteLine("6) Bank            (Account/Savings/Checking, withdraw throws)");
            Console.WriteLine("7) Employees       (List by index, Manager/Intern, interface)");
            Console.WriteLine("8) Cinema          (seat array, book/cancel, IMAX)");
            Console.WriteLine("9) Warehouse       (Dictionary<string, Article>, perishable goods)");
            Console.Write("Choose a module (x = exit): ");

            string? choice = Console.ReadLine();
            Console.WriteLine();

            switch (choice?.Trim().ToLower())
            {
                case "1": ShopModule.Runner.Run(); break;
                case "2": TodoModule.Runner.Run(); break;
                case "3": ContactsModule.Runner.Run(); break;
                case "4": StudentsModule.Runner.Run(); break;
                case "5": LibraryModule.Runner.Run(); break;
                case "6": BankModule.Runner.Run(); break;
                case "7": EmployeesModule.Runner.Run(); break;
                case "8": CinemaModule.Runner.Run(); break;
                case "9": WarehouseModule.Runner.Run(); break;
                case "x": exit = true; break;
                default: Console.WriteLine("Invalid choice. Please try again."); break;
            }
        }
    }
}
