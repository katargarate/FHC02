namespace ExamPractice.EmployeesModule;

class Manager : Employee, IBonusEligible       // base class first, then interfaces
{
    private decimal Bonus { get; set; }

    public Manager(string name, decimal baseSalary, decimal bonus)
        : base(name, baseSalary)
    {
        Bonus = bonus;
    }

    public override decimal CalculateSalary()
    {
        return base.CalculateSalary() + Bonus;
    }

    public void GiveBonus(decimal amount)       // interface member: public, no override
    {
        if (amount <= 0)
        {
            throw new ArgumentOutOfRangeException(nameof(amount), "The bonus must be positive.");
        }
        Bonus += amount;
    }

    public override string Describe()
    {
        return base.Describe() + " [manager]";
    }
}
