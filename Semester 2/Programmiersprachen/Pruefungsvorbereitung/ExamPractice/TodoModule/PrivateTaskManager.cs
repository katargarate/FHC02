namespace ExamPractice.TodoModule;

class PrivateTaskManager : TaskManager
{
    public PrivateTaskManager(List<Task> tasks) : base(tasks)
    {
    }

    protected override string Title => "Private todo list";
}
