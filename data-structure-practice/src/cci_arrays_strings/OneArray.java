package cci_arrays_strings;

/**
 * One Array: There are three types of edits that can be performed on strings:
 * insert a character, remove a character, or replace a character. Given two
 * strings, write a function to check if they are one edit (or zero edits) away.
 * 
 * EXAMPLE
 * 
 * pale, ple -> true
 * 
 * pales, pale -> true
 * 
 * pale, bale -> true
 * 
 * pale, bake -> false
 * 
 * @author chenfeng
 *
 */
public class OneArray {

	public static void main(String[] args) {
		// create test case
		String a = "pale", b = "pae";

		// compute result
		boolean result = isOneArray(a, b);
		if (result)
			System.out.println(a + " and " + b + " are one edit away");
		else
			System.out.println(a + " and " + b + " are NOT one edit away");

	}

	public static boolean isOneArray(String a, String b) {
		if (a.length() == b.length())
			return isOneCharReplace(a, b);
		else
			return isOneCharInsert(a, b);
	}

	public static boolean isOneCharReplace(String a, String b) {
		int diff = 0;
		int l = a.length();
		for (int i = 0; i < l; i++) {
			if (a.charAt(i) != b.charAt(i))
				diff++;
			if (diff > 1)
				return false;
		}
		return true;
	}

	public static boolean isOneCharInsert(String a, String b) {
		if (a.length() - b.length() > 1)
			return false;

		int l = Math.max(a.length(), b.length()) - 1 ;
		for (int i = 0; i < l; i++) {
			if(a.charAt(i) != b.charAt(i)){
				if(a.length() > b.length()){
					b = b.substring(0, i) + a.charAt(i) + b.substring(i);
					System.out.println("b is " + b);
					return a.equals(b);
				}
			}
		}
		return true;
	}

}
