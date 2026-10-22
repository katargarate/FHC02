namespace Module5.Task5;

class SpeedLimitExceededException : Exception
{
    public int AttemptedSpeed { get; }

    public SpeedLimitExceededException(int attemptedSpeed)
        : base($"The speed of {attemptedSpeed} km/h exceeds the limit of {Vehicle.MaxAllowedSpeed} km/h.")
    {
        AttemptedSpeed = attemptedSpeed;
    }
}
