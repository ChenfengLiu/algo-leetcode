package cci_arrays_strings;

/**
 * Palindrome Permutation: Given a string, write a function to check if it is a
 * permutation of a palin­ drome. A palindrome is a word or phrase that is the
 * same forwards and backwards. A permutation is a rearrangement of letters. The
 * palindrome does not need to be limited to just dictionary words.
 * 
 * EXAMPLE
 * 
 * Input: Tact Coa
 * 
 * Output: True (permutations: "taco cat", "atco eta", etc.)
 * 
 * @author chenfeng
 *
 */
public class PalindromePermutation_1_4 {

	public static void main(String[] args) {
		// create test case
		String test = "Tact Coa";

		// int a = (int) 'a';
		// int z = (int) 'z';
		// int A = (int) 'A';
		// int Z = (int) 'Z';
		// System.out.println(a);
		// System.out.println(z);
		// System.out.println(A);
		// System.out.println(Z);

		// compute result
		boolean result = isPalindromPremutation(test);
		if (result)
			System.out.println(test + " is a permutation of a palindrome");
		else
			System.out.println(test + " is NOT a permutation of a palindrome");

	}

	public static boolean isPalindromPremutation(String test) {
		// assume ASCII char set, and
		test = test.trim().toLowerCase();
		boolean[] charset = new boolean[26];
		for (char c : test.toCharArray()) {
			if (c == ' ')
				continue;
			charset[c - 'a'] ^= true;
		}

		int trueCounter = 0;
		for (boolean b : charset) {
			if (b)
				trueCounter++;
		}

		if (trueCounter > 1)
			return false;
		return true;
	}

}
