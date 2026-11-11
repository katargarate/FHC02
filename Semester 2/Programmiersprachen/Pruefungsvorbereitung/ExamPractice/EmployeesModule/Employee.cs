namespace ExamPractice.EmployeesModule;

class Employee
{
    public string Name { get; }
    protected decimal BaseSalary { get; private set; }

    public Employee(string name, decimal baseSalary)
    {
        Name = name;
        BaseSalary = baseSalary;
    }

    // monthly salary (derived classes override)
    public virtual decimal CalculateSalary()
    {
        return BaseSalary;
    }

    public void Raise(decimal percent)
    {
        if (percent <= 0 || percent > 100)
        {
            throw new ArgumentOutOfRangeException(nameof(percent), "The raise must be between 0 and 100 percent.");
        }
        BaseSalary += BaseSalary * percent / 100;
    }

    public virtual string Describe()
    {
        return $"{Name} - {CalculateSalary():F2} EUR";
    }
}
