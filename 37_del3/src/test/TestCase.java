package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Aktivbeholdning;
import entity.Spiller;
import nogetAndet.Taber;
import nogetAndet.Vinder;

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
		beholdningTest.addLikvideMidler(-101);
		int actual = beholdningTest.getLikvideMidler();
		int expected = -1;
		assertEquals(actual, expected);
	}
	
	
	
	/**Test af hatTabt metoden.
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

//	@Test
	public int testVinder; {
		//Spiller test[];
		Spiller spiller1 = new Spiller("Ahad") ;
		Spiller spiller2 = new Spiller("Janus");
		spiller1.ændrLikvideMidler(20);
		spiller2.ændrLikvideMidler(21);
		vinderTest.testHvemVinder(new Spiller[] {spiller1, spiller2});
		Spiller[] actual = vinderTest.testHvemVinder();
		String expected = "Janus";
		assertEquals(actual, expected);
	}
	
	
	
	}
		
	


		
	


