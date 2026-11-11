namespace ExamPractice.CinemaModule;

class ImaxScreening : Screening
{
    private const decimal Surcharge = 3.50m;

    public ImaxScreening(string movie, decimal ticketPrice, int seatCount)
        : base(movie, ticketPrice, seatCount)
    {
    }

    public override decimal PriceFor()
    {
        return base.PriceFor() + Surcharge;
    }

    public override string Describe()
    {
        return base.Describe() + " [IMAX]";
    }
}
