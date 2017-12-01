package test;

import java.awt.Color;

import bræt.Bræt;
import entity.Spiller;
import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.GUI;
import nogetAndet.Taber;
import nogetAndet.Vinder;

public class Spil {

	public Spil() {

	}
	public static void main(String[] args) {
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
			navn[i] = gui.getUserString("Indtast spiller " + (i+1) + "s navn");
			if(navn[i].equals("")){
				navn[i] = "Spiller " + (i+1);
			}
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
			spiller[i].setFarve(farve[i]);
			spiller[i].ændrLikvideMidler(s[i].getBalance());
		}


		taber.setTaber(false);
		while(!taber.isTaber()) {
			for(int i = 0; i < s.length; i++) {
				if(spiller[i].isFængsel()){											// Hvis spiller er i fængsel
					if(spiller[i].getFrikort()){									// Hvis spiller har get out of jail free kort, bruges det
						spiller[i].setFrikort(false);								
					}
					else{
						spiller[i].ændrLikvideMidler(-1);							// Ellers betaler spiller 1M for at komme ud
					}
					spiller[i].setFængsel(false);									// Spiller er ikke i fængsel længere
					//spiller[i].setChancekort(false);// Hvad laver vi her?
					taber.harTabt(spiller[i].getLikvideMidler());					// Tjekker om spiller har tabt.
					if(taber.isTaber())
						break;
				}

				gui.showMessage("Tryk OK for at slå med terningen");

//				int terningeVærdi = spiller[i].kastTerning();						// Kaster terningen
				int terningeVærdi = 3;
				
				gui.setDie(terningeVærdi);											// Viser terningen på pladen

				//gui.showMessage(spiller[i].getNavn() + " slog " + terningeVærdi);

				int forrigePlacering = spiller[i].getPlacering();					// Gemmer forrige placering
				gui.getFields()[spiller[i].getPlacering()].setCar(s[i], false);		// Fjerner spillerens bil fra placering
				spiller[i].opdaterPlacering(terningeVærdi);							// Opdaterer placering
				gui.getFields()[spiller[i].getPlacering()].setCar(s[i], true);		// Sætter bilen på nye placering


				spiller[i].PasserStart(forrigePlacering);							// Hvis spilleren har passeret start, modtager spilleren 2M
				s[i].setBalance(spiller[i].getLikvideMidler());



				int felt = spiller[i].getPlacering();								// Gemmer nuværende placering
				b.getSamlFelter()[felt].landOnField(spiller[i]);					// Bruger logikken fra et felt
				gui.getFields()[felt].setCar(s[i], false);							// Fjerner bilen fra daværende placering
				gui.getFields()[spiller[i].getPlacering()].setCar(s[i], true);		// Sætter bilen på nye placering
				
				for(int j =0; j<s.length;j++){										// Opdaterer balancen hos alle spillere på spillepladen
					s[j].setBalance(spiller[j].getLikvideMidler());
				}

				taber.harTabt(spiller[i].getLikvideMidler());						// Tjekker om spiller har tabt
			}
		}
		Vinder vinder = new Vinder();
		vinder.testHvemVinder(spiller);
		//Jeg skal lige tjekke 
	}



}

