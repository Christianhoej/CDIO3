package bræt;

import entity.Spiller; 
import gui_main.GUI;



/**
 * Klassen Fængsel nedarver fra AbstractFelter.
 * @author Gruppe 37
 */
public class Fængsel extends AbstractFelter {
	
	public Fængsel(int feltnr, GUI gui){
		super(feltnr, gui);
	}
	/**
	 * toString til udskrivning af besked, når spilleren lander på feltet.
	 */
	@Override
	public String toString(){
		return "Du er blevet taget for at stjæle slik, og skal i fængsel";
	}
	
	public void setIFængsel(Spiller spiller){
		spiller.setPlacering(6);
	}

	/**
	 * landOnFiels indeholder fængselfeltets spil logik
	 * @param Spiller
	 */
	@Override
	public void landOnField(Spiller spiller) {
		gui.showMessage(toString());
		setIFængsel(spiller);
		spiller.setFængsel(true);
	}
	
	
}
