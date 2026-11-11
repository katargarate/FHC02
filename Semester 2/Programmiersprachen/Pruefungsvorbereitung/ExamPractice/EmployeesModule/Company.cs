namespace ExamPractice.EmployeesModule;

// Mitarbeiterverwaltung: List<Employee>, accessed by (1-based) index like the Todo exam
class Company
{
    private readonly List<Employee> _employees = new List<Employee>()
    {
        new Employee("Anna", 3000m),
        new Manager("Bernd", 4500m, 1000m),
        new Intern("Chris", 1800m)
    };

    private void ShowAll()
    {
        for (int i = 0; i < _employees.Count; i++)
        {
            Console.WriteLine($"{i + 1}. {_employees[i].Describe()}");
        }
        Console.WriteLine($"Total monthly cost: {TotalSalaryCost():F2} EUR");
    }

    private decimal TotalSalaryCost()
    {
        decimal total = 0;
        foreach (Employee employee in _employees)
        {
            total += employee.CalculateSalary();   // polymorphic
        }
        return total;
    }

    // invalid index -> exception (same idea as FinishTask in the Todo exam)
    private Employee GetEmployee(int index)
    {
        if (index < 0 || index >= _employees.Count)
        {
            throw new ArgumentOutOfRangeException(nameof(index), "There is no employee with this number.");
        }
        return _employees[index];
    }

    private void GiveBonus(int index, decimal amount)
    {
        Employee employee = GetEmployee(index);
        if (employee is IBonusEligible eligible)
        {
            eligible.GiveBonus(amount);
        }
        else
        {
            throw new InvalidOperationException($"{employee.Name} is not eligible for a bonus.");
        }
    }

    // ---------- input helpers ----------

    private int AskForIndex()
    {
        while (true)
        {
            Console.WriteLine("Employee number:");
            if (int.TryParse(Console.ReadLine(), out int number))
            {
                return number - 1;      // user sees 1-based, list is 0-based
            }
            Console.WriteLine("Invalid input. Please enter a number.");
        }
    }

    private decimal AskForDecimal(string prompt)
    {
        while (true)
        {
            Console.WriteLine(prompt);
            if (decimal.TryParse(Console.ReadLine(), out decimal value))
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
        catch (Exception e)
        {
            Console.WriteLine(e.Message);
        }
    }

    public void Start()
    {
        bool exit = false;
        while (!exit)
        {
            Console.WriteLine("--- Company ---");
            ShowAll();
            Console.WriteLine("Choose an option:");
            Console.WriteLine("a) Hire an employee");
            Console.WriteLine("b) Raise a salary");
            Console.WriteLine("c) Give a bonus");
            Console.WriteLine("d) Fire an employee");
            Console.WriteLine("x) Exit");

            string? choice = Console.ReadLine();
            Console.WriteLine();

            if (choice == "a")
            {
                Console.WriteLine("Name:");
                string name = (Console.ReadLine() ?? "").Trim();
                decimal salary = AskForDecimal("Base salary:");
                Console.WriteLine("Type (e = employee, m = manager, i = intern):");
                string? type = Console.ReadLine();
                Try(() =>
                {
                    if (name == "") throw new ArgumentException("The name must not be empty.");
                    if (salary <= 0) throw new ArgumentOutOfRangeException(nameof(salary), "The salary must be positive.");
                    if (type == "m") _employees.Add(new Manager(name, salary, 0m));
                    else if (type == "i") _employees.Add(new Intern(name, salary));
                    else _employees.Add(new Employee(name, salary));
                });
            }
            else if (choice == "b")
            {
                int index = AskForIndex();
                decimal percent = AskForDecimal("Raise in percent:");
                Try(() => GetEmployee(index).Raise(percent));
            }
            else if (choice == "c")
            {
                int index = AskForIndex();
                decimal amount = AskForDecimal("Bonus amount:");
                Try(() => GiveBonus(index, amount));
            }
            else if (choice == "d")
            {
                int index = AskForIndex();
                Try(() =>
                {
                    GetEmployee(index);          // validates the index
                    _employees.RemoveAt(index);
                });
            }
            else if (choice == "x") exit = true;
            else Console.WriteLine("Invalid choice. Please try again.");
        }
    }
}
