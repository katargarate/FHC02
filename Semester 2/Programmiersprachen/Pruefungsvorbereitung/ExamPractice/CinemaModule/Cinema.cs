namespace ExamPractice.CinemaModule;

class Cinema
{
    private Dictionary<int, Screening> Screenings { get; } = new()
    {
        { 1, new Screening("Dune", 9.00m, 10) },
        { 2, new ImaxScreening("Interstellar", 9.00m, 10) },
        { 3, new Screening("Amelie", 7.50m, 5) }
    };

    private decimal _revenue;      // money taken in (bookings - refunds)

    private void ShowScreenings()
    {
        foreach (KeyValuePair<int, Screening> kvp in Screenings)
        {
            Console.WriteLine($"{kvp.Key}) {kvp.Value.Describe()}");
        }
    }

    private int AskForInt(string prompt)
    {
        while (true)
        {
            Console.WriteLine(prompt);
            if (int.TryParse(Console.ReadLine(), out int value))
            {
                return value;
            }
            Console.WriteLine("Invalid input. Please enter a number.");
        }
    }

    // menu for ONE screening
    private void HandleScreening(Screening screening)
    {
        bool goBack = false;
        while (!goBack)
        {
            Console.WriteLine($"--- {screening.Movie} ---");
            screening.ShowSeatMap();
            Console.WriteLine("Choose an option:");
            Console.WriteLine("a) Book a seat");
            Console.WriteLine("b) Cancel a booking");
            Console.WriteLine("x) Go back");

            string? choice = Console.ReadLine();
            Console.WriteLine();

            if (choice == "a" || choice == "b")
            {
                int seat = AskForInt("Seat number:");
                try
                {
                    if (choice == "a")
                    {
                        _revenue += screening.Book(seat);
                        Console.WriteLine("Seat booked.");
                    }
                    else
                    {
                        _revenue -= screening.Cancel(seat);
                        Console.WriteLine("Booking cancelled, ticket refunded.");
                    }
                }
                catch (ArgumentOutOfRangeException e)      // wrong seat number
                {
                    Console.WriteLine(e.Message);
                }
                catch (InvalidOperationException e)        // already booked / not booked
                {
                    Console.WriteLine(e.Message);
                }
            }
            else if (choice == "x") goBack = true;
            else Console.WriteLine("Invalid choice. Please try again.");
        }
    }

    public void Start()
    {
        while (true)
        {
            ShowScreenings();
            Console.WriteLine($"Revenue: {_revenue:F2} EUR");
            Console.Write("Screening number (x = exit): ");
            string? input = Console.ReadLine();

            if (input == "x")
            {
                break;
            }

            if (int.TryParse(input, out int number) && Screenings.TryGetValue(number, out Screening? screening))
            {
                HandleScreening(screening);
            }
            else
            {
                Console.WriteLine("Invalid screening number.");
            }
        }
    }
}
