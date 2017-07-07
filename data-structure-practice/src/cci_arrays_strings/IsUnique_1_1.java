package cci_arrays_strings;

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique
 * characters. What if you cannot use additional data structures?
 * 
 * @author chenfeng
 *
 */
public class IsUnique_1_1 {

	public static void main(String[] args) {
		// assume ASCII char set (128 chars)
		// create test case
		String test = "abc";

		// compute result
		boolean result = isUniqueString(test);
		if (result)
			System.out.println(test + " is unique");
		else
			System.out.println(test + " is NOT unique");
	}

	public static boolean isUniqueString(String test) {
		int l = test.length();
		if (l > 128)
			return false;

		boolean[] countChar = new boolean[128];
		for (char a : test.toCharArray()) {
			if (countChar[a])
				return false;
			countChar[a] = true;
		}
		return true;
	}

}
