package Own.Factory.BikeAndCarFactory;

class BikeFactory extends VehicleFactory {
    @Override
    protected Vehicle createVehicle(VehicleType type) {
        if (type == VehicleType.BIKE) return new Bike("BMX", 499.99);
        if (type == VehicleType.SCOOTER) return new Scooter("Rusty scooter", 10.99);
        else return null;
    }
}
