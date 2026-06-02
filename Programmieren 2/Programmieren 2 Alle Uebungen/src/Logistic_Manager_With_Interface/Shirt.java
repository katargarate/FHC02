package Logistic_Manager_With_Interface;

public class Shirt implements Moveable {
    private String brand;
    private char size;
    private String colour;

    public Shirt(String brand, char size, String colour) {
        this.brand = brand;
        this.size = size;
        this.colour = colour;
    }

    @Override
    public void move(String destination) {
        System.out.printf("%s shirt in size %c from the brand %s will be moved to %s\n", colour, size, brand, destination);
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
