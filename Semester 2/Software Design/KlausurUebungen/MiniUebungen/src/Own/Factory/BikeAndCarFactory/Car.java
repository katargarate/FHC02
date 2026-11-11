package Own.Factory.BikeAndCarFactory;

class Car extends Vehicle {
    public Car(String name, double price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", inventoryNr=" + inventoryNr +
                '}';
    }
}
