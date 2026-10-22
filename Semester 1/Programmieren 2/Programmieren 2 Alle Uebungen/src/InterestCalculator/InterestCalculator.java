package InterestCalculator;

public class InterestCalculator {

    public double calculateAmountWithInterest(double amount, double interest) {
        return calculateAmountWithInterest(amount, interest, 1);
    }

    public double calculateAmountWithInterest(double amount, double interest, int years) {
        double val = amount * Math.pow(1 + interest/100, years);
        return Math.round(val * 100.0) / 100.0; // rounds it

    }

    public double testMethode() {
        return 0.0d;
    }


}
