package Pruefungsuebungen.Pruefung_Musikanten_1;

public class Hund extends Musikant{
	protected double bellLautstaerke;

	public Hund(int aB, Instrument i , double bellLautstaerke) {
		super(aB,i);
		this.bellLautstaerke = bellLautstaerke;
	}

	@Override
	int verscheucheRaeuber() {
		// Der Hund verscheucht die Räuber mit lauten Geräuschen und verwendet je nachdem was
		// lauter ist entweder sein Bellen oder sein Instrument.

		// gibt den "floored" wert zurück von den größeren zurück
		return (int) Math.floor(Math.max(bellLautstaerke, instrument.getLautstaerke()));
	}

	@Override
	double spieleMusik() {
		// Die Hund Lautstärke ist der mittlere Wert zwischen Instrument- und
		//Belllautstärke.

		// durchschnitt von Instrument Lautstärke und Bell Lautstärke
		return (instrument.getLautstaerke() + bellLautstaerke) / 2;
	}

	public double getBellLautstaerke() {
		return bellLautstaerke;
	}

	@Override
	public String toString() {
		return String.format("Hund Bell Lautstärke: %.2f, %s", bellLautstaerke, super.toString());
	}
}
