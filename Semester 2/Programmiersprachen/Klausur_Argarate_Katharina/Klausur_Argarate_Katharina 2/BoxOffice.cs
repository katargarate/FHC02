using System.Xml.Serialization;

public class BoxOffice
{
    private Dictionary<int, Ticket> Tickets { get; } = new()
    {
        { 101, new StandardTicket("Nacho Libre", 9.99m) },
        { 102, new StandardTicket("School of Rock", 12.99m)},
        { 103, new DiscountTicket("Spiderman", 15.00m, 10m)},
        { 104, new DiscountTicket("Dune", 10, 20)}
    };

    public void ShowTickets()
    {
        Console.WriteLine($"\nAll {Tickets.Count()} tickets: ");
        Console.WriteLine("---------------------------------------------------------------------------------");
        
        // loop through all tickets and print them using the PrintTicket() method of the Ticket class
        foreach (KeyValuePair<int, Ticket> kvp in Tickets)
        {
            Console.Write($"* Nr {kvp.Key}: ");   // Write: label on the same line
            kvp.Value.PrintTicket();
        }
    }

    public void BuyTicket(int TicketNumber)
    {

        if (Tickets.TryGetValue(TicketNumber, out Ticket? ticket))
        {
            try
            {
                ticket.Purchase();
                Console.WriteLine($"Final Price: €{ticket.GetFinalPrice():F2}\n");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error purchasing ticket: {ex.Message}");
            }
        }
        else
        {
            Console.WriteLine($"\nTicket number {TicketNumber} does not exist.");
        }
    }

    public void RefundTicket(int TicketNumber)
    {

        if (Tickets.TryGetValue(TicketNumber, out Ticket? ticket))
        {
            if (ticket is IRefundable refundableTicket)
            {
                try
                {
                    decimal refundAmount = refundableTicket.Refund();
                    Console.WriteLine($"Ticket refunded successfully. Refund amount: €{refundAmount:F2}\n");
                }
                catch (Exception ex)
                {
                    Console.WriteLine($"\nError refunding ticket: {ex.Message}");
                }
            }
            else
            {
                Console.WriteLine($"\nTicket number {TicketNumber} is not refundable.");
            }
        }
        else
        {
            Console.WriteLine($"\nTicket number {TicketNumber} does not exist.");
        }
    }
}