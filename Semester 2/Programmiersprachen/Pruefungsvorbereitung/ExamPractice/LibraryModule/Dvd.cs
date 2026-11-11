namespace ExamPractice.LibraryModule;

// Aufgabe 2 + 6
class Dvd : Medium
{
    private int PlaytimeMinutes { get; }
    private const double Surcharge = 1.50;          // fixed surcharge for DVDs

    public Dvd(string title, double feePerLoan, int copies, int playtimeMinutes)
        : base(title, feePerLoan, copies)
    {
        PlaytimeMinutes = playtimeMinutes;
    }

    public override void ShowMediumLabel()
    {
        base.ShowMediumLabel();
        Console.WriteLine($"   [DVD, {PlaytimeMinutes} min]");
    }

    public override double Borrow()
    {
        return base.Borrow() + Surcharge;           // base reduces copies / throws
    }
}
