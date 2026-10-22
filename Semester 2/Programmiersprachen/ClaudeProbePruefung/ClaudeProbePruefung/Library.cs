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
            Console.Write(kvp.Key);
            kvp.Value.ShowMediumLabel();
        }
    }

    private void Lend(int mediumNumber) 
    {
        if (!Catalogue.TryGetValue(mediumNumber, out Medium? medium))
        {
            Console.WriteLine($"No medium could be found with the number {mediumNumber}.");
        } else
        {
            try
            {
                medium.Borrow();
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
    }

    private void Start()
    {
        Boolean exit = false;
        ShowMedia();
        do
        {
            Console.Write("Enter a number to borrow an item: ");
            string? input  = Console.ReadLine();
            if (input == null || input.Trim().ToLower() == "exit")
        }
    }
}
