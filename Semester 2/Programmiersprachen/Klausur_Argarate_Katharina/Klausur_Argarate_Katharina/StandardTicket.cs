public class StandardTicket : Ticket, IRefundable
{
    public StandardTicket(string MovieTitle, decimal Price) : base(MovieTitle, Price)
    {
    }

    public override decimal GetFinalPrice()
    {
        // return regular price
        return Price;
    }

    public decimal Refund()
    {
        if (!IsSold)
        {
            throw new Exception("Ticket has not been sold yet, cannot refund.");
        }
        // if ticket has been sold, mark it as not sold and return the original price
        IsSold = false;
        return GetFinalPrice(); // just the regular price anyway, because theres no discount
    }
}