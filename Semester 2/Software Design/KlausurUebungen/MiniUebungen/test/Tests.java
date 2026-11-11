import Own.Strategy.Transporter.DistanceStrategy;
import Own.Strategy.Transporter.Parcel;
import Own.Strategy.Transporter.Transporter;
import Own.Strategy.Transporter.WeightStrategy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {

    private Transporter t;
    private Parcel p;

    @Before
    public void setUp() throws Exception {
        t = new Transporter("DHL", 4.5, 80.0);
        p = new Parcel(t, 30.0, 700);
    }

    @Test
    public void testSpedition() {
        assertEquals("DHL", t.getName());
        assertEquals(80.0, t.getKilogramFee(), 0);
        assertEquals(4.5, t.getKilometerFee(), 0);
    }

    @Test
    public void testLieferung() {
        assertEquals(t, p.getTransporter());
        assertEquals(30.0, p.getWeight(), 0);
        assertEquals(700, p.getDistance());
    }

    @Test
    public void testGewichtStrategie() {
        assertEquals(2400.0, p.calcPrice(new WeightStrategy()), 0);
    }

    @Test
    public void testDistanzStrategie() {
        assertEquals(3150.0, p.calcPrice(new DistanceStrategy()), 0);
    }

}
