package bræt;

import java.awt.Color;

import entity.Spiller;
import gui_fields.GUI_Field;
import gui_fields.GUI_Street;

public class Ejendom extends AbstractFelter {

	private boolean tilsalg = true;
	private int pris;
	private Spiller ejer;
	private int leje;
	private String feltNavn;
//	private Color farve;
//	private GUI_Field[] felter;
//	private int feltnr;

	// Konstruktør
	public Ejendom(int feltnr) {
		super(feltnr);
//		switch(feltnr){
//		case 1: feltNavn = "Burgerbaren"; pris = 1; farve = new Color(153,102,0); break;
//		case 2: feltNavn = "Pizzariaet"; pris = 1; farve = new Color(153,102,0); break;
//		case 4: feltNavn = "Slikbutikken"; pris = 1; farve = new Color(51, 204, 255); break;
//		case 5: feltNavn = "Iskiosken"; pris = 1; farve = new Color(51, 204, 255); break;
//		case 7: feltNavn = "Museet"; pris = 2; farve = new Color(204, 0, 100); break;
//		case 8: feltNavn = "Biblioteket"; pris = 2; farve = new Color(204, 0, 100); break;
//		case 10: feltNavn = "Skaterparken"; pris = 2; farve = Color.YELLOW; break;
//		case 11: feltNavn = "Swimmingpool"; pris = 2; farve = Color.YELLOW; break;
//		case 13: feltNavn = "Spillehallen"; pris = 3; farve = new Color(204, 0, 0); break;
//		case 14: feltNavn = "Biografen"; pris = 3; farve = new Color(204, 0, 0); break;
//		case 16: feltNavn = "Lejetøjsbutikken"; pris = 3; farve = new Color(255, 153,0); break;
//		case 17: feltNavn = "Dyrehaven"; pris = 3; farve = new Color(255, 153,0); break;
//		case 19: feltNavn = "Bowlinghallen"; pris = 4; farve = new Color(0, 153, 0); break;
//		case 20: feltNavn = "Zoo"; pris = 4; farve = new Color(0, 153, 0); break;
//		case 22: feltNavn = "Vandlandet"; pris = 5; farve = Color.BLUE; break;
//		case 23: feltNavn = "Stranpromenaden"; pris = 5; farve = Color.BLUE; break;
//		}
	}
	
	
//	public GUI_Street opretFeltt(){
//		GUI_Street field = new GUI_Street();
//		field.setTitle(feltNavn);
//		felter[feltnr].setDescription("feltNavn");
//		felter[feltnr].setSubText(Integer.toString(pris));
//		felter[feltnr].setBackGroundColor(farve); // Light brown
//		return field;
//	}

	@Override
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


	@Override
	public void landOnField() {
		// TODO Auto-generated method stub
		
	}

}
