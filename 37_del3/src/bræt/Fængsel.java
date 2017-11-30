package bræt;

import entity.Spiller;
import gui_fields.GUI_Field;
import gui_fields.GUI_Jail;
import gui_main.GUI;

public class Fængsel extends AbstractFelter {

	private final int kaution = -1;
	private int feltnr;
	private GUI_Field[] felter;
	private GUI gui;
	private Spiller spiller;

	//Konstruktør kan laves
	public Fængsel(int feltnr){
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
		spiller.setPlacering(6);
	}

	@Override
	public void landOnField(Spiller spiller) {
		gui.showMessage(toString());
		setIFængsel();
		spiller.setFængsel(true);
	}
	
	
}
