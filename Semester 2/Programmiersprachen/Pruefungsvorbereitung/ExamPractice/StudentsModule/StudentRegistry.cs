namespace ExamPractice.StudentsModule;

// Studentenverwaltung: Dictionary<Matrikelnummer, Student>
class StudentRegistry
{
    private Dictionary<int, Student> Students { get; } = new()
    {
        { 1001, new Student(1001, "Anna Mueller") },
        { 1002, new Student(1002, "Bernd Huber") },
        { 1003, new ExchangeStudent(1003, "Chloe Martin", "France") }
    };

    private void ShowAll()
    {
        foreach (KeyValuePair<int, Student> kvp in Students)
        {
            Console.WriteLine(kvp.Value.Describe());   // polymorphic call
        }
    }

    private void Enroll(Student student)
    {
        if (Students.ContainsKey(student.MatriculationNumber))
        {
            throw new ArgumentException($"Matriculation number {student.MatriculationNumber} already exists.");
        }
        Students.Add(student.MatriculationNumber, student);
    }

    private void GiveGrade(int matriculationNumber, int grade)
    {
        if (!Students.TryGetValue(matriculationNumber, out Student? student))
        {
            throw new KeyNotFoundException($"No student with number {matriculationNumber}.");
        }
        student.AddGrade(grade);   // throws ArgumentOutOfRangeException for an invalid grade
    }

    private Student? FindBest()
    {
        Student? best = null;
        foreach (Student student in Students.Values)
        {
            if (student.GradeCount == 0)
            {
                continue;
            }
            if (best == null || student.Average < best.Average)   // lower is better
            {
                best = student;
            }
        }
        return best;
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

    private void AskToEnroll()
    {
        int number = AskForInt("Matriculation number:");
        Console.WriteLine("Name:");
        string name = (Console.ReadLine() ?? "").Trim();
        if (name == "")
        {
            Console.WriteLine("The name must not be empty.");
            return;
        }

        Console.WriteLine("Exchange student? (y/n)");
        Student student;
        if (Console.ReadLine() == "y")
        {
            Console.WriteLine("Home country:");
            student = new ExchangeStudent(number, name, (Console.ReadLine() ?? "").Trim());
        }
        else
        {
            student = new Student(number, name);
        }

        try
        {
            Enroll(student);
            Console.WriteLine("Student enrolled.");
        }
        catch (ArgumentException e)
        {
            Console.WriteLine(e.Message);
        }
    }

    private void AskToGiveGrade()
    {
        int number = AskForInt("Matriculation number:");
        int grade = AskForInt("Grade (1-5):");
        try
        {
            GiveGrade(number, grade);
            Console.WriteLine("Grade saved.");
        }
        catch (KeyNotFoundException e)
        {
            Console.WriteLine(e.Message);
        }
        catch (ArgumentOutOfRangeException e)
        {
            Console.WriteLine(e.Message);
        }
    }

    private void AskToRemove()
    {
        int number = AskForInt("Matriculation number:");
        Console.WriteLine(Students.Remove(number) ? "Student removed." : "No student with this number.");
    }

    private void AskToSearch()
    {
        Console.WriteLine("Enter (part of) the name:");
        string part = Console.ReadLine() ?? "";
        bool found = false;
        foreach (Student student in Students.Values)
        {
            if (student.NameContains(part))
            {
                Console.WriteLine(student.Describe());
                found = true;
            }
        }
        if (!found)
        {
            Console.WriteLine("Nothing found.");
        }
    }

    public void Start()
    {
        bool exit = false;
        while (!exit)
        {
            Console.WriteLine("--- Students ---");
            ShowAll();
            Console.WriteLine("Choose an option:");
            Console.WriteLine("a) Enroll a student");
            Console.WriteLine("b) Add a grade");
            Console.WriteLine("c) Remove a student");
            Console.WriteLine("d) Search by name");
            Console.WriteLine("e) Show the best student");
            Console.WriteLine("x) Exit");

            string? choice = Console.ReadLine();
            Console.WriteLine();

            if (choice == "a") AskToEnroll();
            else if (choice == "b") AskToGiveGrade();
            else if (choice == "c") AskToRemove();
            else if (choice == "d") AskToSearch();
            else if (choice == "e")
            {
                Student? best = FindBest();
                Console.WriteLine(best == null ? "No grades yet." : "Best: " + best.Describe());
            }
            else if (choice == "x") exit = true;
            else Console.WriteLine("Invalid choice. Please try again.");
        }
    }
}
