/** Klassen er abstract da metoderne i klassen ikke er færdige
 * De overrides i de nedarvede klasser
 */
package bræt;

import entity.Spiller; 
import gui_main.GUI;


public abstract class  AbstractFelter {
	
	/**Protected, så de er synlige for pakken, og for nedarvede klasser
	 */
	protected int feltnr;
	protected GUI gui;


	public AbstractFelter(int feltnr, GUI gui){
		this.feltnr = feltnr;
		this.gui = gui;
	} 
	
	public abstract String toString();
	
	
	public abstract void landOnField(Spiller spiller);
	
	
	
	
}
