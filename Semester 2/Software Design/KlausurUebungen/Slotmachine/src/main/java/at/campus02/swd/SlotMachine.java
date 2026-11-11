package at.campus02.swd;

import java.util.Random;

public class SlotMachine implements ISlotMachine {

    private int[] lastSymbols = { 0, 0, 0 };
    private Random random = new Random();
    private int maxInteger = 10;

    public SlotMachine(long seed) {
        random = new Random(seed);
    }

    @Override
    public boolean play() {
        for (int i = 0; i <= 2; i++) {
            lastSymbols[i] = random.nextInt(maxInteger);
        }
        return lastSymbols[0] == lastSymbols[1] && lastSymbols[1] == lastSymbols[2];
    }

    @Override
    public int[] getLastResult() {
        return lastSymbols;
    }

}
