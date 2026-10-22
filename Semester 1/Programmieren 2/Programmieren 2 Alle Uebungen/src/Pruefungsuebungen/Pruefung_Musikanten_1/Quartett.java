package Pruefungsuebungen.Pruefung_Musikanten_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Quartett {
	private List<Musikant> musikanten;

	public Quartett() {
		musikanten = new ArrayList<>();
	}

	public void add(Musikant m) {
		// hinzufügen, wenn dieser Musikant noch nicht in die Liste ist und
		// die Quartett noch nicht vollständig ist (max 4)
		if (!musikanten.contains(m) || !istQuartett()) {
			musikanten.add(m);
		}
	}

	public boolean istQuartett()
	{ // überprüft ob das Quartett vollständig ist. (= enthält 4 Mitglieder)
		return (musikanten.size() == 4); // gibt true zurück wenn size = 4, sonst false
	}
	
	public int gemeinsamRaeuberVerscheucht()
	{
		// summiert wie viele Räuber durch das Quartett verscheucht werden können.
		int summe = 0; // zum Aufzählen der Räuber

		for (Musikant musikant : musikanten) {
			summe += musikant.verscheucheRaeuber(); // pro Musikant werden die Anzahl der Räuber zur Summe addiert
		}

		return summe;
	}

	// durchschnittliche Lautstärke des Quartetts berechnen
	public double durchschnittlicheLautstaerke()
	{
		double summe = 0;

		for (Musikant musikant : musikanten) {
			summe += musikant.spieleMusik();
		}

		// durchschnitt berechnen und zurückgeben
		return summe / musikanten.size();
	}

	//  Liefert in einer Lister alle Musikanten zurück, deren Lautstärke (spielMusik) zwischen den
	// beiden Grenzen liegt.
	public ArrayList<Musikant> getMusikantenInLautstaerkeBereich(double von, double bis)
	{
		ArrayList<Musikant> musikantenImBereich = new ArrayList<>();

		for (Musikant musikant : musikanten) {
			double lautstaerke = musikant.spieleMusik(); // hilfsvariable für leichteres Lesen

			// nur die hinzufügen, deren Lautstärke innerhalb von-bis liegt
			if (lautstaerke >= von && lautstaerke <= bis) {
				musikantenImBereich.add(musikant);
			}
		}
		return musikantenImBereich; // gibt Liste zurück - ist leer wenn keine passende dabei sind
	}


	public HashMap<Integer, Integer> getAnzahlMusikantenMitBeinAnzahl()
	{
		// zählt wie viele Musikanten es jeweils mit einer spezifischen Nummer an Beinen gibt. Gibt eine
		// HashMap mit key (anzahl beine) und value (Anzahl Musikanten mit Key-viele Beine) zurück

		HashMap<Integer, Integer> musikantenMitBeinAnzahl = new HashMap<>();

		for (int i = 0; i <= 4; i++) {

			int anzahlMusiker = 0; // counter für passende Musiker (mit i Beine)

			for (Musikant musikant : musikanten) {
				if (musikant.anzahlBeine == i) {
					anzahlMusiker++;
				}
			}

			// pro Beinanzahl ein neues Key Value pair erstellen
			// (key = anzahlBeine, value = die gezählte, passende Musikanten)
			musikantenMitBeinAnzahl.put(i, anzahlMusiker);
		}

		return musikantenMitBeinAnzahl;
	}


	public void printLautStaerkeAbsteigend()
	{
		// Gibt die Liste alle Musiker absteigend sortiert (mithilfe des Comparators) aus
		musikanten.sort(new LautstaerkeComparator());

		for (Musikant musikant : musikanten) {
			System.out.println(musikant); // gibt den toString String aus
		}


	}
}
