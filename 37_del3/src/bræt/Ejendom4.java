package bræt;

import entity.Spiller;

public class Ejendom4 extends AbstractFelter {

	private boolean tilsalg = true;
	private final int pris = 4;
	private Spiller ejer;
	private final int leje = 4;
	private String feltNavn;

	// Konstruktør
	public Ejendom4(int feltnr) {
		super(feltnr);
		switch(feltnr){
		case 19: feltNavn = "Bowlinghallen"; break;
		case 20: feltNavn = "Zoo"; break;
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
