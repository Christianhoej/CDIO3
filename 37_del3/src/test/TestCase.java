package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Aktivbeholdning;
import nogetAndet.Taber;

public class TestCase {
	
	Taber taberTest;
	Aktivbeholdning beholdningTest;

	@Before
	public void setUp() throws Exception {
		beholdningTest = new Aktivbeholdning(100);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddLikvidemidler() {
		beholdningTest.addLikvideMidler(10);
		int actual = beholdningTest.getLikvideMidler();
		int expected = 110;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testTaber() {
		taberTest.harTabt(10);
		boolean actual = taberTest.isTaber()
		boolean expected = false;
		assertEquals(actual, expected);
	}
		
	}

Te tetsttetWEUILBG.KAHBGA 
		
	


