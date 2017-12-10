
package bræt;

import entity.Spiller; 
import gui_main.GUI;

/**
 * Passiv klassen bruges til oprettelse af de passive felter på brættet.
 * De passive felter har ingen egenskaber, og ses som "frie" felter.
 * Klassen nedarver fra AbstractFelter
 * @author Gruppe 37
 *
 */

public class Passiv extends AbstractFelter{
	private String feltNavn;

	/**
	 * Konstruktøren angiver passivfelternes lokation på brættet, ud fra feltnr. 
	 * @param feltnr Feltets nummer
	 * @param gui Visualiserer lokationen
	 */
	public Passiv (int feltnr, GUI gui) {
		super(feltnr, gui);
		switch(feltnr){
		case 6: feltNavn = "på besøg"; break;
		case 12: feltNavn = "gratis parkering"; break;
		default:
			break;
		}
	}
	/**
	 * toString til udskrivning af tekst, når en spiller lander enten på "på besøg i fængsel"-feltet
	 * eller gratis parkering feltet.
	 * 
	 * @return String
	 */
	@Override
	public String toString(){
		if(feltNavn.equals("på besøg"))
			return "Du er bare " + feltNavn;
		else
			return feltNavn + ", du behøver ikke gøre noget, bare snup dig en pause";
	}

	/**
	 * Metode som udskriver teksten fra toString, for de passive felter.
	 * 
	 *  @param Spiller
	 */
	@Override
	public void landOnField(Spiller spiller) {
		gui.showMessage(toString());
	}
}
