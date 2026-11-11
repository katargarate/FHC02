namespace Module7.Task2;

enum VehicleType
{
    // First member = default value (0), so a vehicle whose type was never set is "Unknown"
    // instead of accidentally being a Sedan.
    Unknown,
    Sedan,
    Suv,
    Truck,
    Hatchback,
    Convertible,
    Van
}
