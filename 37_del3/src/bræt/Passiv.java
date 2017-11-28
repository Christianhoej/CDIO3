package bræt;

import java.awt.Color;

import gui_fields.GUI_Field;
import gui_fields.GUI_Jail;
import gui_fields.GUI_Refuge;

public class Passiv extends AbstractFelter{
	private String feltNavn;
	private int feltnr;
	//private GUI_Field[] felter;

	public Passiv (int feltnr) {
		super(feltnr);
		switch(feltnr){
		case 6: feltNavn = "på besøg"; break;
		case 12: feltNavn = "gratis parkering"; break;
		}
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

	@Override
	public String toString(){
		if(feltNavn.equals("på besøg"))
			return "Du er bare " + feltNavn;
		else
			return feltNavn + ", du behøver ikke gøre noget, bare snup dig en pause";
	}
}
