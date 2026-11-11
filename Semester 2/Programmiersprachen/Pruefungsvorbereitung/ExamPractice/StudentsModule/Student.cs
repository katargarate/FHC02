namespace ExamPractice.StudentsModule;

class Student
{
    public int MatriculationNumber { get; }              // set in constructor only
    protected string Name { get; }                       // class + derived classes
    private readonly List<int> _grades = new List<int>();

    public Student(int matriculationNumber, string name)
    {
        MatriculationNumber = matriculationNumber;
        Name = name;
    }

    // Austrian grades: 1 (best) to 5 (worst)
    public void AddGrade(int grade)
    {
        if (grade < 1 || grade > 5)
        {
            throw new ArgumentOutOfRangeException(nameof(grade), "A grade must be between 1 and 5.");
        }
        _grades.Add(grade);
    }

    public int GradeCount => _grades.Count;

    // computed read-only property (no setter, no field)
    public double Average
    {
        get
        {
            if (_grades.Count == 0)
            {
                return 0;
            }
            double sum = 0;
            foreach (int grade in _grades)
            {
                sum += grade;
            }
            return sum / _grades.Count;
        }
    }

    public bool NameContains(string part)
    {
        return Name.Contains(part, StringComparison.OrdinalIgnoreCase);
    }

    public virtual string Describe()
    {
        string average = _grades.Count == 0 ? "no grades yet" : $"average {Average:F2}";
        return $"{MatriculationNumber} | {Name} | {average} ({_grades.Count} grades)";
    }
}
