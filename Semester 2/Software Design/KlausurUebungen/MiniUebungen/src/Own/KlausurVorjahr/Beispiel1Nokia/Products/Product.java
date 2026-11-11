package Own.KlausurVorjahr.Beispiel1Nokia.Products;

public abstract class Product {

    public void addSerialNumber()
    {
        System.out.println("Add serial number " + toString());
    }

    public abstract String getSpeed();

    @Override
    public String toString() {
        return String.format("%s", this.getClass().getName());
    }

}