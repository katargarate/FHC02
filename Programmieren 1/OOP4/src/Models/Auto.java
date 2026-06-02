package Models;

public class Auto {
    // variables that belong to the class
    private String marke;
    private int ps;

    // empty constructor
    public Auto() {
    }

    // constructor with both marke + PS
    public Auto(String marke, int ps) {
        this.marke = marke; // assign the variables to this instance
        this.ps = ps;
    }

    // constructor with marke
    public Auto(String marke) {
        this.marke = marke;
    }

    public String toString() {
        return String.format("Marke: %s\nPS: %d ", this.marke, this.ps);
    }


}
