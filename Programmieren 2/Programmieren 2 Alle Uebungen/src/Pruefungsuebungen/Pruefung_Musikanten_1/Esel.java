package Pruefungsuebungen.Pruefung_Musikanten_1;

public class Esel extends Musikant{
	protected double trittkraft;
	public Esel(int aB, Instrument i, double trittkraft) 
	{
		super(aB, i);
		this.trittkraft = trittkraft;
	}

	@Override
    public int verscheucheRaeuber() {
		// Der Esel kann Trittkraft * Beinanzahl viele Räuber verscheuchen
		return (int) Math.floor(trittkraft * anzahlBeine);
	}

	@Override
    public double spieleMusik() {
		// gleich laut wie sein Instrument
		return instrument.getLautstaerke();
	}

	public double getTrittkraft() {
		return trittkraft;
	}

	@Override
	public String toString() {
		return String.format("Esel Trittkraft: %.2f, %s", trittkraft, super.toString());
	}


}
