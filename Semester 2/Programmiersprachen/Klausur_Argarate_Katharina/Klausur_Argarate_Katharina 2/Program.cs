public class Program
{
    public static void Main()
    {
        BoxOffice BoxOffice = new BoxOffice();
        do
        {
            BoxOffice.ShowTickets();
            
            // show options
            Console.WriteLine("""
            
            Options:
            b. Purchase a ticket
            r. Refund a ticket
            x. Exit Program

            Enter 'b', 'r', or 'x' to continue.
            """);
            Console.Write("Your choice: ");

            string? input = Console.ReadLine();

            if (input == "x")
            {
                Console.WriteLine("\nExiting program...\n");
                break;
            }
            else if (input == "b")
            {
                Console.Write("\nEnter the ticket number you want to purchase.\n");
                int ticketNumber = ReadTicketNumber();
                BoxOffice.BuyTicket(ticketNumber);
            }
            else if (input == "r")
            {
                Console.Write("\nEnter the ticket number you want to refund.\n");
                int ticketNumber = ReadTicketNumber();
                BoxOffice.RefundTicket(ticketNumber);
            }
            else
            {
                Console.WriteLine("\nInvalid choice. Please try again with 'b', 'r', or 'x'");
            }

        } while (true);
    }

    public static int ReadTicketNumber()
    {
        // loop runs until user enters a number (no exit possibility like with entering "x")
        while (true)
        {
            Console.Write("Ticket number: ");
            string? input = Console.ReadLine();

            if (int.TryParse(input, out int number))
            {
                // why after returning the number 
                return number;
            }
            else
            {
                Console.WriteLine("Invalid input. Try again with an integer.");
            }
        }
        
    }
}
