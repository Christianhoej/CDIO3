package bræt;

import entity.Spiller;

public class Ejendom1 extends AbstractFelter {

	private boolean tilsalg = true;
	private final int pris = 1;
	private Spiller ejer;
	private final int leje = 1;
	private String feltNavn;

	// Konstruktør
	public Ejendom1(int feltnr) {
		super(feltnr);
		switch(feltnr){
		case 1: feltNavn = "Burgerbaren"; break;
		case 2: feltNavn = "Pizzariaet"; break;
		case 4: feltNavn = "Slikbutikken"; break;
		case 5: feltNavn = "Iskiosken"; break;
		}
	}

	public String toString(){
		return "Du har landet på" + feltNavn;
	}
	
	
	public void setEjer(Spiller ejer) {
		this.ejer = ejer;
	}

	public Spiller getEjer() {
		return ejer;
	}
	
	public void fjernEjer(){
		this.ejer = null;
	}

	public int getLeje() {
		return leje;
	}
	
	public void setTilsalg(boolean tilsalg){
		this.tilsalg = tilsalg;
	}
	
	public boolean getTilsalg(){
		return tilsalg;
	}
	
	public void landOnField(int feltnr){
		
	}

}
