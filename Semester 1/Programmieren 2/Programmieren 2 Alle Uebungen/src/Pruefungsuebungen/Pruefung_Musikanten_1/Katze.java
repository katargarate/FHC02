package Pruefungsuebungen.Pruefung_Musikanten_1;

public class Katze extends Musikant {
	protected double kratzKraft;
	
	public Katze(int aB, Instrument i , double kratzKraft) {
		super(aB, i);
		this.kratzKraft = kratzKraft;
	}

	@Override
	int verscheucheRaeuber() {
		//  Die Katze kratzt die Räuber und verscheucht sie damit. (z.B. Kraft
		//3.8 verscheucht 3 Räuber). Wenn die Katze verletzt ist und nur 3 Beine hat kann sie
		//nur halb so stark kratzen und wenn die Katze nur 2 Beine (oder weniger) hat kann sie
		//nur 1 Räuber verscheuchen.

		if (anzahlBeine == 4) {
			return (int) Math.floor(kratzKraft); // bei 3 Beine, gleich viele Räuber wie Kratzkraft (floored)
		} else if (anzahlBeine == 3) {
			return (int) Math.floor(kratzKraft) / 2; // bei 3 Beine, nur halb so viele
		} else { // bei nur 1 oder 2 Beine immer nur 1 Räuber
			return 1;
		}
	}

	@Override
	double spieleMusik() {
		// gleich laut wie sein Instrument
		return instrument.getLautstaerke();
	}

	public double getKratzKraft() {
		return kratzKraft;
	}

	@Override
	public String toString() {
		return String.format("Katze Kratzkraft %.2f, %s", kratzKraft, super.toString());
	}
}
