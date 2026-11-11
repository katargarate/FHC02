public class DiscountTicket : Ticket
{
    private decimal DiscountPercentage { get; init;}
    public DiscountTicket(string MovieTitle, decimal Price, decimal DiscountPercentage) : base(MovieTitle, Price)
    {
        this.DiscountPercentage = DiscountPercentage;
    }

    public override decimal GetFinalPrice()
    {
        // calculate price with discount, return discounted price
        return (Price - (Price * DiscountPercentage / 100));
    }

}