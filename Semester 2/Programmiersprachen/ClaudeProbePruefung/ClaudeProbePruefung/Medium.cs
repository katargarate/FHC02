using System;

namespace ClaudeProbePruefung;

public class Medium
{
    protected string Title {get; private set;}
    protected decimal FeePerLoan {get; private set;}
    protected int Copies {get; private set;} 

    public Medium(string title, decimal feePerLoan, int copies)
    {
        this.Title = title;
        this.FeePerLoan = feePerLoan;
        this.Copies = copies;
    }

    public virtual void ShowMediumLabel()
    {
        Console.WriteLine($"Title: {Title}, Loan Fee: €{FeePerLoan:c}, Available copies: {Copies}");
    }

    public void Borrow()
    {
        if (Copies > 0) {
            Copies--;
            Console.WriteLine($"There are now {Copies} remaining.");
        }
        else
        {
            throw new NoCopiesAvailableException(Title);
        }
    }

}
