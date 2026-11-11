namespace ExamPractice.ContactsModule;

static class Runner
{
    public static void Run()
    {
        PrivateContactManager privateContacts = new PrivateContactManager(new Dictionary<int, Contact>()
        {
            { 111111, new Contact("Anna Mueller", "anna@mail.at") },
            { 222222, new Contact("Bernd Huber") }
        });

        WorkingContactManager workContacts = new WorkingContactManager(new Dictionary<int, Contact>()
        {
            { 333333, new Contact("Carla Boss", "carla@firma.at") }
        });

        bool exit = false;
        while (!exit)
        {
            Console.WriteLine("Choose an option: ");
            Console.WriteLine("a) Private contacts");
            Console.WriteLine("b) Work contacts");
            Console.WriteLine("x) Exit");

            string? choice = Console.ReadLine();
            Console.WriteLine();

            if (choice == "a") privateContacts.HandleContacts();
            else if (choice == "b") workContacts.HandleContacts();
            else if (choice == "x") exit = true;
            else Console.WriteLine("Invalid choice. Please try again.");
        }
    }
}
