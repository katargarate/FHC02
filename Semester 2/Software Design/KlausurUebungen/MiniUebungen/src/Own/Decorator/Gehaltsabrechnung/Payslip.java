package Own.Decorator.Gehaltsabrechnung;

public abstract class Payslip {

    public final String create() {
        double gross = calculateGross();
        if (includeBonus()) {
            gross += 500;
        }
        double deductions = calculateDeductions(gross);
        double net = gross - deductions;

        return String.format("Gross: €%.2f - Deductions of €%.2f = Net of €%.2f", gross, deductions, net);
    }

    protected abstract double calculateGross() ;

    protected abstract double calculateDeductions(double gross);

    protected boolean includeBonus() {
        // standardmäßig auf false gesetzt
        return false;
    }
}

// EmployeePayslip: Brutto 3000, Abzüge 25 % vom (eventuell erhöhten) Brutto. Hier wird der Bonus ausgezahlt (includeBonus() liefert true).
class EmployeePayslip extends Payslip {

    @Override
    protected double calculateGross() {
        return 3000;
    }

    @Override
    protected double calculateDeductions(double gross) {
        return 0.25 * gross;
    }

    @Override
    protected boolean includeBonus() {
        return true;
    }
}


//FreelancerPayslip: Brutto 2000, Abzüge 10 % vom Brutto. Kein Bonus.
class FreelancerPlayslip extends Payslip{

    @Override
    protected double calculateGross() {
        return 2000;
    }

    @Override
    protected double calculateDeductions(double gross) {
        return 0.1 * gross;
    }
}

class Main {
    static void main(String[] args) {
        FreelancerPlayslip freelancer = new FreelancerPlayslip();
        EmployeePayslip employee = new EmployeePayslip();

        System.out.println("--- Freelancer playslip ---");
        System.out.println("Expected: €1800.00");
        System.out.println("Result: " + freelancer.create());
        System.out.println("\n--- Employee playslip ---");
        System.out.println("Expected: €2625.00");
        System.out.println("Result: " + employee.create());
    }
}