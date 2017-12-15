package bræt;

import entity.Spiller; 
import gui_main.GUI;


public abstract class  AbstractFelter {

	protected int feltnr;
	protected GUI gui;


	public AbstractFelter(int feltnr, GUI gui){
		this.feltnr = feltnr;
		this.gui = gui;
	} 
	
	public abstract String toString();
	
	
	public abstract void landOnField(Spiller spiller);
}
