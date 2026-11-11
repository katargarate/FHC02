namespace ExamPractice.BankModule;

// Girokonto: may go below zero up to the overdraft limit
class CheckingAccount : Account
{
    private decimal OverdraftLimit { get; }

    public CheckingAccount(int number, string owner, decimal balance, decimal overdraftLimit)
        : base(number, owner, balance)
    {
        OverdraftLimit = overdraftLimit;
    }

    protected override decimal Available => Balance + OverdraftLimit;

    public override string Describe()
    {
        return base.Describe() + $" [checking, overdraft {OverdraftLimit:F2} EUR]";
    }
}
