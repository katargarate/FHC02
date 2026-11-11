package Own.Strategy.Transporter;

public class Main {
    static void main(String[] args) {
        Transporter t1 = new Transporter("DHL", 1.5, 3);


        Parcel p1 = new Parcel(t1, 2, 20);
        System.out.println(p1.calcPrice(new WeightStrategy()));
        System.out.println(p1.calcPrice(new DistanceStrategy()));
    }
}
