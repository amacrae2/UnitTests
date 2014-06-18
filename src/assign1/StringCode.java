package assign1;

import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adjacent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		// checks for empty string
		if (str.length() == 0) {
			return 0;
		}
	
		int maxRun = 0;
		int currRun = 1;
		char prevChar = str.charAt(0);
		char currChar;
		for(int i = 1; i < str.length(); i++) {
			currChar = str.charAt(i);
			if (prevChar == currChar) {
				currRun++;
			}
			else {
				currRun = 1;
			}
			if (currRun > maxRun) {
				maxRun = currRun;
			}
			prevChar = currChar;
		}
		return maxRun;
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
//		// checks for empty string
//		if (str.length() == 0) {
//			return "";
//		}
//		
		
		String result = "";
		char currChar;
		char nextChar;
		int currNum;
		for (int i = 0; i < str.length(); i++) {
			currChar = str.charAt(i);
			if (Character.isDigit(currChar)) {
				// checks if last digit is a number. If so, we are done.
				if (i == str.length()-1) {
					break;
				}
				else {
					nextChar = str.charAt(i+1);
					currNum = Character.getNumericValue(currChar);
					for (int j = 0; j < currNum; j++) {
						result += nextChar;
					}
				}
			}
			else {
				result += currChar;
			}
		}
		return result;
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		int capacityA = a.length() - len + 1;
		int capacityB = b.length() - len + 1;
		if (capacityA < 1 || capacityB < 1) {
			return false;
		}
		HashSet<String> hs = new HashSet<String>(capacityA);
		for (int i = 0; i < capacityA; i++) {
			hs.add(a.substring(i, len+i));
		}
		for (int i = 0; i < capacityB; i++) {
			String str = b.substring(i, len+i);
			if (hs.contains(str)) {
				return true;
			}
		}
		return false;
	}
}
