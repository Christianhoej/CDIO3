package test;

import static org.junit.Assert.assertEquals; 

import org.junit.Before;
import org.junit.Test;
import entity.Aktivbeholdning;
import entity.Spiller;
import entity.Taber;
import entity.Vinder;

public class TestCase {

	Taber taber;
	Aktivbeholdning konto;
	Vinder vinderTest;

	@Before
	public void setUp() throws Exception {
		konto = new Aktivbeholdning(0);
		taber = new Taber();
		vinderTest = new Vinder();
	}
 

	/**Test af addLikvidemidler
	 * addLikvideMidler(int likvideMidler)
	 * Aktivbeholdning(100) - Likvidemidler er sat til 100 på forhånd
	 * Positiv: tilføjer 10 til likvidemidler, expected 110, testen går igennem
	 * Negativ: tilføjer 20 til likvidemidler, expected 110, testen går ikke igennem da actual=120
	 */
	@Test
	public void testLikvid() {
		konto.addLikvideMidler(10);
		int actual = konto.getLikvideMidler();
		int expected = 10;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testAktiver() {
		konto.addAnlægsAktiver(10);
		int actual = konto.getAnlægsAktiver();
		int expected = 10;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testSkøde() {
		konto.købSkøde(4);
		konto.købSkøde(10);
		konto.købSkøde(23);
		int[] actual = konto.getSkøder();
		int[] expected = new int[24];
		for(int i=0; i<expected.length;i++){
			if(i==4)
				expected[i]=i;
			else if(i==10)
				expected[i]=i;
			else if(i==23)
				expected[i]=i;
		}
		for(int i=0; i<actual.length; i++){
			assertEquals(actual[i],expected[i]);
		}
	}


	/**Test af harTabt metoden.
	 * harTabt(beholdningsværdi), 
	 * Positiv: beholdningsværdi sættes til 10, expected false, testen godkendes da spilleren ikke taber
	 * Negativ: beholdningsværdi sættes til -10, expected false, testen fejler da spilleren taber, grundet negativ værdi
	 */
	@Test
	public void testTaber() {
		taber.harTabt(-10);
		boolean actual = taber.isTaber();
		boolean expected = true;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testIkkeTaber() {
		taber.harTabt(10);
		boolean actual = taber.isTaber();
		boolean expected = false;
		assertEquals(actual, expected);
	}


	/**Test af testHvemVinder metoden.
	 * testHvemVinder(Array af spillere) 
	 * Positiv: Likvidemidler sættes til hhv. 20 og 21 for spiller 1 og spiller 2. Testen godtages, da spiller 2 vinder
	 * Negativ: Likvidemidler sættes til hhv. 20 og 21 for spiller 1 og spiller 2. Testen fejler, da spiller 1 vinder
	 */
	@Test
	public void testTestHvemVinder() {
		Spiller spiller1 = new Spiller("Spiller 1") ;
		Spiller spiller2 = new Spiller("Spiller 2");
		spiller1.ændrLikvideMidler(20);
		spiller2.ændrLikvideMidler(21);
		String actual = vinderTest.testHvemVinder(new Spiller[] {spiller1, spiller2});
		String expected = spiller2.getNavn()+" har vundet";
		assertEquals(actual, expected);
	}
	
	@Test
	public void testTestHvemVinder1() {
		Spiller spiller1 = new Spiller("Spiller 1") ;
		Spiller spiller2 = new Spiller("Spiller 2");
		Spiller spiller3 = new Spiller("Spiller 3");
		spiller1.ændrLikvideMidler(21);
		spiller2.ændrLikvideMidler(21);
		spiller3.ændrLikvideMidler(21);
		spiller1.ændrAnlægsaktiverVærdi(20);
		spiller2.ændrAnlægsaktiverVærdi(20);
		spiller3.ændrAnlægsaktiverVærdi(21);
		String actual = vinderTest.testHvemVinder(new Spiller[] {spiller1, spiller2, spiller3});
		String expected = "Spiller 3 har vundet";
		assertEquals(actual, expected);
	}

	@Test
	public void testTestHvemVinder2() {
		Spiller spiller1 = new Spiller("Spiller 1");
		Spiller spiller2 = new Spiller("Spiller 2");
		Spiller spiller3 = new Spiller("Spiller 3");
		Spiller spiller4 = new Spiller("Spiller 4");
		spiller1.ændrLikvideMidler(20);
		spiller2.ændrLikvideMidler(21);
		spiller3.ændrLikvideMidler(21);
		spiller4.ændrLikvideMidler(21);
		String actual = vinderTest.testHvemVinder(new Spiller[] {spiller1, spiller2, spiller3, spiller4});
		String expected = spiller2.getNavn()+ " og 3 og 4 har vundet";
		assertEquals(actual, expected);
	}


}








