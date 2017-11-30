/** Klassen vinder bliver aktiveret når en spiller har tabt.
 * Klassen har metoder som finder spillets vinder.
 */
package nogetAndet;

import entity.Spiller;

public class Vinder {
	private int vinderNr;
	private int vinderNrTotalBeholdning;
	private int størsteLikvideBeholdning = -1;

	private String hvisUafgjort = "Spiller nr: ";

	/**
	 * Metoden tester spillernes likvideBeholdning. Spilleren med den største beholdning vinder.
	 * @param spillerArray Array af spillere, fra 2-4
	 * @return Returnerer spiller nummeret fra arrayet, på den spiller der vinder.
	 */
	public int testHvemVinder(Spiller[]spillerArray){
		int tempAktiverTotal;
		int tempLikvid; 
		for(int i = 0; i<spillerArray.length; i++) {
			
		tempLikvid = spillerArray[i].getLikvideMidler();
		tempAktiverTotal = spillerArray[i].getAnlægsaktiver() + spillerArray[i].getLikvideMidler();

	public int testHvemVinder(Spiller[]spillerArray){
		int[] likvid = new int[spillerArray.length];
		int[] aktiver = new int[spillerArray.length];
		for(int i=0; i<spillerArray.length; i++){
			likvid[i] = spillerArray[i].getLikvideMidler();
			aktiver[i] = spillerArray[i].getAnlægsaktiver();
		}
		int temp;
		int vinder;
		for(int i=1; i<likvid.length;i++){
			if(likvid[i-1] > likvid[i]){
				temp = likvid[i-1];
				vinder = i;
				//likvid[i]=0;
			}
			else if(likvid[i-1]< likvid[i]){
				temp = likvid[i];
				vinder = i;
				//likvid[i-1] = 0;
			}
			else{}
		}
		int count = 0;
		
		for(int i=0; i<likvid.length; i++){
			if(likvid[i] == temp){
				vinder = i;
				count++;
			}
		}
		for(int i=0; i<likvid.length; i++){
			if(count==1){
				
			}
			
		}
		
		
		
		int tempLikvid = spillerArray[0].getLikvideMidler();
		for(int i = 1; i<spillerArray.length; i++){
			if(tempLikvid < spillerArray[i].getLikvideMidler()){
				tempLikvid = spillerArray[i].getLikvideMidler();
			}
			else if(tempLikvid==spillerArray[i].getLikvideMidler()){
				
			}
		}
		
		int tempEjendomme = spillerArray[0].getAnlægsaktiver();
		
		
		for(int i = 0; i<spillerArray.length; i++) {
			

			tempLikvid = spillerArray[i].getLikvideMidler();
			tempAktiverTotal = spillerArray[i].getAnlægsaktiver() + spillerArray[i].getLikvideMidler();


			if(tempLikvid>størsteLikvideBeholdning) { //Hvis en likvidbeholdning er større end en anden
				vinderNr = i;
				størsteLikvideBeholdning = tempLikvid;
				vinderNrTotalBeholdning = tempAktiverTotal;
			}
			else if(tempLikvid == størsteLikvideBeholdning) { //Hvis to likvide beholdninger er lige store

				//tempAktiverTotal = spillerArray[i].getAnlægsaktiver() + spillerArray[i].getLikvideMidler();
				if(tempAktiverTotal > vinderNrTotalBeholdning)
				{
					vinderNr = i;
					vinderNrTotalBeholdning = tempAktiverTotal;
				}
				else if(tempAktiverTotal< vinderNrTotalBeholdning){ 	
				}
				else if(tempAktiverTotal == vinderNrTotalBeholdning && i == 2)//i == 2 gør at else kan bruges hvis der er flere spillere tilbage og de alle tre har lige mange likvide + anlægsaktiver
					hvisUafgjort +=  i ;
				
				else {
					hvisUafgjort = "Alle tre resterende spillere har vundet da de har lige mange likvide midler og ejendomme";
				}

			}
			else {
				//Der bør ikke ske noget med variablene, men bør der ske andet?
			}
		}
		System.out.println(hvisUafgjort);
		return vinderNr;
	}
	/**
	 * Metode kan bruges til at hente String med navne på uafgjort spillere.
	 * @return hvisUafgjort
	 */
	public String getHvisUafgjort() {
		return hvisUafgjort;
	}
}