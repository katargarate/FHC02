using System;

namespace ClaudeProbePruefung;

public class Dvd : Medium
{
    private int PlayTimeMinutes {get; init;}
    public Dvd(string title, decimal feePerLoan, int copies, int playtimeMinutes) :base(title, feePerLoan, copies)
    {
        this.PlayTimeMinutes = playtimeMinutes;   
    }

    public override void ShowMediumLabel()
    {
        base.ShowMediumLabel();
        Console.Write($"Play time: {PlayTimeMinutes} min");
    }

}
