package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Aktivbeholdning;
import nogetAndet.Taber;
import nogetAndet.Vinder;
import entity.Spiller;

public class TestCase {
	
	Taber taberTest;
	Aktivbeholdning beholdningTest;
	Vinder vinderTest;

	@Before
	public void setUp() throws Exception {
		beholdningTest = new Aktivbeholdning(100);
		taberTest = new Taber();
		//vinderTest = new 
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
//	public int testVinder; {
//		vinderTest.testHvemVinder (Spiller.class);
//		int actual = vinderTest.
//		int expected = 110;
//		assertEquals(actual, expected);
	
	
	
	}
		
	


		
	


