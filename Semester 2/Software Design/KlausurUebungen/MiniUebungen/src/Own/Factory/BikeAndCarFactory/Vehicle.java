package Own.Factory.BikeAndCarFactory;

public abstract class Vehicle {
    public String name;
    public double price;
    public int inventoryNr;

    public Vehicle(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setInventoryNr(int i) {
        inventoryNr = i;
    }
}
