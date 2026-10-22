package Pruefungsuebungen.Pruefung_Musikanten_1;

import java.util.ArrayList;
import java.util.HashMap;

public class MusikantenTest {

	public static void main(String[] args) {
		// Testen Sie hier Ihr Beispiel

		Instrument gitarre = new Instrument("Gitarre", 2.3);
		Instrument piano = new Instrument("Piano", 0.9);
		Instrument ukulele = new Instrument("Ukulele", 2.1);
		Instrument trommel = new Instrument("Trommel", 4.2);

		Hund hund1  = new Hund(4, gitarre, 2);
		Hund hund2 = new Hund(3, piano, 3);

        Hahn hahn1 = new Hahn(2, ukulele, 3);
        Hahn hahn2 = new Hahn(1, trommel, 2);

		Esel esel1 = new Esel(4, piano, 3.2);
		Esel esel2 = new Esel(3, trommel, 12.1);

		Katze katze1 = new Katze(3, gitarre, 2.2);
		Katze katze2 = new Katze(4, ukulele, 3.5);
		Katze katze3 = new Katze(1, trommel, 3);

		Quartett quartett1 = new Quartett();
		Quartett quartett2 = new Quartett();

		quartett1.add(katze1);
		quartett2.add(katze2);

		quartett1.add(esel1);
		quartett2.add(esel2);

		quartett1.add(hund1);
		quartett2.add(hund2);

		quartett1.add(hahn1);
		quartett2.add(hahn2);

		System.out.println("Ist die Quartett vollständig?: " + quartett1.istQuartett());

		System.out.println("Wie viele Räuber können alle Musikanten zusammen verscheuchen?: "
				+ quartett1.gemeinsamRaeuberVerscheucht());

		System.out.println("Was ist die durchschnittliche Lautstärke des Quartetts?: "
		+ quartett1.durchschnittlicheLautstaerke());

        ArrayList<Musikant> musi = quartett1.getMusikantenInLautstaerkeBereich(2, 4);

		for (Musikant m : musi) {
			System.out.println(m);
		}

		// Anzahl Musikanten Mit Bein Anzahl
		HashMap<Integer, Integer> musi2 = quartett1.getAnzahlMusikantenMitBeinAnzahl();

		for (Integer i : musi2.keySet()) {
			System.out.println(musi2.get(i));
		}

		System.out.println("Alle Musikanten im Quartett absteigend nach Lautstärke:");
		quartett1.printLautStaerkeAbsteigend();




	}

}
