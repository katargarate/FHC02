package Binary;

import java.io.Serializable;

public class Coffee implements Serializable {
    public String name;
    public char size;
    public double price;


    public Coffee(String name, char size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }


    @Override
    public String toString() {
        return String.format("Coffee: %s, Size: %c, Price: €%.2f", name, size, price);
    }
}

