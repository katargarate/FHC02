using System;

namespace ClaudeProbePruefung;

public class Medium
{
    protected string Title {get;}
    protected decimal FeePerLoan {get;}
    protected int Copies {get; private set;} 

    public Medium(string title, decimal feePerLoan, int copies)
    {
        this.Title = title;
        this.FeePerLoan = feePerLoan;
        this.Copies = copies;
    }

    public virtual void ShowMediumLabel()
    {
        Console.Write($"Title: {Title}, Loan Fee: €{FeePerLoan:c}, Available copies: {Copies}");
    }

    public virtual decimal Borrow()
    {
        if (Copies > 0) {
            Copies--;
            Console.WriteLine($"There are now {Copies} remaining.");
            return FeePerLoan;
        }
        else
        {
            throw new NoCopiesAvailableException(Title);
        }
    }

}
