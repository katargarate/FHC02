package Pizzeria.ProduktKlassen;

public class Pizza {
    private String name;

    public Pizza(String name) {
        this.name = name;
    }

    public void prepare() {
        System.out.printf("* Preparing the %s pizza\n", name);
    }

    public void bake()  {
        System.out.printf("** Baking the %s pizza\n", name);
    }

    public void box() {
        System.out.printf("*** Boxing the %s pizza\n", name);
    }

    public void cut() {
        System.out.printf("**** Cutting the %s pizza\n", name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Pizza %s", name);
    }

}
