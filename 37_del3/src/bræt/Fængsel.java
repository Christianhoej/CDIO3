package bræt;

import entity.Spiller;
import gui_fields.GUI_Field;
import gui_fields.GUI_Jail;

public class Fængsel extends AbstractFelter {

	private boolean besøg;
	private final int kaution = -1;
	private int feltnr;
	private GUI_Field[] felter;

	//Konstruktør kan laves
	public Fængsel( int feltnr){
		super(feltnr);
	}

//	@Override
//	public void opretFelt(){
//		felter[feltnr] = new GUI_Jail();
//		felter[feltnr].setTitle("Gå i fængsel");
//		felter[feltnr].setDescription("");
//		felter[feltnr].setSubText("Gå i fængsel");
//	}
	
	
	
	@Override
	public String toString(){
		return "Du er blevet taget for at stjæle slik, og skal i fængsel";
	}
	
	public void setIFængsel(){
		Spiller.setPlacering(6);
	}
	
	public void betalKaution(){
		Spiller.setLikvideMidler(kaution);
	}

	@Override
	public void landOnField() {
		// TODO Auto-generated method stub
		
	}
	
	
}
