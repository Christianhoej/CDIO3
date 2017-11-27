package bræt;

public class Ejendom extends Felter {

	private boolean tilsalg;
	private int pris;
	private int ejer;
	private int leje;

	// Konstruktør
	public Ejendom(String feltnavn, int feltnr, String billede, boolean tilsalg, int pris, int ejer, int leje) {
		super(feltnavn, feltnr, billede);
		this.tilsalg = tilsalg;
		this.pris = pris;
		this.ejer = ejer;
		this.leje = leje;
	}

	public void setEjer(int ejer) {
		this.ejer = ejer;
	}

	public int getEjer() {
		return ejer;
	}

	public void setLeje(int leje) {
		this.leje = leje;
	}

	public int getLeje() {
		return leje;
	}

}
