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
				kastTerning(spiller[i], spiller, i, gui);
				int felt = tur(spiller[i], spiller, i, gui);						// Tjekker om spiller har tabt
				if(taber.isTaber()){
					break;
				}
				// Hvis spilleren har trukket et chancekort, og har rykket bilen.
				if(felt != spiller[i].getPlacering() && spiller[i].getPlacering() !=6){ // Hvis spillerens placering ikke er den samme, som før, og spilleren ikke er i fængsel
					tur(spiller[i], spiller, i, gui);
					if(taber.isTaber()){
						break;
					}
				}
			}
		}
		Vinder vinder = new Vinder();
		gui.displayChanceCard((vinder.testHvemVinder(spiller)));

	}


	public int tur(Spiller spiller, Spiller[] sp, int i, GUI gui){		
		int felt = spiller.getPlacering();									// Gemmer nuværende placering
		landOnField(spiller);		 										// Bruger logikken fra et felt
		gui.getFields()[felt].setCar(s[i], false);								// Fjerner bilen fra daværende placering
		gui.getFields()[spiller.getPlacering()].setCar(s[i], true);			// Sætter bilen på nye placering
		if(!spiller.isFængsel()){
			spiller.PasserStart(felt);
		}
		tjekFødselsdag(spiller, sp);
		setGUIBalance(s, sp);
		taber.harTabt(spiller.getLikvideMidler());
		return felt;
	}
	
	
	
	public void kastTerning(Spiller spiller, Spiller[] sp, int i, GUI gui){
		
		gui.showMessage("Tryk OK for at slå med terningen");
		//int terningVærdi = spiller[i].kastTerning();
		int terningVærdi = 3;// Kaster terningen
		gui.setDie(terningVærdi);												// Viser terningen på pladen

		int forrigePlacering = spiller.getPlacering();						// Gemmer forrige placering
		gui.getFields()[spiller.getPlacering()].setCar(s[i], false);			// Fjerner spillerens bil fra placering
		spiller.opdaterPlacering(terningVærdi);								// Opdaterer placering
		gui.getFields()[spiller.getPlacering()].setCar(s[i], true);			// Sætter bilen på nye placering
		spiller.PasserStart(forrigePlacering);								// Hvis spilleren har passeret start, modtager spilleren 2M
		setGUIBalance(s, sp);	
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
			sp.ændrLikvideMidler(spiller.length-1);
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

