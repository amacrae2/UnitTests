// TabooTest.java
// Taboo class tests -- nothing provided.
package assign1;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class TabooTest {

	@Test
	public void noFollowTest1() {
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3));
		Taboo<Integer> taboo = new Taboo<Integer>(list);
		
		Set<Integer> a = new HashSet<Integer>(Arrays.asList(2));
		Set<Integer> b = new HashSet<Integer>(Arrays.asList(3));
		Set<Integer> c = new HashSet<Integer>();
		
		assertEquals(a, taboo.noFollow(1));
		assertEquals(b, taboo.noFollow(2));
		assertEquals(c, taboo.noFollow(3));
	}
	
	@Test
	public void noFollowTest2() {
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,1,2,3,1,2,1,2));
		Taboo<Integer> taboo = new Taboo<Integer>(list);
		
		Set<Integer> a = new HashSet<Integer>(Arrays.asList(2));
		Set<Integer> b = new HashSet<Integer>(Arrays.asList(1,3));
		Set<Integer> c = new HashSet<Integer>(Arrays.asList(1));
		
		assertEquals(a, taboo.noFollow(1));
		assertEquals(b, taboo.noFollow(2));
		assertEquals(c, taboo.noFollow(3));
	}
	
	@Test
	public void noFollowTest3() {
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(null,1,2,1,null,2,3,null,2,null,3));
		Taboo<Integer> taboo = new Taboo<Integer>(list);
		
		Set<Integer> a = new HashSet<Integer>(Arrays.asList(2));
		Set<Integer> b = new HashSet<Integer>(Arrays.asList(1,3));
		Set<Integer> c = new HashSet<Integer>();
		
		assertEquals(a, taboo.noFollow(1));
		assertEquals(b, taboo.noFollow(2));
		assertEquals(c, taboo.noFollow(3));
	}
	
	@Test
	public void noFollowTest4() {
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,2,1,null,1,1,1,1,4,1,1,null));
		Taboo<Integer> taboo = new Taboo<Integer>(list);
		
		Set<Integer> a = new HashSet<Integer>(Arrays.asList(1,2,4));
		Set<Integer> b = new HashSet<Integer>(Arrays.asList(1,3));
		Set<Integer> c = new HashSet<Integer>(Arrays.asList(2));
		
		assertEquals(a, taboo.noFollow(1));
		assertEquals(b, taboo.noFollow(2));
		assertEquals(c, taboo.noFollow(3));
	}
	
	@Test
	public void noFollowTest5() {
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("1","2","3","a","1","x",null));
		Taboo<String> taboo = new Taboo<String>(list);
		
		Set<String> a = new HashSet<String>(Arrays.asList("x","2"));
		Set<String> b = new HashSet<String>(Arrays.asList("3"));
		Set<String> c = new HashSet<String>(Arrays.asList("a"));
		
		assertEquals(a, taboo.noFollow("1"));
		assertEquals(b, taboo.noFollow("2"));
		assertEquals(c, taboo.noFollow("3"));
	}
	
	@Test
	public void reduceTest1(){
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3));
		Taboo<Integer> taboo = new Taboo<Integer>(list);
		
		List<Integer> a = new ArrayList<Integer>(Arrays.asList(1,2,3,2,1));
		taboo.reduce(a);
		List<Integer> b = new ArrayList<Integer>(Arrays.asList(1,3,2,1));
		
		assertEquals(a, b);
	}
	
	@Test
	public void reduceTest2(){
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,1,2,3,1,2,1,2));
		Taboo<Integer> taboo = new Taboo<Integer>(list);
		
		List<Integer> a = new ArrayList<Integer>(Arrays.asList(1,2,3,2,1));
		taboo.reduce(a);
		List<Integer> b = new ArrayList<Integer>(Arrays.asList(1,3,2));
		
		assertEquals(a, b);
	}
	
	@Test
	public void reduceTest3(){
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(null,1,2,1,null,2,3,null,2,null,3));
		Taboo<Integer> taboo = new Taboo<Integer>(list);
		
		List<Integer> a = new ArrayList<Integer>(Arrays.asList(1,2,3,2,3));
		taboo.reduce(a);
		List<Integer> b = new ArrayList<Integer>(Arrays.asList(1,3,2));
		
		assertEquals(a, b);
	}
	
	@Test
	public void reduceTest4(){
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,2,1,null,1,1,1,1,4,1,1,null));
		Taboo<Integer> taboo = new Taboo<Integer>(list);
		
		List<Integer> a = new ArrayList<Integer>(Arrays.asList(1,2,3,3,2,1,4,1,4,4));
		taboo.reduce(a);
		List<Integer> b = new ArrayList<Integer>(Arrays.asList(1,3,3,1));
		
		assertEquals(a, b);
	}
	
	@Test
	public void reduceTest5(){
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("1","2","3","a","1","x",null));
		Taboo<String> taboo = new Taboo<String>(list);
		
		List<String> a = new ArrayList<String>(Arrays.asList("1","2","a","1","x","f","3","a","1","a","b"));
		taboo.reduce(a);
		List<String> b = new ArrayList<String>(Arrays.asList("1","a","x","f","3","1","a","b"));
		
		assertEquals(a, b);
	}
	
	@Test
	public void reduceTest6(){
		ArrayList<String> list = new ArrayList<String>();
		Taboo<String> taboo = new Taboo<String>(list);
		
		List<String> a = new ArrayList<String>(Arrays.asList("1","2","a","1","x","f","3","a","1","a","b"));
		taboo.reduce(a);
		List<String> b = new ArrayList<String>(Arrays.asList("1","2","a","1","x","f","3","a","1","a","b"));
		
		assertEquals(a, b);
	}
	
	@Test
	public void reduceTest7(){
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("1","2","3","a","1","x",null));
		Taboo<String> taboo = new Taboo<String>(list);
		
		List<String> a = new ArrayList<String>();
		taboo.reduce(a);
		List<String> b = new ArrayList<String>();
		
		assertEquals(a, b);
	}
	
}
