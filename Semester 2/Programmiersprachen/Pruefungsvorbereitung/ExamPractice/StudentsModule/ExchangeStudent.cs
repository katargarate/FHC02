namespace ExamPractice.StudentsModule;

class ExchangeStudent : Student
{
    private string HomeCountry { get; }

    public ExchangeStudent(int matriculationNumber, string name, string homeCountry)
        : base(matriculationNumber, name)
    {
        HomeCountry = homeCountry;
    }

    public override string Describe()
    {
        return base.Describe() + $" [exchange student from {HomeCountry}]";
    }
}
