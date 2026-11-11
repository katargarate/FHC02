namespace ExamPractice.CinemaModule;

// Kino: seats are an array (true = booked)
class Screening
{
    public string Movie { get; }
    protected decimal TicketPrice { get; }
    private readonly bool[] _seats;

    public Screening(string movie, decimal ticketPrice, int seatCount)
    {
        Movie = movie;
        TicketPrice = ticketPrice;
        _seats = new bool[seatCount];            // all false = free
    }

    public int FreeSeats
    {
        get
        {
            int free = 0;
            foreach (bool booked in _seats)
            {
                if (!booked) free++;
            }
            return free;
        }
    }

    // price of one ticket (derived screenings add a surcharge)
    public virtual decimal PriceFor()
    {
        return TicketPrice;
    }

    public virtual string Describe()
    {
        return $"{Movie} - {PriceFor():F2} EUR - {FreeSeats} of {_seats.Length} seats free";
    }

    public void ShowSeatMap()
    {
        for (int i = 0; i < _seats.Length; i++)
        {
            Console.Write(_seats[i] ? "[XX] " : $"[{i + 1:D2}] ");
            if ((i + 1) % 5 == 0) Console.WriteLine();     // 5 seats per row
        }
        Console.WriteLine();
    }

    private void CheckSeat(int seatNumber)
    {
        if (seatNumber < 1 || seatNumber > _seats.Length)
        {
            throw new ArgumentOutOfRangeException(nameof(seatNumber), $"Seat must be between 1 and {_seats.Length}.");
        }
    }

    // returns the price that has to be paid
    public decimal Book(int seatNumber)
    {
        CheckSeat(seatNumber);
        if (_seats[seatNumber - 1])
        {
            throw new InvalidOperationException($"Seat {seatNumber} is already booked.");
        }
        _seats[seatNumber - 1] = true;
        return PriceFor();
    }

    // returns the refund
    public decimal Cancel(int seatNumber)
    {
        CheckSeat(seatNumber);
        if (!_seats[seatNumber - 1])
        {
            throw new InvalidOperationException($"Seat {seatNumber} is not booked.");
        }
        _seats[seatNumber - 1] = false;
        return PriceFor();
    }
}
