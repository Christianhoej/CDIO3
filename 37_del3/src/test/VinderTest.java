package test;

import entity.Spiller;
import entity.Vinder;

public class VinderTest {

	public static void main(String[] args){
		
		Spiller spiller1 = new Spiller("H");
		spiller1.ændrLikvideMidler(10);
		spiller1.ændrAnlægsaktiverVærdi(10);
		Spiller spiller2 = new Spiller("g");
		spiller2.ændrLikvideMidler(10);
		spiller2.ændrAnlægsaktiverVærdi(10);
		Spiller spiller3 = new Spiller("f");
		spiller3.ændrLikvideMidler(15);
		spiller3.ændrAnlægsaktiverVærdi(15);
		Spiller spiller4 = new Spiller("d");
		spiller4.ændrLikvideMidler(-2);
		spiller4.ændrAnlægsaktiverVærdi(10);
		Spiller[] spiller = new Spiller[]{spiller1,spiller2,spiller3,spiller4};
		Vinder vinder = new Vinder();
		vinder.testHvemVinder(spiller);

		
		
		
	}
}
