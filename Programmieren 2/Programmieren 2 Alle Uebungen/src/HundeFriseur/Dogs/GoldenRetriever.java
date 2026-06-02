package HundeFriseur.Dogs;

public class GoldenRetriever extends Dog {
    private boolean canDoTricks;
    private boolean ownerHAsToHoldPaw;


    public GoldenRetriever(String name, int hairLength, boolean isChipped) {
        super(name, hairLength, isChipped);
    }

    public void bark() {
        System.out.println( "WOOF WOOF WOOF");
    }

    public boolean isCanDoTricks() {
        return canDoTricks;
    }

    public void setCanDoTricks(boolean canDoTricks) {
        this.canDoTricks = canDoTricks;
    }

    public boolean isOwnerHAsToHoldPaw() {
        return ownerHAsToHoldPaw;
    }

    public void setOwnerHAsToHoldPaw(boolean ownerHAsToHoldPaw) {
        this.ownerHAsToHoldPaw = ownerHAsToHoldPaw;
    }
}
