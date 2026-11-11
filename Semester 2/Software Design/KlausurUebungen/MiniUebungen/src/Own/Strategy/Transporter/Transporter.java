package Own.Strategy.Transporter;

public class Transporter {

    private String name;
    private double kilometerFee;
    private double kilogramFee;

    public Transporter(String name, double kilometerFee, double kilogramFee) {
        this.name = name;
        this.kilogramFee = kilogramFee;
        this.kilometerFee = kilometerFee;
    }

    public String getName() {
        return name;
    }

    public double getKilogramFee() {
        return kilogramFee;
    }

    public double getKilometerFee() {
        return kilometerFee;
    }

}

