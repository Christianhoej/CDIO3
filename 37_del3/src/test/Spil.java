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

	GUI_Player[] s = new GUI_Player[4];
	GUI_Car[] car = new GUI_Car[4];
	String [] navn = new String[4];
	Color [] farve = {Color.blue, Color.red, Color.cyan, Color.orange};
	Spiller[] spiller;
	Taber taber = new Taber();
	Bræt b = new Bræt();		


	public void Start() {

		// Laver spillepladen
		GUI gui = new GUI(b.lavBræt());
		b.samlFelter(gui);

		// Afgører antal spillere
		String antal = gui.getUserSelection("Hvor mange spillere skal i være?", "2","3","4");
		int antalSpillere = Integer.parseInt(antal);
		Spiller[] spiller = new Spiller[antalSpillere];

		// Tilføjer spillerne til spillet
		for (int i=0; i<spiller.length; i++) {
			navn [i] = gui.getUserString("Indtast spiller " + (i+1) + "s navn");
			if(navn[i].equals("")){
				navn[i] = "Spiller " + (i+1);
			}
			car[i]= new GUI_Car(farve[i], farve[i], GUI_Car.Type.CAR, GUI_Car.Pattern.HORIZONTAL_GRADIANT);

			// Afgører startbalancen for spillerne
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

		while(!taber.isTaber()) {
			for(int i = 0; i < spiller.length; i++) {
				tjekFængsel(spiller[i]);
				if(taber.isTaber()){
					break;
				}

				gui.showMessage("Tryk OK for at slå med terningen");

				int terningVærdi = spiller[i].kastTerning();							// Kaster terningen
				gui.setDie(terningVærdi);												// Viser terningen på pladen

				int forrigePlacering = spiller[i].getPlacering();						// Gemmer forrige placering
				gui.getFields()[spiller[i].getPlacering()].setCar(s[i], false);			// Fjerner spillerens bil fra placering
				spiller[i].opdaterPlacering(terningVærdi);								// Opdaterer placering
				gui.getFields()[spiller[i].getPlacering()].setCar(s[i], true);			// Sætter bilen på nye placering


				spiller[i].PasserStart(forrigePlacering);								// Hvis spilleren har passeret start, modtager spilleren 2M
				setGUIBalance(s, spiller);						

				int felt = spiller[i].getPlacering();									// Gemmer nuværende placering
				landOnField(spiller[i]);		 										// Bruger logikken fra et felt
				gui.getFields()[felt].setCar(s[i], false);								// Fjerner bilen fra daværende placering
				gui.getFields()[spiller[i].getPlacering()].setCar(s[i], true);			// Sætter bilen på nye placering
				setGUIBalance(s, spiller);
				spiller[i].PasserStart(felt);

				tjekFødselsdag(spiller[i], spiller);

				// Hvis spilleren har trukket et chancekort, og har rykket bilen.
				if(felt != spiller[i].getPlacering() && spiller[i].getPlacering() !=6){ // Hvis spillerens placering ikke er den samme, som før, og spilleren ikke er i fængsel
					felt = spiller[i].getPlacering();
					landOnField(spiller[i]);											// Bruger logikken fra et felt
					gui.getFields()[felt].setCar(s[i], false);							// Fjerner bilen fra daværende placering
					gui.getFields()[spiller[i].getPlacering()].setCar(s[i], true);		// Sætter bilen på nye placering

					spiller[i].PasserStart(felt);										// Hvis spilleren har passeret start, modtager spilleren 2M

					setGUIBalance(s, spiller);	// Opdaterer balancen hos alle spillere på spillepladen

					taber.harTabt(spiller[i].getLikvideMidler());						// Tjekker om spiller har tabt
					if(taber.isTaber()){
						break;
					}
				}
			}
		}
		Vinder vinder = new Vinder();
		gui.displayChanceCard((vinder.testHvemVinder(spiller)));

	}


	public void tur(Spiller spiller){		

	}

	public void setGUIBalance(GUI_Player[] s, Spiller spiller[]){
		for(int i =0; i<spiller.length; i++){										// Opdaterer balancen hos alle spillere på spillepladen
			s[i].setBalance(spiller[i].getLikvideMidler());
		}

	}



	public void landOnField(Spiller spiller){
		b.getSamlFelter()[spiller.getPlacering()].landOnField(spiller);
	}


	public void tjekFødselsdag(Spiller sp, Spiller[] spiller){
		if(sp.getFødselsdag()){
			sp.ændrLikvideMidler(spiller.length);
			for(int i=0; i<spiller.length; i++){
				if(sp !=spiller[i]){
					spiller[i].ændrLikvideMidler(-1);
				}
			}
			setGUIBalance(s, spiller);
		}

	}

	public void tjekFængsel(Spiller spiller){
		if(spiller.isFængsel()){												// Hvis spiller er i fængsel
			if(spiller.getFrikort()){										// Hvis spiller har get out of jail free kort, bruges det
				spiller.setFrikort(false);								
			}
			else{
				spiller.ændrLikvideMidler(-1);								// Ellers betaler spiller 1M for at komme ud
			}
			spiller.setFængsel(false);										// Spiller er ikke i fængsel længere
			taber.harTabt(spiller.getLikvideMidler());						// Tjekker om spiller har tabt.
		}
	}
}

