package test;

import java.awt.Color;

import bræt.Bræt;
import entity.Spiller;
import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
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
		b.samlFelter(gui);
		String antal = gui.getUserSelection("Hvor mange spillere skal i være?", "2","3","4");
		int antalSpillere = Integer.parseInt(antal);

		//Oprettelse af spillere på brættet
		GUI_Player[] s = new GUI_Player[antalSpillere];
		GUI_Car[] car = new GUI_Car[antalSpillere];
		String [] navn = new String[antalSpillere];
		Color [] farve = {Color.green, Color.blue, Color.red, Color.black};
		Spiller[] spiller = new Spiller[antalSpillere];
		Taber taber = new Taber();
		
		for (int i=0; i<s.length; i++) {
			navn [i] = gui.getUserString("Indtast spiller " + (i+1) + "s navn");
			car[i]= new GUI_Car(farve[i], farve[i], GUI_Car.Type.CAR, GUI_Car.Pattern.HORIZONTAL_GRADIANT);
			
			switch(antalSpillere) {
			case 2:
				s[i] = new GUI_Player(navn[i], 20, car[i]);
				break;
			case 3:
				s[i] = new GUI_Player(navn[i], 18, car[i]);

				break;
			case 4:
				s[i] = new GUI_Player(navn[i], 16, car[i]);
				break;
			}
			gui.addPlayer(s[i]);
			gui.getFields()[0].setCar(s[i], true);
			spiller[i] = new Spiller(s[i].getName());
			spiller[i].ændrLikvideMidler(s[i].getBalance());
		}

		
		taber.setTaber(false);
		while(!taber.isTaber()) {
			for(int i = 0; i < s.length; i++) {

				//Hvis spiller er i fængsel
				if(spiller[i].isFængsel()){
					if(spiller[i].getFrikort()){
						spiller[i].setFrikort(false);
					}
					else{
						spiller[i].ændrLikvideMidler(-1);
					}
					spiller[i].setFængsel(false);
					spiller[i].setChancekort(false);// Hvad laver vi her?
					taber.harTabt(spiller[i].getLikvideMidler());
				}
				else{
					gui.showMessage("Tryk OK for at slå med terningen");
					
					int terningeVærdi = spiller[i].kastTerning();
					gui.setDie(terningeVærdi);
					gui.showMessage(spiller[i].getNavn() + " slog " + terningeVærdi);
					int forrigePlacering = spiller[i].getPlacering();
					gui.getFields()[spiller[i].getPlacering()].setCar(s[i], false);
					spiller[i].opdaterPlacering(terningeVærdi);// Opdaterer placering på spilleplade
					gui.getFields()[spiller[i].getPlacering()].setCar(s[i], true);
					
					
					int felt = spiller[i].getPlacering();
					
					b.getSamlFelter()[felt].landOnField(spiller[i]);
					for(int j =0; j<s.length;j++){
						s[j].setBalance(spiller[j].getLikvideMidler());
					}
					if(spiller[i].getPlacering() < forrigePlacering){
						spiller[i].ændrLikvideMidler(2);
						s[i].setBalance(spiller[i].getLikvideMidler());
					}
					
					
//					if(felt != spiller[i].getPlacering()){
//						b.samlFelter()[spiller[i].getPlacering()].landOnField(spiller[i]);
//					}
					taber.harTabt(spiller[i].getLikvideMidler());
					
					
					
					//Land on field -> something happens
					//Spillerens beholdning opdateres
					//Testes om den givne spiller har tabt

				}

			}
		}
		Vinder vinder = new Vinder();
		vinder.testHvemVinder(spiller);
		//Jeg skal lige tjekke 
	}
	
	

}
