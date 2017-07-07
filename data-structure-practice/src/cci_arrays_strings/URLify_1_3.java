package cci_arrays_strings;

import java.util.Arrays;

/**
 * URLify: Write a method to replace all spaces in a string with '%20'. You may
 * assume that the string has sufficient space at the end to hold the additional
 * characters, and that you are given the "true" length of the string. (Note: If
 * implementing in Java, please use a character array so that you can perform
 * this operation in place.)
 * 
 * EXAMPLE ", 13
 * 
 * Input: "Mr John Smith
 * 
 * Output: "Mr%20John%20Smith"
 * 
 * @author chenfeng
 *
 */
public class URLify_1_3 {

	public static void main(String[] args) {
		// create test case
		String test = "Mr John Smith     ";

		// compute result
		String result = URLify(test);
		System.out.println("input: " + test);
		System.out.println("output: " + result);

	}

	public static String URLify(String test) {
		String[] tArr = test.trim().split(" ");
		int l = tArr.length - 1;
		for (int i = 0; i < l; i++) {
			tArr[i] += "%20";
		}
		return String.join("", tArr);

	}

}
