package bræt;

import java.awt.Color;

import gui_fields.GUI_Field;
import gui_fields.GUI_Start;

public class Start extends AbstractFelter {

	private final int startbonus = 2;
	private int feltnr;
//	private GUI_Field[] felter;
	
	public Start (int feltnr) {
		super(feltnr); 
	}

//	@Override
//	public void opretFelt(){
//		felter[feltnr] = new GUI_Start();
//		felter[feltnr].setTitle("Start");
//		felter[feltnr].setDescription("");
//		felter[feltnr].setSubText("");
//		felter[feltnr].setBackGroundColor(Color.RED);
//	}
	
	
	@Override
	public String toString(){
		return "Du har passeret start, og modtager en startbonus på " + startbonus + "M";
	}
	
	public int getStartBonus(){
		return startbonus;
	}
}
