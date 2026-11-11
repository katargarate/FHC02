package at.campus02.zam.sd.bsp2.Products;

public abstract class Auto {
    private String modell;
    private double tagespreis;

    public Auto(String modell, double tagespreis) {
        this.modell = modell;
        this.tagespreis = tagespreis;
    }

    public String info(){
        return String.format("%s (%.2f EUR/TAG)", modell, tagespreis);
    }

    public String getModell() {
        return modell;
    }

    public double getTagespreis() {
        return tagespreis;
    }
}
