package assign1;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.*;

public class AppearancesTest {
	// utility -- converts a string to a list with one
	// elem for each char.
	private List<String> stringToList(String s) {
		List<String> list = new ArrayList<String>();
		for (int i=0; i<s.length(); i++) {
			list.add(String.valueOf(s.charAt(i)));
			// note: String.valueOf() converts lots of things to string form
		}
		return list;
	}
	
	@Test
	public void testSameCount1() {
		List<String> a = stringToList("abbccc");
		List<String> b = stringToList("cccbba");
		List<String> c = stringToList("");
		assertEquals(3, Appearances.sameCount(a, b));
		assertEquals(0, Appearances.sameCount(a, c));
	}
	
	@Test
	public void testSameCount2() {
		// basic List<Integer> cases
		List<Integer> a = Arrays.asList(1, 2, 3, 1, 2, 3, 5);
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 9, 9, 1)));
		assertEquals(2, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1)));
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1, 1)));
	}
	
	@Test
	public void testSameCount3() {
		HashSet<Integer> a = new HashSet<Integer>(Arrays.asList(1,2,3,4,6,7,8));
		HashSet<Integer> b = new HashSet<Integer>();
		assertEquals(0, Appearances.sameCount(a, Arrays.asList(1, 9, 9, 1)));
		assertEquals(2, Appearances.sameCount(a, Arrays.asList(1, 2, 3, 1)));
		assertEquals(0, Appearances.sameCount(a, b));
	}
	
	@Test
	public void testSameCount4() {
		Stack<Integer> a = new Stack<Integer>();
		a.add(1);
		a.add(2);
		a.add(1);
		Stack<Integer> b = new Stack<Integer>();
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 9, 9, 1)));
		assertEquals(2, Appearances.sameCount(a, Arrays.asList(1, 2, 3, 1)));
		assertEquals(0, Appearances.sameCount(a, b));
	}
	
	@Test
	public void testSameCount5() {
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		assertEquals(0, Appearances.sameCount(a, Arrays.asList(1, 9, 9, 1)));
		assertEquals(0, Appearances.sameCount(a, b));
	}
	
}
