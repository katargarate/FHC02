package Own.Decorator.Beverage;

public abstract class Beverage {
    public String description;

    public abstract float getCost();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
