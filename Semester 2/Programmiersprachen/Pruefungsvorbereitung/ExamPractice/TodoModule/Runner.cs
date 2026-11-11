namespace ExamPractice.TodoModule;

// main selection of the Todo exam
static class Runner
{
    public static void Run()
    {
        WorkTaskManager workTasks = new WorkTaskManager(new List<Task>()
        {
            new Task("Finish the report"),
            new Task("Write the documentation"),
            new Task("Send feedback"),
            new Task("Fix bug"),
            new Task("Book hours")
        });

        PrivateTaskManager privateTasks = new PrivateTaskManager(new List<Task>()
        {
            new Task("Wash the dishes"),
            new Task("Clean the windows"),
            new Task("Write a letter"),
            new Task("Read a book"),
            new Task("Go for a walk")
        });

        bool exit = false;
        while (!exit)
        {
            Console.WriteLine("Choose an option: ");
            Console.WriteLine("a) See private todo list");
            Console.WriteLine("b) See work todo list");
            Console.WriteLine("x) Exit");

            string? choice = Console.ReadLine();
            Console.WriteLine();

            if (choice == "a")
            {
                privateTasks.HandleTodoList();
            }
            else if (choice == "b")
            {
                workTasks.HandleTodoList();
            }
            else if (choice == "x")
            {
                exit = true;
            }
            else
            {
                Console.WriteLine("Invalid choice. Please try again.");
            }
        }
    }
}
