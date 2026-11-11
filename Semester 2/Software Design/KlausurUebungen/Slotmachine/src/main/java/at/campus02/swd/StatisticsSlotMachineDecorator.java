package at.campus02.swd;

/*
Implementieren Sie die Decorator- Klasse StatisticsSlotMachineDecorator. Diese soll für
jedes, durch Aufruf der Methode play(), getätigte Spiel die
drei Zufallszahlen erfassen. Die Erfassung erfolgt über die
Methode getLastResult(), welche die drei ermittelten
Zahlen des letzten Spiels zurück gibt. Diese drei Zahlen
sollen in einer passenden Datenstruktur im Decorator
zusammen mit ihrer Häufigkeit erfasst werden.
 */
public class StatisticsSlotMachineDecorator extends SlotMachine {


    public StatisticsSlotMachineDecorator(long seed) {
        super(seed);
    }



}
