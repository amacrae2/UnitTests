/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/
package assign1;

import java.util.*;

public class Taboo<T> {
	
	List<T> rules;
	
	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 * @param rules rules for new Taboo
	 */
	public Taboo(List<T> rules) {
		this.rules = rules;
	}
	
	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	public Set<T> noFollow(T elem) {
		HashSet<T> result = new HashSet<T>();
		HashMap<T,ArrayList<T>> ruleMap = createRuleMap();
		if (ruleMap.containsKey(elem)) {
			for (T value : ruleMap.get(elem)) {
				result.add(value);
			}
		}
		return result;
	}
	
	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 * @param list collection to reduce
	 */
	public void reduce(List<T> list) {
		HashMap<T,ArrayList<T>> ruleMap = createRuleMap();
		for (int i = 0; i < list.size()-1; i++) {
			/*
			 *  if there is a Taboo rule in the ruleMap that states
			 *  T at index i+1 cannot follow T at index i
			 */
			if (ruleMap.containsKey(list.get(i)) && 
					ruleMap.get(list.get(i)).contains(list.get(i+1))) {
				list.remove(i+1);
				i--;
			}
		}
	}

	/**
	 * Creates a mapping of object to list of objects that are not
	 * allowed to follow that object
	 * @return the HashMap of these rules
	 */
	private HashMap<T, ArrayList<T>> createRuleMap() {
		HashMap<T,ArrayList<T>> hm = new HashMap<T,ArrayList<T>>();
		for (int i = 0; i < rules.size()-1; i++) {
			if (rules.get(i) != null && rules.get(i+1) != null) {
				ArrayList<T> list = new ArrayList<T>();
				T curr = rules.get(i);
				T next = rules.get(i+1);
				if (hm.containsKey(curr)) {
					list = hm.get(curr);
				}
				list.add(next);
				hm.put(curr, list);
			}
		}
		return hm;
	}
}
