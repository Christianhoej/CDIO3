package bræt;

import entity.Spiller;

public class Ejendom3 extends AbstractFelter {

	private boolean tilsalg = true;
	private final int pris = 3;
	private Spiller ejer;
	private final int leje = 3;
	private String feltNavn;

	// Konstruktør
	public Ejendom3(int feltnr) {
		super(feltnr);
		switch(feltnr){
		case 13: feltNavn = "Spillehallen"; break;
		case 14: feltNavn = "Biografen"; break;
		case 16: feltNavn = "Lejetøjsbutikken"; break;
		case 17: feltNavn = "Dyrehaven"; break;
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
