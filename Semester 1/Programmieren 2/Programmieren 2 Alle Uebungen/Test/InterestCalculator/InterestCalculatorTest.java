package InterestCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterestCalculatorTest {
    InterestCalculator ic;

    @BeforeEach
        // Before each must not be static, before all does
    void setUp() {
        ic = new InterestCalculator();
    }

    @Test
    void testCalculateInterest() {
        double temp = ic.calculateAmountWithInterest(100, 20);
        Assertions.assertEquals(120.0, temp);
    }

    @Test
    void testCalculateInterestWithYears() {
        double temp = ic.calculateAmountWithInterest(100, 20, 5);
        Assertions.assertEquals(248.83, temp);
        // if not rounded can use delta for accuracy by cent
        // Assertions.assertEquals(248.83, temp, AlterCompsaratorASC
        //Hase
        //KarottenComparatorASC
        //Main.java
        //Osterhase0.002);
    }

    @Test
    void testTestMethode() {
        double temp = ic.testMethode(); // returned double saved in temp

        // verify
        Assertions.assertEquals(0.0, temp);
        // Assertions.assertTrue(temp == 0.0);

    }

}