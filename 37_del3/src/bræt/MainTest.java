package bræt;

import gui_fields.GUI_Player;
import gui_main.GUI;

public class MainTest {

	public static void main(String[] args) {
	
		Bræt b = new Bræt();		
		GUI gui = new GUI(b.lavBræt());
		
		String antal = gui.getUserSelection("Hvor mange spillere skal i være?", "2","3","4");
		int antalSpillere = Integer.parseInt(antal);
		
		//Oprettelse af spillere på brættet
		GUI_Player[] s = new GUI_Player[antalSpillere];
		String [] navn = new String[antalSpillere]; 
		for (int i=0; i<s.length; i++) {
			navn [i] = gui.getUserString("Indtast spiller " + (i+1) + "s navn");
			s[i] = new GUI_Player(navn[i], 20);
			gui.addPlayer(s[i]);
		}
		
//		//Tilføjer spiller til brættet
//		gui.addPlayer(p);
//		gui.addPlayer(p2);
//		gui.addPlayer(p3);
//		gui.addPlayer(p4);
		
		
		
	}

}
