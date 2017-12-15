package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Taber;


public class TestTaber {
	
	Taber taber;
	
	@Before
	public void setUp() throws Exception {
		taber = new Taber();
	}

	@After
	public void tearDown() throws Exception {
	}

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

}
