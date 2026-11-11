namespace ExamPractice.BankModule;

// money = decimal (not double)
class Account
{
    public int Number { get; }
    public string Owner { get; }
    public decimal Balance { get; protected set; }   // derived accounts may change it, outside only reads

    public Account(int number, string owner, decimal balance)
    {
        Number = number;
        Owner = owner;
        Balance = balance;
    }

    // how much may be withdrawn at most (checking account overrides this)
    protected virtual decimal Available => Balance;

    public virtual void Deposit(decimal amount)
    {
        if (amount <= 0)
        {
            throw new ArgumentOutOfRangeException(nameof(amount), "The amount must be positive.");
        }
        Balance += amount;
    }

    public virtual void Withdraw(decimal amount)
    {
        if (amount <= 0)
        {
            throw new ArgumentOutOfRangeException(nameof(amount), "The amount must be positive.");
        }
        if (amount > Available)
        {
            throw new InsufficientFundsException(amount - Available);
        }
        Balance -= amount;
    }

    public virtual string Describe()
    {
        return $"#{Number} {Owner}: {Balance:F2} EUR";
    }
}
