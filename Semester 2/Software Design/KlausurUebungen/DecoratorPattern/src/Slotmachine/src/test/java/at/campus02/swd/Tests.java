package at.campus02.swd;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Tests {

    @Test
    public void testSlotMachinePrediction() {
        ISlotMachine slot = new SlotMachine(12345678);
        assertFalse(slot.play());
        assertFalse(slot.play());
        assertFalse(slot.play());
        assertTrue(slot.play());
    }

    @Test
    public void testSlotMachineStatistics() {
        ISlotMachine slot = new StatisticsSlotMachineDecorator(new SlotMachine(12345678));
        for (int i = 0; i < 1000; i++) {
            slot.play();
        }
        Map<Integer, Integer> statistics = ((StatisticsSlotMachineDecorator) slot).getStatistics();
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 333);
        expected.put(1, 274);
        expected.put(2, 284);
        expected.put(3, 312);
        expected.put(4, 306);
        expected.put(5, 336);
        expected.put(6, 284);
        expected.put(7, 290);
        expected.put(8, 291);
        expected.put(9, 290);
        assertEquals(expected, statistics);
    }

}
