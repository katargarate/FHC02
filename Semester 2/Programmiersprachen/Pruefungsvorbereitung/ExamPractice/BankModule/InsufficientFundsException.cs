namespace ExamPractice.BankModule;

class InsufficientFundsException : Exception
{
    public decimal Missing { get; }

    public InsufficientFundsException(decimal missing)
        : base($"Insufficient funds: {missing:F2} EUR missing.")
    {
        Missing = missing;
    }
}
