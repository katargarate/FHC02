package Own.Factory.BikeAndCarFactory;

class Scooter extends Vehicle {
    public Scooter(String name, double price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Scooter{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", inventoryNr=" + inventoryNr +
                '}';
    }
}
