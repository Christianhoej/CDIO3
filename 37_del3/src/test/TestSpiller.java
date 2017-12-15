package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Spiller;

public class TestSpiller {

	Spiller spiller;
	
	@Before
	public void setUp() throws Exception {
		spiller = new Spiller("Mads");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNavn() {
		String actual = spiller.getNavn();
		String expected = "Mads";
		assertTrue(actual.equals(expected));
	}
	
	
	@Test
	public void testLivkid() {
		spiller.ændrLikvideMidler(10);
		int actual = spiller.getLikvideMidler();
		int expected = 10;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testAktiver() {
		spiller.ændrAnlægsaktiverVærdi(10);
		int actual = spiller.getAnlægsaktiver();
		int expected = 10;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testKøbSkøde() {
		spiller.tilførSkøde(2, 10);
		int actual = spiller.getAnlægsaktiver();
		int expected = 10;
		assertEquals(actual, expected);
		actual = spiller.getLikvideMidler();
		expected = -10;
		assertEquals(actual, expected);
		
		boolean actual2 = spiller.ejerEjendom(2);
		boolean expected2 = true; 
		assertEquals(actual2,expected2);
		
		boolean actual3 = spiller.ejerEjendom(1);
		boolean expected3 = false; 
		assertEquals(actual3,expected3);
	}
	
	@Test
	public void testPlacering(){
		spiller.setPlacering(23);
		spiller.opdaterPlacering(6);
		int actual = spiller.getPlacering();
		int expected = 6;
		assertEquals(actual,expected);
	}
	
	@Test
	public void testGetSet() {
		
	}

}
