package bræt;

import entity.Spiller;
import gui_main.GUI;

/**
 * Start klassen indeholder startfeltets funktion
 * Klassen nedarver fra AbstractFelter
 * @author Gruppe 37
 *
 */

public class Start extends AbstractFelter {

	private final int startbonus = 2;
	private int feltnr;
	
	public Start (int feltnr, GUI gui) {
		super(feltnr, gui); 
	}
	
	@Override
	public String toString(){
		if(feltnr == 0){
			return "Du har landet på start, og modtager en startbonus på " + startbonus + "M";
		}
		else{
			return "Du har passeret start, og modtager en startbonus på " + startbonus + "M";
		}
	}

	@Override
	public void landOnField(Spiller spiller) {
		gui.showMessage(toString());
	}
}
