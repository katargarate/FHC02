package KuchenRezepte;

public class BlueberryPie {
    private static void bakeBlueBerrypie(){
        System.out.println("Hier ist das Blueberry-Pie-Rezept");
    }

    //Das würde gehen, da die Methode public ist - allerdings wäre es nicht im Sinne des Erfinders..
    public static void rufeAlleRezepteAuf(){
        bakeBlueBerrypie();
        ApplePie.bakeApplePie();
        CheeseCake.bakeCheeseCake();
    }

}
