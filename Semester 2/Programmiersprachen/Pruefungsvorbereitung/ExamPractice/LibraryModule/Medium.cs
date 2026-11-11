namespace ExamPractice.LibraryModule;

// Uebungspruefung Bibliothek, Aufgabe 1 + 6
class Medium
{
    protected string Title { get; }
    protected double FeePerLoan { get; }
    protected int Copies { get; private set; }     // changes in Borrow -> private set

    public Medium(string title, double feePerLoan, int copies)
    {
        Title = title;
        FeePerLoan = feePerLoan;
        Copies = copies;
    }

    public virtual void ShowMediumLabel()
    {
        Console.WriteLine($"{Title} - {FeePerLoan:F2} EUR per loan - {Copies} copies available");
    }

    // returns the fee of the loan
    public virtual double Borrow()
    {
        if (Copies <= 0)
        {
            throw new NoCopiesAvailableException(Title);
        }
        Copies--;
        return FeePerLoan;
    }
}
