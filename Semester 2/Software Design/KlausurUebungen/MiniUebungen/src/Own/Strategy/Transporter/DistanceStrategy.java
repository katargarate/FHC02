package Own.Strategy.Transporter;

public class DistanceStrategy implements PriceStrategy{
    @Override
    public double calc(Parcel p) {
        return p.getDistance() * p.getTransporter().getKilometerFee();
    }
}
