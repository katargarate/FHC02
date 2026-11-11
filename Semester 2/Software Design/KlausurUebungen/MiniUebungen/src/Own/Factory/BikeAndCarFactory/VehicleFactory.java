package Own.Factory.BikeAndCarFactory;

abstract class VehicleFactory {

    private static int currInventoryNr = 1000;

    public final Vehicle getVehicle(VehicleType type) {

        Vehicle vehicle = createVehicle(type);

        if (vehicle != null) {
            vehicle.setInventoryNr(currInventoryNr++);
            System.out.println("\nOrdered a vehicle of type " + type.name());
        } else System.out.println("\nVehicle could not be created");

        return vehicle;
    }

    protected abstract Vehicle createVehicle(VehicleType type);

}
