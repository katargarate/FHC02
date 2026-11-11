package Own.Factory.BikeAndCarFactory;

class CarFactory extends VehicleFactory {
    @Override
    protected Vehicle createVehicle(VehicleType type) {
        if (type == VehicleType.CAR) return new Car("carcar", 30000);
        else return null;
    }
}
