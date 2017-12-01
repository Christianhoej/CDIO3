/** 
 * 
 */
package entity;

/**
 * Klassen vinder bliver aktiveret, når en spiller har tabt.
 * Klassen har en metode som finder spillets vinder.
 * @author Gruppe 37
 *
 */
public class Vinder {
	private String vindere;
	private int vinderNrTotalBeholdning;
	private int størsteLikvideBeholdning = -1;



	/**
	 * Metoden tester spillernes likvideBeholdning. Spilleren med den største beholdning vinder.
	 * @param spillerArray Array af spillere, fra 2-4
	 * @return en string på med spillernummer/ne af vinder/ne
	 */
	public String testHvemVinder(Spiller[]spillerArray){
		int tempAktiverTotal;
		int tempLikvid; 
		for(int i = 0; i<spillerArray.length; i++) {

			tempLikvid = spillerArray[i].getLikvideMidler();
			tempAktiverTotal = spillerArray[i].getAnlægsaktiver() + spillerArray[i].getLikvideMidler();

			if(tempLikvid>størsteLikvideBeholdning) { //Hvis en likvidbeholdning er større end en anden
				vindere = (i+1) + " ";
				størsteLikvideBeholdning = tempLikvid;
				vinderNrTotalBeholdning = tempAktiverTotal;
			}
			else if(tempLikvid == størsteLikvideBeholdning) { //Hvis to likvide beholdninger er lige store

				tempAktiverTotal = spillerArray[i].getAnlægsaktiver() + spillerArray[i].getLikvideMidler();
				if(tempAktiverTotal > vinderNrTotalBeholdning)
				{
					vindere = (i+1) + " ";
					vinderNrTotalBeholdning = tempAktiverTotal;
				}
				else if(tempAktiverTotal == vinderNrTotalBeholdning)
					vindere += " og " + (i+1);
			}
		}
		return "Spiller " + vindere + "har vundet";
	}
}