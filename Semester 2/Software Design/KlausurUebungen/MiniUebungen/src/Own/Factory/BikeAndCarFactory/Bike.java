package Own.Factory.BikeAndCarFactory;

class Bike extends Vehicle {
    public Bike(String name, double price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Bike{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", inventoryNr=" + inventoryNr +
                '}';
    }
}
