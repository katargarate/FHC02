package Own.Factory.BikeAndCarFactory;

class Main {
    public static void main(String[] args) {
        VehicleFactory bikes = new BikeFactory();
        VehicleFactory cars = new CarFactory();

        System.out.println(bikes.getVehicle(VehicleType.BIKE));
        System.out.println(cars.getVehicle(VehicleType.BIKE));
        System.out.println(cars.getVehicle(VehicleType.CAR));
        System.out.println(bikes.getVehicle(VehicleType.SCOOTER));
    }

}
