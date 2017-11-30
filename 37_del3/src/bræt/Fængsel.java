package bræt;

import entity.Spiller; 
import gui_main.GUI;

public class Fængsel extends AbstractFelter {

	

	//Konstruktør kan laves
	public Fængsel(int feltnr, GUI gui){
		super(feltnr, gui);
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
	
	public void setIFængsel(Spiller spiller){
		spiller.setPlacering(6);
	}

	@Override
	public void landOnField(Spiller spiller) {
		gui.showMessage(toString());
		setIFængsel(spiller);
		spiller.setFængsel(true);
	}
	
	
}
