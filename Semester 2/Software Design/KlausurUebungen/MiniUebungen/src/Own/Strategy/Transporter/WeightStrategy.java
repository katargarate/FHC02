package Own.Strategy.Transporter;

public class WeightStrategy implements PriceStrategy{
    @Override
    public double calc(Parcel p) {
        return p.getWeight() * p.getTransporter().getKilogramFee();
    }
}
