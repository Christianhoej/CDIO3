/** Chance klassen nedarver atributter fra AbstracFelter Klassen.
 * Chance klassen udfører de forskellige chancekorts handlinger, og udskriver chancekortene på Gui'en
 */
package bræt;

import entity.Spiller; 
import gui_main.GUI;

public class Chance extends AbstractFelter {

	private Chancekort chance = new Chancekort();
	private String chanceBeskrivelse;

	/**Konstruktøren tager feltnr og giu .............
	 * 
	 * @param feltnr
	 * @param gui
	 */
	public Chance(int feltnr, GUI gui){
		super(feltnr, gui);
		//		chance.blandKort();
	}

	//	@Override
	//	public void opretFelt(){
	//		felter[feltnr] = new GUI_Chance();
	//	}

	@Override
	public String toString(){
		return "Du har landet på Chancen, tryk OK for at trække et kort.";
	}

	public void setChancekort(){
		chanceBeskrivelse = chance.traekKort();
	}

	public String getChancekort(){
		return chanceBeskrivelse.split("#")[1];
	}

	@Override
	public void landOnField(Spiller spiller) {


		String felt;

		gui.showMessage(toString());


		setChancekort(); 
		boolean nytKort = false;
		while(nytKort == false){
			nytKort = false;

			switch (chanceBeskrivelse.split("#")[0]){
			
			case "Chance1": 
				gui.setChanceCard(getChancekort());
				gui.displayChanceCard();
				gui.showMessage("");
				spiller.setPlacering(0);
				return;
			case "Chance2": 
				gui.setChanceCard(getChancekort());
				gui.displayChanceCard();
				felt = gui.getUserSelection("Hvor mange felter vil du rykke frem?", "0","1","2","3","4","5");
				spiller.opdaterPlacering(Integer.parseInt(felt));
				return;
			case "Chance3": 
				gui.setChanceCard(getChancekort());
				gui.displayChanceCard();
				felt = gui.getUserSelection("Hvilket orange felt vil du rykke frem til?", "16", "17");
				spiller.setGratis(true);
				spiller.setPlacering(Integer.parseInt(felt));
				return;
			case "Chance4": 
				gui.setChanceCard(getChancekort());
				gui.displayChanceCard();
				felt = gui.getUserButtonPressed("Vil du rykke et felt frem eller tage et chancekort?", "Ryk et felt frem", "Tag chancekort");
				if(felt.equals("Ryk et felt frem")){
					spiller.setPlacering(spiller.getPlacering()+1);
					return;
				}
				else{
					setChancekort();
					nytKort = true;
					break;
				}
			case "Chance5": 
				gui.setChanceCard(getChancekort());
				gui.displayChanceCard();
				gui.showMessage("Du skal betale 2M til banken");
				spiller.ændrLikvideMidler(-2);
				return;
			case "Chance6": 
				gui.setChanceCard(getChancekort());
				gui.displayChanceCard();
				felt = gui.getUserSelection("Hvilket orange eller grønt felt vil du rykke frem til?", "16", "17", "19", "20");
				spiller.setGratis(true);
				spiller.setPlacering(Integer.parseInt(felt));
				return;
			case "Chance7": 
				gui.setChanceCard(getChancekort());
				gui.displayChanceCard();
				felt = gui.getUserSelection("Hvilket lyseblåt felt vil du rykke frem til?", "4", "5");
				spiller.setGratis(true);
				spiller.setPlacering(Integer.parseInt(felt));
				return;
			case "Chance8":
				gui.setChanceCard(getChancekort());
				gui.displayChanceCard();
				gui.showMessage("Du har fået et fængsel-frikort");
				spiller.setFrikort(true);
				return;
			case "Chance9":
				gui.setChanceCard(getChancekort());
				gui.displayChanceCard();
				gui.showMessage("Ryk frem til Strandpromenaden");
				spiller.setPlacering(23);
				return;
			
			case "Chance10":
				gui.setChanceCard(getChancekort());
				gui.displayChanceCard();
				gui.showMessage("");
				spiller.setFødselsdag(true);
				return;
			case "Chance11":
				gui.setChanceCard(getChancekort());
				gui.displayChanceCard();
				felt = gui.getUserSelection("Hvilket lyseblåt felt vil du rykke frem til?", "7", "8", "22", "23");
				spiller.setGratis(true);
				spiller.setPlacering(Integer.parseInt(felt));
				return;
			case "Chance12":
				gui.setChanceCard(getChancekort());
				gui.displayChanceCard();
				gui.showMessage("");
				spiller.ændrLikvideMidler(2);
				return;
			case "Chance13":
				gui.setChanceCard(getChancekort());
				gui.displayChanceCard();
				felt = gui.getUserSelection("Hvilket lyseblåt felt vil du rykke frem til?", "13", "14");
				spiller.setGratis(true);
				spiller.setPlacering(Integer.parseInt(felt));
				return;
			case "Chance14":
				gui.setChanceCard(getChancekort());
				gui.displayChanceCard();
				gui.showMessage("Ryk frem til Skaterparken");
				spiller.setGratis(true);
				spiller.setPlacering(10);
				return;
			case "Chance15":
				gui.setChanceCard(getChancekort());
				gui.displayChanceCard();
				felt = gui.getUserSelection("Hvilket lyseblåt felt vil du rykke frem til?", "4", "5", "13", "14");
				spiller.setGratis(true);
				spiller.setPlacering(Integer.parseInt(felt));
				return;
			case "Chance16":
				gui.setChanceCard(getChancekort());
				gui.displayChanceCard();
				felt = gui.getUserSelection("Hvilket lyseblåt felt vil du rykke frem til?", "1", "2", "10", "11");
				spiller.setPlacering(Integer.parseInt(felt));
				spiller.setGratis(true);
				return;
//			case "Chance17": 
//				gui.setChanceCard(getChancekort());
//				gui.displayChanceCard();
//				spiller.setGivKortVidere(0); 
//				setChancekort();
//				nytKort = true;
//				break;
//			case "Chance18": 
//				gui.setChanceCard(getChancekort());
//				gui.displayChanceCard();
//				spiller.setGivKortVidere(1); 
//				setChancekort();
//				nytKort = true;
//				break;
//			case "Chance19":
//				gui.setChanceCard(getChancekort());
//				gui.displayChanceCard();
//				spiller.setGivKortVidere(2); 
//				setChancekort();
//				nytKort = true;
//				break;
//			case "Chance20":
//				gui.setChanceCard(getChancekort());
//				gui.displayChanceCard();
//				spiller.setGivKortVidere(3); 
//				setChancekort();
//				nytKort = true;
//				break;
			}
			
			
			
		}	
	}
}
