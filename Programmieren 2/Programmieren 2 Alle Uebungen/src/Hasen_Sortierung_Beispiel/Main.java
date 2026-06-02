import Hasen_Sortierung_Beispiel.AlterComparatorASC;
import Hasen_Sortierung_Beispiel.Hase;
import Hasen_Sortierung_Beispiel.KarottenComparatorASC;
import Hasen_Sortierung_Beispiel.Osterhase;

void main() {
    List<Hase> alleHasen = new ArrayList<>();

    alleHasen.add(new Hase("Hoppy", 2, 2, 5));
    alleHasen.add(new Hase("Jumpy", 2, 2, 14));
    alleHasen.add(new Osterhase("Skippy", 1, 3, 12));
    alleHasen.add(new Hase("Trotty", 10, 3, 10));
    alleHasen.add(new Osterhase("Springy", 8, 3, 12));
    alleHasen.add(new Osterhase("Pouncy", 8, 2, 0));


    // Collections.sort(alleHasen);

    for (Hase h : alleHasen) {
        System.out.println(h);
    }

    // using comparator classes
    Collections.sort(alleHasen, new AlterComparatorASC());
    Collections.sort(alleHasen, new KarottenComparatorASC()); // wird erneut umsortiert


    for (Hase h : alleHasen) {
        System.out.println(h);
    }

}
