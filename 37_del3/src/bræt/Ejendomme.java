package bræt;

public class Ejendomme extends Felter {

	private boolean tilsalg;
	private int pris;
	private int ejer;
	private int leje;
	
	
	//Konstruktør
	public Ejendomme(String feltnavn, int feltnr, String billede, boolean tilsalg, int pris, int ejer, int leje){
		super(feltnavn, feltnr, billede);
		this.tilsalg = tilsalg;
		this.pris = pris;
		this.ejer = ejer;
		this.leje = leje;
	}
	
	
}
