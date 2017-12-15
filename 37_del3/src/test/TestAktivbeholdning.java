package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Aktivbeholdning;


public class TestAktivbeholdning {

	Aktivbeholdning konto;
	
	@Before
	public void setUp() throws Exception {
		konto = new Aktivbeholdning(0);
	}

	@After
	public void tearDown() throws Exception {
	}

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
	
	

}
