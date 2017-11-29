package test;

import bræt.Bræt;
import entity.Spiller;
import gui_fields.GUI_Player;
import gui_main.GUI;
import nogetAndet.Taber;
import nogetAndet.Vinder;

public class Spil {

	public Spil() {

	}
	public static void main(String[]args) {
		//Her bør den del der skriver en fil laves.


		Bræt b = new Bræt();		
		GUI gui = new GUI(b.lavBræt());

		String antal = gui.getUserSelection("Hvor mange spillere skal i være?", "2","3","4");
		int antalSpillere = Integer.parseInt(antal);

		//Oprettelse af spillere på brættet
		GUI_Player[] s = new GUI_Player[antalSpillere];
		String [] navn = new String[antalSpillere];
		Spiller[]spillerArray = new Spiller[antalSpillere];
		Taber taber = new Taber();
		
		for (int i=0; i<s.length; i++) {
			navn [i] = gui.getUserString("Indtast spiller " + (i+1) + "s navn");
			s[i] = new GUI_Player(navn[i], 20);
			gui.addPlayer(s[i]);
			Spiller spiller = new Spiller(s[i].getName());
			spillerArray[i] = spiller; //Gemmer en tilsvarende "Spiller" i spillerArrayet


			switch(antalSpillere) {
			case 2:
				spillerArray[i].ændrLikvideMidler(20);//Kan ikke huske hvor mange penge de skal have alt efter hvor mange spillere de er.
				break;
			case 3:
				spillerArray[i].ændrLikvideMidler(18);

				break;
			case 4:
				spillerArray[i].ændrLikvideMidler(16);
				break;
			}
		}

		taber.setTaber(false);
		while(taber.isTaber() == false) {
			for(int i = 0; i < spillerArray.length; i++) {

				//Hvis spiller er i fængsel
				if(spillerArray[i].isFængsel()){
					if(spillerArray[i].getFrikort()){
						spillerArray[i].setFrikort(false);
						spillerArray[i].setFængsel(false);
					}
					else{
						spillerArray[i].ændrLikvideMidler(-1);
						spillerArray[i].setFængsel(false);
					}
					taber.harTabt(spillerArray[i].getLikvideMidler());
				}
				else{
					int terningeVærdi = spillerArray[i].kastTerning();
					System.out.println(spillerArray[i].getNavn() + "Slog " + terningeVærdi);
					//Land on field -> something happens
					//Spillerens beholdning opdateres
					//Testes om den givne spiller har tabt

				}

			}
		}
		Vinder vinder = new Vinder();
		vinder.testHvemVinder(spillerArray);
		//Jeg skal lige tjekke 
	}

}
