package nogetAndet;

import entity.Spiller;

public class Vinder {
	private boolean vinder;
	private int vinderNr;
	private int vinderNrTotalBeholdning;
	private int størsteLikvideBeholdning;
	
	public int testIfVinder(Spiller[]spillerArray){
		for(int i = 0; i<spillerArray.length; i++) {
			int tempLikvid;
		tempLikvid = spillerArray[i].getLikvideMidler();
			
		if(tempLikvid>størsteLikvideBeholdning) {
				vinderNr = i;
				størsteLikvideBeholdning = tempLikvid;
				vinderNrTotalBeholdning = spillerArray[i].getLikvideMidler()+spillerArray[i].getAnlægsaktiver();
		}
		else if(tempLikvid == størsteLikvideBeholdning) {
			int tempAktiverTotal;
			tempAktiverTotal = spillerArray[i].getAnlægsaktiver() + spillerArray[i].getLikvideMidler();
			if(tempAktiverTotal > vinderNrTotalBeholdning)
			{
				vinderNr = i;
				vinderNrTotalBeholdning = tempAktiverTotal;
				
			}
			
		}
		}
				
		return vinderNr;
	}
}
