package bræt;

import entity.Spiller;

public class Ejendom1 extends AbstractFelter {

	private boolean tilsalg = true;
	private int pris;
	private Spiller ejer;
	private int leje;
	private String feltNavn;

	// Konstruktør
	public Ejendom1(int feltnr) {
		super(feltnr);
		switch(feltnr){
		case 1: feltNavn = "Burgerbaren"; pris = 1; break;
		case 2: feltNavn = "Pizzariaet"; pris = 1; break;
		case 4: feltNavn = "Slikbutikken"; pris = 1; break;
		case 5: feltNavn = "Iskiosken"; pris = 1; break;
		case 7: feltNavn = "Museet"; pris = 2; break;
		case 8: feltNavn = "Biblioteket"; pris = 2; break;
		case 10: feltNavn = "Skaterparken"; pris = 2; break;
		case 11: feltNavn = "Swimmingpool"; pris = 2; break;
		case 13: feltNavn = "Spillehallen"; pris = 3; break;
		case 14: feltNavn = "Biografen"; pris = 3; break;
		case 16: feltNavn = "Lejetøjsbutikken"; pris = 3; break;
		case 17: feltNavn = "Dyrehaven"; pris = 3; break;
		case 19: feltNavn = "Bowlinghallen"; pris = 4; break;
		case 20: feltNavn = "Zoo"; pris = 4; break;
		case 22: feltNavn = "Vandlandet"; pris = 5; break;
		case 23: feltNavn = "Stranpromenaden"; pris = 5; break;
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

	public void setPris(int pris) {
		this.pris=pris;
	}
	
	public int getPris() {
		return pris;
	}
	
	public void setLeje(int leje) {
		this.leje=leje;
	}
	
	public int getLeje() {
		return leje;
	}
	
	public void setTilsalg(boolean tilsalg){
		this.tilsalg = tilsalg;
	}
	
	public boolean isTilsalg(){
		return tilsalg;
	}
	
	public void landOnField(int feltnr){
		
	}

}
