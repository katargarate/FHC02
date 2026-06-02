package HundeFriseur.Dogs;

public class Beagle extends Dog{
    private boolean isAGoodBoy;

    public Beagle(String name, int hairLength, boolean isChipped) {
        super(name, hairLength, isChipped);
    }

    public void isAGoodBoy(boolean isAGoodBoy) {
        if (isAGoodBoy) {
            System.out.printf("\n%s is a good boy!!!!!!!\n", super.getName());
        } else System.out.printf("\n%s is NOT a good boy!!!!!!!\n", super.getName());
    }
}
