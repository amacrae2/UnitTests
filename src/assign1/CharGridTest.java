// Test cases for CharGrid -- a few basic tests are provided.
package assign1;

import static org.junit.Assert.*;
import org.junit.Test;

public class CharGridTest {
	
	//
	// charArea
	//
	
	@Test
	public void testCharArea1() {
		char[][] grid = new char[][] {
				{'a', 'y', ' '},
				{'x', 'a', 'z'},
			};
		
		
		CharGrid cg = new CharGrid(grid);
				
		assertEquals(4, cg.charArea('a'));
		assertEquals(1, cg.charArea('z'));
	}
	
	
	@Test
	public void testCharArea2() {
		char[][] grid = new char[][] {
				{'c', 'a', ' '},
				{'b', ' ', 'b'},
				{' ', ' ', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(6, cg.charArea('a'));
		assertEquals(3, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
	}
	
	@Test
	public void testCharArea3() {
		char[][] grid = new char[][] {
				{'c', 'a', ' ', '+'},
				{'b', '-', 'b', ','},
				{' ', ' ', 'a', 'c'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(6, cg.charArea('a'));
		assertEquals(1, cg.charArea('-'));
		assertEquals(12, cg.charArea('c'));
		assertEquals(9, cg.charArea(' '));
		assertEquals(0, cg.charArea('d'));
	}
	
	@Test
	public void testCharArea4() {
		char[][] grid = new char[][] {
				{'c', 'a', ' ', 'c'},
				{'b', '-', 'b', 'c'},
				{'c', ' ', 'a', 'a'},
				{'c', ' ', 'b', 'c'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(16, cg.charArea('c'));
	}
	
	@Test
	public void testCharArea5() {
		char[][] grid = new char[][] {
				{'a', 'a', ' ', 'c'},
				{'b', '-', 'c', 'c'},
				{'a', ' ', 'a', 'c'},
				{'a', ' ', 'b', 'c'},
				{'a', 'a', 'd', 'd'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(8, cg.charArea('c'));
		assertEquals(15, cg.charArea('a'));
		assertEquals(9, cg.charArea('b'));
		assertEquals(8, cg.charArea(' '));
	}
	
	//
	// countPlus
	//
	
	@Test
	public void testCountPlus1() {
		char[][] grid = new char[][] {
				{'a', 'a', 'a', 'c'},
				{'a', 'a', 'c', 'c'},
				{'a', 'a', 'b', 'c'},
				{'a', 'b', 'b', 'b'},
				{'a', 'a', 'b', 'b'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(1, cg.countPlus());
	}
	
	@Test
	public void testCountPlus2() {
		char[][] grid = new char[][] {
				{'a', 'a', 'a', 'c'},
				{'a', 'a', 'a', 'c'},
				{'a', 'a', 'b', 'c'},
				{'a', 'b', 'b', 'b'},
				{'a', 'a', 'b', 'b'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(2, cg.countPlus());
	}
	
	@Test
	public void testCountPlus3() {
		char[][] grid = new char[][] {
				{'a', 'a', 'a', 'c'},
				{'a', 'a', 'a', 'a'},
				{'a', 'a', 'b', 'c'},
				{'a', 'b', 'b', 'b'},
				{'a', 'a', 'b', 'b'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(1, cg.countPlus());
	}
	
	@Test
	public void testCountPlus4() {
		char[][] grid = new char[][] {
				{'a', 'x', 'a', 'c'},
				{'a', 'x', 'a', 'c'},
				{'x', 'x', 'x', 'x'},
				{'a', 'x', 'b', 'b'},
				{'a', 'x', 'b', 'b'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(0, cg.countPlus());
	}
	
	@Test
	public void testCountPlus5() {
		char[][] grid = new char[][] {
				{'a', 'a', 'x', 'x', 'c'},
				{'a', 'a', 'x', 'x', 'x'},
				{'x', 'x', 'x', 'x', 'x'},
				{'a', 'a', 'x', 'b', 'b'},
				{'a', 'b', 'x', 'b', 'b'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(2, cg.countPlus());
	}
	
	@Test
	public void testCountPlus6() {
		char[][] grid = new char[][] {};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(0, cg.countPlus());
	}
	
}
