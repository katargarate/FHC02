package HundeFriseur.Dogs;

public abstract class Dog {
    private String name;
    private int hairLength;
    private boolean isChipped;


    public Dog(String name, int hairLength, boolean isChipped) {
        this.name = name;
        this.hairLength = hairLength;
        this.isChipped = isChipped;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHairLength() {
        return hairLength;
    }

    public void setHairLength(int hairLength) {
        int hairLengthOld = hairLength;

        if (hairLength < 0) {
            System.out.printf("Dog's hair was not cut because their current length of %d cm is shorter than the desired cut length!\n",
                    hairLengthOld);
        } else {
            System.out.printf("Cut dog's hair successfully! Their fur went from %d cm to %d cm. Looking fresh!\n", hairLengthOld, hairLength);
            this.hairLength = hairLength;
        }
    }

    public boolean isChipped() {
        return isChipped;
    }

    public void setChipped(boolean chipped) {
        isChipped = chipped;
    }
}
