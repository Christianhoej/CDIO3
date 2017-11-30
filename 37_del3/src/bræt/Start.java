package bræt;

import java.awt.Color;

import entity.Spiller;
import gui_fields.GUI_Field;
import gui_fields.GUI_Start;
import gui_main.GUI;

public class Start extends AbstractFelter {

	private final int startbonus = 2;
	private int feltnr;
//	private GUI gui;
//	private GUI_Field[] felter;
	
	public Start (int feltnr, GUI gui) {
		super(feltnr, gui); 
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
		if(feltnr == 0){
			return "Du har landed på start, og modtager en startbonus på " + startbonus + "M";
		}
		else{
			return "Du har passeret start, og modtager en startbonus på " + startbonus + "M";
		}
	}
	
	public int getStartBonus(){
		return startbonus;
	}

	@Override
	public void landOnField(Spiller spiller) {
		gui.showMessage(toString());
	}
}
