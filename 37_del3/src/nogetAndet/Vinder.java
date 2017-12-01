/** Klassen vinder bliver aktiveret når en spiller har tabt.
 * Klassen har metoder som finder spillets vinder.
 */
package nogetAndet;

import entity.Spiller;

public class Vinder {
	private String vindere;
	private int vinderNrTotalBeholdning;
	private int størsteLikvideBeholdning = -1;


	
  /**
	 * Metoden tester spillernes likvideBeholdning. Spilleren med den største beholdning vinder.
	 * @param spillerArray Array af spillere, fra 2-4
	 * @return Returnerer spiller nummeret fra arrayet, på den spiller der vinder.
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
					vinderNr = (i+1) + " ";
					vinderNrTotalBeholdning = tempAktiverTotal;
			  }
		else if(tempAktiverTotal == vinderNrTotalBeholdning)
					vindere += " og " + (i+1);
    }


		else {
			
		}
		}
		return "spiller(nr) " + vindere + " har vundet";