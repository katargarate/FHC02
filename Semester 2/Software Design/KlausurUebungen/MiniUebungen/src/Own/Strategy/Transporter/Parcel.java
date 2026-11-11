package Own.Strategy.Transporter;

public class Parcel {

    private Transporter transporter;
    private double weight;
    private int distance;

    public Parcel(Transporter transporter, double weight, int distance) {
        this.transporter = transporter;
        this.weight = weight;
        this.distance = distance;
    }

    public Transporter getTransporter() {
        return transporter;
    }

    public double getWeight() {
        return weight;
    }

    public int getDistance() {
        return distance;
    }

    public double calcPrice(PriceStrategy strategy) {
        return strategy.calc(this);
    }

}
