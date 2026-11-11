namespace ExamPractice.WarehouseModule;

// Lager / Inventar
class Article
{
    public string Code { get; }
    protected string Name { get; }
    public int Quantity { get; private set; }

    public Article(string code, string name, int quantity)
    {
        Code = code;
        Name = name;
        Quantity = quantity;
    }

    public void AddStock(int amount)
    {
        if (amount <= 0)
        {
            throw new ArgumentOutOfRangeException(nameof(amount), "The amount must be positive.");
        }
        Quantity += amount;
    }

    public virtual void RemoveStock(int amount)
    {
        if (amount <= 0)
        {
            throw new ArgumentOutOfRangeException(nameof(amount), "The amount must be positive.");
        }
        if (amount > Quantity)
        {
            throw new InvalidOperationException($"Only {Quantity} x {Name} in stock, cannot remove {amount}.");
        }
        Quantity -= amount;
    }

    public bool NameContains(string part)
    {
        return Name.Contains(part, StringComparison.OrdinalIgnoreCase);
    }

    public virtual string Describe()
    {
        return $"{Code}: {Name} x {Quantity}";
    }
}
