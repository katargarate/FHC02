package LogisticManager;

public class Car implements Moveable{
    private String type;
    private String colour;
    private double weight;

    public Car(String type, String colour, double weight) {
        this.type = type;
        this.colour = colour;
        this.weight = weight;
    }

    @Override
    public void move(String destination) {
        System.out.printf("%s %s will be moved to %s\n", colour, type, destination);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
