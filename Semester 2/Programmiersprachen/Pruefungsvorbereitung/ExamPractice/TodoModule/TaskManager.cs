namespace ExamPractice.TodoModule;

// Todo exam, Task 2-6
abstract class TaskManager
{
    // "nur innerhalb der Klasse oder deren abgeleiteter Klassen sichtbar"
    protected readonly List<Task> _tasks;

    public TaskManager(List<Task> tasks)
    {
        _tasks = tasks;
    }

    // derived managers change the heading (virtual / override)
    protected virtual string Title => "Todo list";

    // Task 6: menu loop
    public void HandleTodoList()
    {
        bool goBack = false;
        while (!goBack)
        {
            Console.WriteLine($"--- {Title} ---");
            PrintTasks();

            Console.WriteLine("Choose an option:");
            Console.WriteLine("a) Finish an item");
            Console.WriteLine("b) Add an item");
            Console.WriteLine("x) Go back to main selection");

            string? choice = Console.ReadLine();
            Console.WriteLine();

            if (choice == "a")
            {
                AskUserToFinishTask();
            }
            else if (choice == "b")
            {
                AskUserToAddTask();
            }
            else if (choice == "x")
            {
                goBack = true;
            }
            else
            {
                Console.WriteLine("Invalid choice. Please try again.");
            }
        }
    }

    // Task 3: numbered list, 1-based
    private void PrintTasks()
    {
        if (_tasks.Count == 0)
        {
            Console.WriteLine("(no tasks)");
        }

        for (int i = 0; i < _tasks.Count; i++)
        {
            Console.Write($"{i + 1}. {_tasks[i].Description}");
            Console.WriteLine(_tasks[i].Finished ? " [FINISHED]" : " [NOT FINISHED]");
        }
    }

    // Task 4: invalid index -> exception
    private void FinishTask(int index)
    {
        if (index < 0 || index >= _tasks.Count)
        {
            throw new ArgumentOutOfRangeException(nameof(index), "The index is invalid");
        }

        if (_tasks[index].Finished)
        {
            Console.WriteLine("The task is already finished");
        }
        else
        {
            _tasks[index].Finished = true;
            Console.WriteLine("Congratulations on finishing your task!");
        }
    }

    // Task 5: TryParse + try/catch, repeat until a task was finished
    private void AskUserToFinishTask()
    {
        bool hasValidInput = false;

        while (!hasValidInput)
        {
            Console.WriteLine("Enter the index of the task to finish:");
            if (int.TryParse(Console.ReadLine(), out int taskIndex))
            {
                try
                {
                    FinishTask(taskIndex - 1);   // user sees 1-based, list is 0-based
                    hasValidInput = true;
                }
                catch (ArgumentOutOfRangeException e)
                {
                    Console.WriteLine(e.Message);
                }
            }
            else
            {
                Console.WriteLine("Invalid input. Please enter a number.");
            }
        }
    }

    // Extra practice: add a task, empty text -> exception
    private void AddTask(string description)
    {
        if (string.IsNullOrWhiteSpace(description))
        {
            throw new ArgumentException("The description must not be empty.");
        }
        _tasks.Add(new Task(description.Trim()));
    }

    private void AskUserToAddTask()
    {
        Console.WriteLine("Enter the description of the new task:");
        try
        {
            AddTask(Console.ReadLine() ?? "");
            Console.WriteLine("Task added.");
        }
        catch (ArgumentException e)
        {
            Console.WriteLine(e.Message);
        }
    }
}
