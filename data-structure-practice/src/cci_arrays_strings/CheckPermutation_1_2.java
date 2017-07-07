package cci_arrays_strings;

import java.util.Arrays;

/**
 * Check Permutation: Given two strings, write a method to decide if one is a
 * permutation of the other.
 * 
 * @author chenfeng
 *
 */
public class CheckPermutation_1_2 {

	public static void main(String[] args) {
		// create test case
		String a = "abc", b = "ace";

		// compute result
		boolean result = isPermutationByArr(a, b);
		if (result)
			System.out.println(b + " is a permutation of " + a);
		else
			System.out.println(b + " is NOT a permutation of " + a);

	}

	public static boolean isPermutation(String a, String b) {
		if (a.length() != b.length())
			return false;

		char[] charA = a.toCharArray();
		char[] charB = b.toCharArray();

		Arrays.sort(charA);
		Arrays.sort(charB);

		return Arrays.toString(charA).equals(Arrays.toString(charB));
	}

	public static boolean isPermutationByArr(String a, String b) {
		if (a.length() != b.length())
			return false;

		char[] charA = a.toCharArray();
		char[] charB = b.toCharArray();

		// assume ASCII char set (128 characters)
		int[] charset = new int[128];
		for (char c : charA) {
			charset[c]++;
		}

		for (char c : charB) {
			charset[c]--;
			if (charset[c] < 0)
				return false;
		}

		return true;
	}

}
