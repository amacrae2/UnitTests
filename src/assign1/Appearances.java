package assign1;

import java.util.*;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		int numSame = 0;
		HashMap<T,Integer> mapA = populateMap(a);
		HashMap<T,Integer> mapB = populateMap(b);
		for (T key : mapA.keySet()) {
			if (mapB.containsKey(key)) {
				if(mapA.get(key) == mapB.get(key)) {
					numSame++;
				}
			}
		}
		return numSame;
	}
	
	/**
	 * Creates a hashmap mapping from an object in a parameter collection
	 * to a count of the number of times that object appears in the collection
	 * @param x the collection of objects to be counted 
	 * @return the map of the counts of the objects.
	 */
	private static <T> HashMap<T,Integer> populateMap(Collection<T> x) {
		HashMap<T,Integer> hm = new HashMap<T,Integer>();
		Iterator<T> iter = x.iterator();
		while (iter.hasNext()) {
			T elem = iter.next();
			if (hm.containsKey(elem)) {
				int count = hm.get(elem);
				count ++;
				hm.put(elem, count);
			}
			else {
				hm.put(elem, 1);
			}
		}
		return hm;
		
	}
	
}
