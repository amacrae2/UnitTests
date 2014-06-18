// StringCodeTest
// Some test code is provided for the early HW1 problems,
// and much is left for you to add.

package assign1;

import static org.junit.Assert.*;
import org.junit.Test;

public class StringCodeTest {
	//
	// blowup
	//
	@Test
	public void testBlowup1() {
		// basic cases
		assertEquals("xxaaaabb", StringCode.blowup("xx3abb"));
		assertEquals("xxxZZZZ", StringCode.blowup("2x3Z"));
	}
	
	@Test
	public void testBlowup2() {
		// things with digits
		
		// digit at end
		assertEquals("axxx", StringCode.blowup("a2x3"));
		
		// digits next to each other
		assertEquals("a33111", StringCode.blowup("a231"));
		
		// try a 0
		assertEquals("aabb", StringCode.blowup("aa0bb"));
	}
	
	@Test
	public void testBlowup3() {
		// weird chars, empty string
		assertEquals("AB&&,- ab", StringCode.blowup("AB&&,- ab"));
		assertEquals("", StringCode.blowup(""));
		
		// string with only digits
		assertEquals("", StringCode.blowup("2"));
		assertEquals("33", StringCode.blowup("23"));
	}
	
	
	//
	// maxRun
	//
	@Test
	public void testRun1() {
		assertEquals(2, StringCode.maxRun("hoopla"));
		assertEquals(3, StringCode.maxRun("hoopllla"));
	}
	
	@Test
	public void testRun2() {
		assertEquals(3, StringCode.maxRun("abbcccddbbbxx"));
		assertEquals(0, StringCode.maxRun(""));
		assertEquals(3, StringCode.maxRun("hhhooppoo"));
	}
	
	@Test
	public void testRun3() {
		// "evolve" technique -- make a series of test cases
		// where each is change from the one above.
		assertEquals(1, StringCode.maxRun("123"));
		assertEquals(2, StringCode.maxRun("1223"));
		assertEquals(2, StringCode.maxRun("112233"));
		assertEquals(3, StringCode.maxRun("1112233"));
	}

	//
	// stringIntersect
	//
	@Test
	public void testIntersect1() {
		assertEquals(true, StringCode.stringIntersect("hoopla", "hoop", 1));
		assertEquals(true, StringCode.stringIntersect("hoopla", "hoop", 4));
		assertEquals(false, StringCode.stringIntersect("hoopla", "hoop", 5));
		assertEquals(true, StringCode.stringIntersect("oopla", "hoop", 3));
		assertEquals(true, StringCode.stringIntersect("hoopla", "hoo", 3));
		assertEquals(false, StringCode.stringIntersect("oopla", "hoop", 4));
		assertEquals(false, StringCode.stringIntersect("hoopla", "hoo", 4));
	}
	
	@Test
	public void testIntersect2() {
		assertEquals(false, StringCode.stringIntersect("win", "lose", 1));
		assertEquals(false, StringCode.stringIntersect("", "", 1));
		assertEquals(true, StringCode.stringIntersect("win", "almost won", 1));
		assertEquals(false, StringCode.stringIntersect("win", "almost won", 2));
	}
	
	@Test
	public void testIntersect3() {
		assertEquals(true, StringCode.stringIntersect("check space", "l l", 1));
		assertEquals(true, StringCode.stringIntersect("h00pla", "h00p", 4));
		assertEquals(true, StringCode.stringIntersect("AB&&,- ab", "AB&&,- ab", 9));
		assertEquals(false, StringCode.stringIntersect("AB&&,- ab", "AB&&,.- ab", 9));
		assertEquals(false, StringCode.stringIntersect("AB&&,- ab", "AB", 3));

	}
	
}
