package Pruefungsuebungen.Pruefung_Musikanten_1;

public class Hahn extends Musikant {
	protected int flugWeite;

	public Hahn(int aB, Instrument i , int flugWeite) {
		super (aB, i);
		this.flugWeite = flugWeite;
	}

	@Override
	int verscheucheRaeuber() {
		// Wie viele Räuber der Hahn verscheucht ist abhängig von seiner Flugweite und der Lautstärke seines Instruments.

		// alles unter 2 -> gleich viel Räuber wie floored Lautstaerke
		if (flugWeite < 2) {
			return (int) Math.floor(instrument.getLautstaerke());
		}

		// 2-6 mit switch behandelt
		switch (flugWeite) {
			case 2:
				return 6;
			case 3:
				return 5;
			case 4:
				return 4;
			case 5:
				return 3;
			case 6:
				return 2;
		}

		return 1;  // für alle über 6, nur einen Räuber

	}

	@Override
	double spieleMusik() {
		//Instrumentlautstärke um 2 erhöht
		double gesamtLautstärke = instrument.getLautstaerke() + 2;

		//Lautstärke durch die Flugweite dividiert weil er in die Luft fliegt
		return gesamtLautstärke / flugWeite;
	}

	public int getFlugWeite() {
		return flugWeite;
	}

	@Override
	public String toString() {
		return String.format("Hahn Flugweite: %d, %s", flugWeite, super.toString());
	}
}
