package bræt;

import entity.Spiller;
import gui_main.GUI;

public class Passiv extends AbstractFelter{
	private String feltNavn;
	private GUI gui;
	//private GUI_Field[] felter;

	public Passiv (int feltnr, GUI gui) {
		super(feltnr, gui);
		switch(feltnr){
		case 6: feltNavn = "på besøg"; break;
		case 12: feltNavn = "gratis parkering"; break;
		}
	}

	@Override
	public String toString(){
		if(feltNavn.equals("på besøg"))
			return "Du er bare " + feltNavn;
		else
			return feltNavn + ", du behøver ikke gøre noget, bare snup dig en pause";
	}


	@Override
	public void landOnField(Spiller spiller) {
		gui.showMessage(toString());
		System.out.println(toString());
	    gui.showMessage(toString());
	}
	
	
	


//	public void opretFelt(){
//		if(feltnr == 6){
//			felter[feltnr] = new GUI_Jail();
//			felter[feltnr].setSubText("På besøg");
//		}
//		else if(feltnr == 12){
//			felter[feltnr] = new GUI_Refuge();
//			felter[feltnr].setDescription("Tag en pause");
//			felter[feltnr].setSubText("Gratis parkering");
//			felter[feltnr].setBackGroundColor(Color.white); //Very light red;
//		}	
//	}
}
