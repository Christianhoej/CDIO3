package bræt;

import entity.Spiller;

public class Ejendom2 extends AbstractFelter {

	private boolean tilsalg = true;
	private final int pris = 2;
	private Spiller ejer;
	private final int leje = 2;
	private String feltNavn;

	// Konstruktør
	public Ejendom2(int feltnr) {
		super(feltnr);
		switch(feltnr){
		case 7: feltNavn = "Museet"; break;
		case 8: feltNavn = "Biblioteket"; break;
		case 10: feltNavn = "Skaterparken"; break;
		case 11: feltNavn = "Swimmingpool"; break;
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
