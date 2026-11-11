namespace ExamPractice.BankModule;

class SavingsAccount : Account
{
    private const decimal MaxWithdrawal = 500m;     // limit per withdrawal
    private const decimal Fee = 1m;                 // fee per withdrawal
    private decimal InterestPercent { get; }

    public SavingsAccount(int number, string owner, decimal balance, decimal interestPercent)
        : base(number, owner, balance)
    {
        InterestPercent = interestPercent;
    }

    public override void Withdraw(decimal amount)
    {
        if (amount > MaxWithdrawal)
        {
            throw new InvalidOperationException($"A savings account allows max. {MaxWithdrawal:F2} EUR per withdrawal.");
        }
        base.Withdraw(amount + Fee);                // fee is checked + charged together with the amount
    }

    public void AddInterest()
    {
        Balance += Balance * InterestPercent / 100;
    }

    public override string Describe()
    {
        return base.Describe() + $" [savings, {InterestPercent}% interest]";
    }
}
