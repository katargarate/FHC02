namespace ExamPractice.TodoModule;

// Todo exam, Task 1
class Task
{
    // "nach der Initialisierung nicht mehr veraenderbar" -> init
    public string Description { get; init; }
    public bool Finished { get; set; }

    public Task(string description)
    {
        Description = description;
    }
}
