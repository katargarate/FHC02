namespace ExamPractice.TodoModule;

class WorkTaskManager : TaskManager
{
    public WorkTaskManager(List<Task> tasks) : base(tasks)
    {
    }

    protected override string Title => "Work todo list";
}
