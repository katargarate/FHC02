using System;

namespace ClaudeProbePruefung;

public class Dvd : Medium
{
    private int PlayTimeMinutes {get; init;}
    private MediaType Type {get; init;} = MediaType.Dvd;

    public Dvd(string title, decimal feePerLoan, int copies, int playtimeMinutes) :base(title, feePerLoan, copies)
    {
        this.PlayTimeMinutes = playtimeMinutes;   
    }

    public override void ShowMediumLabel()
    {
        base.ShowMediumLabel();
        Console.Write($" Play time: {PlayTimeMinutes} min\n");
    }

    public override decimal Borrow()
    {
        decimal fee = base.Borrow() + 1.5m; // Add €1.50 surcharge for DVDs
        return fee;
    }

}
