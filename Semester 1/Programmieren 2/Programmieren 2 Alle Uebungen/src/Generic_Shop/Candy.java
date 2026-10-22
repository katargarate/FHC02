package Generic_Shop;

public class Candy {
    private String colour;
    private String name;
    private double price;
    private String flavour;
    private String shape;

    public Candy(String colour, String name, double price, String flavour, String shape) {
        this.colour = colour;
        this.name = name;
        this.price = price;
        this.flavour = flavour;
        this.shape = shape;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
