package at.campus02.enums;

public class Coffee {
    private String type;
    private CoffeeSize size;
    private double price;

    public Coffee(String type, CoffeeSize size, double price) {
        this.type = type;
        this.size = size;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s %s, €%.2f", type, size, price);
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public CoffeeSize getSize() {
        return size;
    }
}
