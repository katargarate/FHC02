package Models;

public class Rechteck {
    private double width;
    private double height;

    public Rechteck(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2*(width + height);
    }

    public String toString() {
        return String.format("""
                Höhe: %.2f
                Breite: %.2f
                Fläche: %.2f
                Umfang: %.2f
                """, height, width, getArea(), getPerimeter());
    }

    // GETTERS & SETTERS

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
