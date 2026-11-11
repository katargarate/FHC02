using System;

namespace ClaudeProbePruefung;

public class Library
{
    private Dictionary<int, Medium> Catalogue {get;} = new()
    {
        {201, new Medium("Lord of the Rings", 2.5m, 3)},
        {202, new Medium("The Devil Wears Prada", 2.5m, 1)},
        {203, new Dvd("Nacho Libre", 3.5m, 2, 120)},
        {204, new Dvd("The Incredibles", 3.5m, 0, 90)}
    };

    private void ShowMedia()
    {
        foreach(KeyValuePair<int, Medium> kvp in Catalogue)
        {
            Console.Write(kvp.Key + ": ");
            kvp.Value.ShowMediumLabel();
            Console.WriteLine();
        }
    }

    private decimal Lend(int mediumNumber) 
    {
        if (!Catalogue.TryGetValue(mediumNumber, out Medium? medium))
        {
            Console.WriteLine($"No medium could be found with the number {mediumNumber}.");
            return 0;
        } else
        {
            try
            {
                decimal fee = medium.Borrow();
                Console.WriteLine($"The medium has been lent. Fee: €{fee:c}");
                return fee;
            }
            catch (NoCopiesAvailableException ex)
            {
                Console.WriteLine($"The medium \"{ex.Title}\" cannot be lent because no copies are available.");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"An error occurred while lending medium {mediumNumber}: {ex.Message}");
            }
        }

        return 0;
    }

    public void Start()
    {
        Boolean exit = false;
        decimal totalFees = 0;

        Console.WriteLine("\nAll Media:");
        ShowMedia();

        do {
            Console.WriteLine("\nEnter a medium number to borrow it, or 'x' to exit.");
            Console.Write("\nInput: ");
            
            try
            {
                string? input = Console.ReadLine();

                if (input == "x")
                {
                    Console.WriteLine("Exiting the library system. Goodbye!");
                    exit = true;
                } else if (int.TryParse(input, out int mediumNumber))
                {
                    totalFees += Lend(mediumNumber);
                } else
                {
                    Console.WriteLine("Please enter a valid mediumnumber to borrow it, or 'x' to exit.");
                }
            } catch (Exception ex)
            {
                Console.WriteLine($"An error occurred: {ex.Message}");
            }

        } while (!exit);

        if (totalFees > 0) {
            Console.WriteLine($"\nTotal fees for borrowed media: {totalFees:c}");
        } else {
            Console.WriteLine("\nNo media was borrowed, so no fees were incurred.");
        }
    }
}
