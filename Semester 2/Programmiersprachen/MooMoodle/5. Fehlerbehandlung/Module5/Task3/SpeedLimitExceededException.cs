namespace Module5.Task3;

class SpeedLimitExceededException : Exception
{
    public int AttemptedSpeed { get; }

    public SpeedLimitExceededException(int attemptedSpeed)
        : base($"The speed of {attemptedSpeed} km/h exceeds the limit of {Vehicle.MaxAllowedSpeed} km/h.")
    {
        AttemptedSpeed = attemptedSpeed;
    }

    public SpeedLimitExceededException(int attemptedSpeed, string message) : base(message)
    {
        AttemptedSpeed = attemptedSpeed;
    }
}
