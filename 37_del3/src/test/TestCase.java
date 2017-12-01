package test;

import static org.junit.Assert.assertEquals; 

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Aktivbeholdning;
import entity.Spiller;
import entity.Taber;
import entity.Vinder;

public class TestCase {

	Taber taberTest;
	Aktivbeholdning beholdningTest;
	Vinder vinderTest;

	@Before
	public void setUp() throws Exception {
		beholdningTest = new Aktivbeholdning(100);
		taberTest = new Taber();
		vinderTest = new Vinder();
	}

	@After
	public void tearDown() throws Exception {
	}

	/**Test af addLikvidemidler
	 * addLikvideMidler(int likvideMidler)
	 * Aktivbeholdning(100) - Likvidemidler er sat til 100 på forhånd
	 * Positiv: tilføjer 10 til likvidemidler, expected 110, testen går igennem
	 * Negativ: tilføjer 20 til likvidemidler, expected 110, testen går ikke igennem da actual=120
	 */
	@Test
	public void testAddLikvidemidler() {
		beholdningTest.addLikvideMidler(10);
		int actual = beholdningTest.getLikvideMidler();
		int expected = 110;
		assertEquals(actual, expected);
	}

	/**Test af harTabt metoden.
	 * harTabt(beholdningsværdi), 
	 * Positiv: beholdningsværdi sættes til 10, expected false, testen godkendes da spilleren ikke taber
	 * Negativ: beholdningsværdi sættes til -10, expected false, testen fejler da spilleren taber, grundet negativ værdi
	 */
	@Test
	public void testTaber() {
		taberTest.harTabt(10);
		boolean actual = taberTest.isTaber();
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



}








