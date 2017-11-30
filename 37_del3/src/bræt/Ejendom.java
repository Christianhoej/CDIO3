package bræt;

import java.awt.Color;

import entity.Spiller;
import gui_fields.GUI_Field;
import gui_fields.GUI_Street;

public class Ejendom extends AbstractFelter {

	private boolean tilsalg = true;
	private int pris;
	private Spiller spiller;
	private String feltNavn;
//	private Color farve;
//	private GUI_Field[] felter;
	private int feltnr;
	

	// Konstruktør
	public Ejendom(int feltnr) {
		super(feltnr);
		switch(feltnr){
		case 1: feltNavn = "Burgerbaren"; pris = 1; //farve = new Color(153,102,0); break;
				break;
		case 2: feltNavn = "Pizzariaet"; pris = 1; //farve = new Color(153,102,0); break;
			break;
		case 4: feltNavn = "Slikbutikken"; pris = 1; //farve = new Color(51, 204, 255); break;
			break;
		case 5: feltNavn = "Iskiosken"; pris = 1; //farve = new Color(51, 204, 255); break;
			break;
		case 7: feltNavn = "Museet"; pris = 2; //farve = new Color(204, 0, 100); break;
			break;
		case 8: feltNavn = "Biblioteket"; pris = 2; //farve = new Color(204, 0, 100); break;
			break;		
		case 10: feltNavn = "Skaterparken"; pris = 2; //farve = Color.YELLOW; break;
			break;
		case 11: feltNavn = "Swimmingpool"; pris = 2; //farve = Color.YELLOW; break;
			break;
		case 13: feltNavn = "Spillehallen"; pris = 3; //farve = new Color(204, 0, 0); break;
			break;
		case 14: feltNavn = "Biografen"; pris = 3; //farve = new Color(204, 0, 0); break;
			break;
		case 16: feltNavn = "Lejetøjsbutikken"; pris = 3; //farve = new Color(255, 153,0); break;
			break;
		case 17: feltNavn = "Dyrehaven"; pris = 3; //farve = new Color(255, 153,0); break;
			break;
		case 19: feltNavn = "Bowlinghallen"; pris = 4; //farve = new Color(0, 153, 0); break;
			break;
		case 20: feltNavn = "Zoo"; pris = 4; //farve = new Color(0, 153, 0); break;
			break;
		case 22: feltNavn = "Vandlandet"; pris = 5; //farve = Color.BLUE; break;
			break;
		case 23: feltNavn = "Stranpromenaden"; pris = 5; //farve = Color.BLUE; break;
			break;
		}
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
	
	public void setEjer(Spiller spiller) {
		this.spiller = spiller;
	}

	public Spiller getEjer() {
		return spiller;
	}
	
	public void fjernEjer(){
		this.spiller = null;
	}
	
	public int getPris() {
		return pris;
	}
	
	public void setTilsalg(boolean tilsalg){
		this.tilsalg = tilsalg;
	}
	
	public boolean isTilsalg(){
		return tilsalg;
	}
	
	@Override
	public void landOnField(Spiller spiller){
		// Hvis ejendommen er til salg og spiller får den gratis ift. chancekort
		if(spiller.getGratis() && isTilsalg()){
			spiller.tilførSkøde(feltnr, 0);
			setTilsalg(false);
			setEjer(spiller);
			spiller.setGratis(false);
		}
		// Hvis ejendommen er til salg og skal købes
		if(isTilsalg()){
			spiller.tilførSkøde(feltnr, pris);
			setTilsalg(false);
			setEjer(spiller);
		}
		// Hvis ejendommen ejes, og spiller skal betale husleje.
		else if(!isTilsalg()&& getEjer().getNavn() != spiller.getNavn()){
			getEjer().ændrLikvideMidler(pris);
			spiller.ændrLikvideMidler(-pris);
		}
	}
}
