namespace ExamPractice.BankModule;

class Bank
{
    private Dictionary<int, Account> Accounts { get; } = new()
    {
        { 1, new Account(1, "Anna", 100m) },
        { 2, new SavingsAccount(2, "Bernd", 1000m, 2m) },
        { 3, new CheckingAccount(3, "Carla", 50m, 200m) }
    };

    private void ShowAll()
    {
        foreach (Account account in Accounts.Values)
        {
            Console.WriteLine(account.Describe());
        }
    }

    // find an account or throw
    private Account GetAccount(int number)
    {
        if (!Accounts.TryGetValue(number, out Account? account))
        {
            throw new KeyNotFoundException($"No account with number {number}.");
        }
        return account;
    }

    private void Transfer(int fromNumber, int toNumber, decimal amount)
    {
        Account from = GetAccount(fromNumber);
        Account to = GetAccount(toNumber);
        from.Withdraw(amount);      // if this throws, nothing was deposited
        to.Deposit(amount);
    }

    // ---------- input helpers ----------

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

    private decimal AskForAmount()
    {
        while (true)
        {
            Console.WriteLine("Amount:");
            if (decimal.TryParse(Console.ReadLine(), out decimal value))
            {
                return value;
            }
            Console.WriteLine("Invalid input. Please enter a number.");
        }
    }

    // run an action, show the message of every exception
    private void Try(Action action)
    {
        try
        {
            action();
            Console.WriteLine("Done.");
        }
        catch (InsufficientFundsException e)
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
            Console.WriteLine("--- Bank ---");
            ShowAll();
            Console.WriteLine("Choose an option:");
            Console.WriteLine("a) Deposit");
            Console.WriteLine("b) Withdraw");
            Console.WriteLine("c) Transfer");
            Console.WriteLine("d) Add interest (savings accounts)");
            Console.WriteLine("x) Exit");

            string? choice = Console.ReadLine();
            Console.WriteLine();

            if (choice == "a")
            {
                int number = AskForInt("Account number:");
                decimal amount = AskForAmount();
                Try(() => GetAccount(number).Deposit(amount));
            }
            else if (choice == "b")
            {
                int number = AskForInt("Account number:");
                decimal amount = AskForAmount();
                Try(() => GetAccount(number).Withdraw(amount));
            }
            else if (choice == "c")
            {
                int from = AskForInt("From account number:");
                int to = AskForInt("To account number:");
                decimal amount = AskForAmount();
                Try(() => Transfer(from, to, amount));
            }
            else if (choice == "d")
            {
                int number = AskForInt("Account number:");
                Try(() =>
                {
                    if (GetAccount(number) is SavingsAccount savings)     // pattern matching
                    {
                        savings.AddInterest();
                    }
                    else
                    {
                        throw new InvalidOperationException("Only savings accounts earn interest.");
                    }
                });
            }
            else if (choice == "x") exit = true;
            else Console.WriteLine("Invalid choice. Please try again.");
        }
    }
}
