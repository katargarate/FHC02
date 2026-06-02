package Programmieruebungen5;
/*
Erstellen Sie eine Hauptklasse namens "AutoTest", die zwei Instanzen der Klasse
"Auto" erzeugt, ihre Attribute festlegt und ihre Methoden testet, indem sie sie aufruft
und die Ergebnisse ausgibt.
Die Hauptklasse könnte zum Beispiel ein "Auto"-Objekt mit dem Namen "auto1" mit
den folgenden Attributen erstellen:
• Marke: "Toyota"
• Modell: "Camry"
• Jahr: 2018
• Geschwindigkeit: 0
 */

public class AutoTest {
    static void main() {
        Auto auto1 = new Auto("Toyota", "Camry", 2018);

        auto1.gasGeben(100); // Geschwindigkeit erhöhen
        System.out.println(auto1);

        auto1.bremsen(60); // Geschwindigkeit senken
        System.out.println(auto1);

        auto1.setJahr(2020); // Jahr ändern
        System.out.println(auto1);

        Auto auto2 = new Auto("BMW", "M550i", 2020);
        auto2.gasGeben(260);
        System.out.println(auto2);
    }
}
