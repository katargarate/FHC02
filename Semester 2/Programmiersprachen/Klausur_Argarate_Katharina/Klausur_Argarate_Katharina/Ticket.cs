public abstract class Ticket
{
    public string MovieTitle { get; init; }
    protected decimal Price { get; init; }
    public bool IsSold { get; protected set; }

    public Ticket (string MovieTitle, decimal Price)
    {
        this.MovieTitle = MovieTitle;
        this.Price = Price;
        IsSold = false;
    }

    public abstract decimal GetFinalPrice();

    public void Purchase()
    {
        if (IsSold)
        {
            Console.WriteLine("\nTicket has already been sold.");
        }
        else
        {
            IsSold = true;
            Console.WriteLine("\nTicket purchased successfully.");
        }
    }

    public void PrintTicket()
    {
        Console.Write($"Movie Title: {MovieTitle}, Final Price: €{GetFinalPrice():F2}");

        // add availability status at the end of the line
        if (IsSold)
        {
            Console.WriteLine(" -- Ticket IS NOT available");
        }
        else
        {
            Console.WriteLine(" -- Ticket IS available.");
        }
    }

    


}