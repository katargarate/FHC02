namespace ExamPractice.WarehouseModule;

class PerishableArticle : Article
{
    private DateTime ExpiryDate { get; }

    public PerishableArticle(string code, string name, int quantity, DateTime expiryDate)
        : base(code, name, quantity)
    {
        ExpiryDate = expiryDate;
    }

    public bool IsExpired => ExpiryDate.Date < DateTime.Today;

    // expired goods cannot be taken out of the warehouse (only thrown away)
    public override void RemoveStock(int amount)
    {
        if (IsExpired)
        {
            throw new InvalidOperationException($"{Name} is expired and must not be sold.");
        }
        base.RemoveStock(amount);
    }

    public override string Describe()
    {
        return base.Describe() + $" [best before {ExpiryDate:dd.MM.yyyy}{(IsExpired ? ", EXPIRED" : "")}]";
    }
}
