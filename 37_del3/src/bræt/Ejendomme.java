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
	
	public void setEjer(){
		this.ejer = ejer;
	}
	
	public int getEjer(int ejer) {
		return ejer;
	}
	
	public int getLeje(int leje) {
		return leje;
	}
	
	public int betalLeje () {
		
	}
	
	
}
