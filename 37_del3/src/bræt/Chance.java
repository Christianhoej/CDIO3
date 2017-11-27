package bræt;

public class Chance extends AbstractFelter {

	private Chancekort chance;
	//private int feltnr;
	private String chanceBeskrivelse;
	private int arr[][];
	
	
	//Konstruktør
	public Chance(int feltnr){
		super(feltnr);
		chance.blandKort();
		
	}
	
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
	
	/*
	 */
	public void setChanceHandling(){
		arr = new int[12][];
		arr[2] = new int[4];
		switch (chanceBeskrivelse.split("#")[0]){
		case "Chance1": arr[0][0] = 1; break;
		case "Chance2": arr[8][0] = 0; break;
		case "Chance3": arr[1][0] = 5; break;
		case "Chance4": arr[2][0] = 16;
						arr[2][1] = 17; 
						arr[7][0] = 1; break;
		case "Chance5": arr[1][0] = 1;
						arr[7][0] = 1; break;
		case "Chance6": arr[0][0] = 2; break;
		case "Chance7": arr[4][0] = 2; break;
		case "Chance8": arr[2][0] = 16;
						arr[2][1] = 17; 
						arr[2][2] = 19;
						arr[2][3] = 20;
						arr[7][0] = 1; break;
		case "Chance9": arr[2][0] = 4;
						arr[2][1] = 5;
						arr[7][0] = 1; break;
		case "Chance10":arr[10][0] = 1; break;
		case "Chance11":arr[8][0] = 23; break;
		case "Chance12":arr[0][0] = 3; break;
		case "Chance13":arr[0][0] = 4; break;
		case "Chance14":arr[11][0] = 1; break;
		case "Chance15":arr[2][0] = 7;
						arr[2][1] = 8; 
						arr[2][2] = 22;
						arr[2][3] = 23;
						arr[7][0] = 1; break;
		case "Chance16":arr[3][0] = 2; break;
		case "Chance17":arr[2][0] = 13;
						arr[2][1] = 14; 
						arr[7][0] = 1; break;
		case "Chance18":arr[8][0] = 10;
						arr[7][0] = 1; break;
		case "Chance19":arr[2][0] = 4;
						arr[2][1] = 5; 
						arr[2][2] = 13;
						arr[2][3] = 14;
						arr[7][0] = 1; break;
		case "Chance20":arr[2][0] = 1;
						arr[2][1] = 2; 
						arr[2][2] = 10;
						arr[2][3] = 11;
						arr[7][0] = 1; break;
		}	
	}
	
	public int[][] getChanceHandling(){
		return arr;
	}
	
	
	
}
