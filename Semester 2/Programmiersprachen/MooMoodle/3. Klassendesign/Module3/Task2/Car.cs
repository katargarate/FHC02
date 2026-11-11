namespace Module3.Task2;

class Car
{
    private int _maxSpeed;

    public string Color;
    public string Model { get; }

    public int MaxSpeed
    {
        get => _maxSpeed;
        // set
        // {
        //     if (value > 300)
        //     {
        //         _maxSpeed = 300;
        //     }
        //     else
        //     {
        //         _maxSpeed = value;
        //     }
        // }

        set => _maxSpeed = value > 300 ? 300 : value;


    }

    public Car(string color, string model, int maxSpeed)
    {
        Color = color;
        Model = model;
        MaxSpeed = maxSpeed;
    }
}
