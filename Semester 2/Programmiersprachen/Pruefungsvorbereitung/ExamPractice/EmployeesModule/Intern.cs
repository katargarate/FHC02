namespace ExamPractice.EmployeesModule;

class Intern : Employee
{
    public Intern(string name, decimal baseSalary) : base(name, baseSalary)
    {
    }

    public override decimal CalculateSalary()
    {
        return base.CalculateSalary() * 0.5m;   // interns get half
    }

    public override string Describe()
    {
        return base.Describe() + " [intern]";
    }
}
