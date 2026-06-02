package Shopping_Center_With_Generics;

public class Candy {
    private String color;
    private String name;
    private double price;
    private String flavor;
    private String shape;

    public Candy(String color, String name, double price, String flavor, String shape) {
        this.color = color;
        this.name = name;
        this.price = price;
        this.flavor = flavor;
        this.shape = shape;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public void setShape(String shale) {
        this.shape = shale;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getShape() {
        return shape;
    }
}
