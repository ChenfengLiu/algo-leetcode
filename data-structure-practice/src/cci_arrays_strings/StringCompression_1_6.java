package cci_arrays_strings;

/**
 * String Compression: Implement a method to perform basic string compression
 * using the counts of repeated characters. For example, the string aabcccccaaa
 * would become a2blc5a3. If the "compressed" string would not become smaller
 * than the original string, your method should return the original string. You
 * can assume the string has only uppercase and lowercase letters (a - z).
 * 
 * @author chenfeng
 *
 */
public class StringCompression_1_6 {

	public static void main(String[] args) {
		// create test case
		String test = "aabcccccaaa";

		// compute result
		String result = StringCompression(test);
		System.out.println("result is: " + result);

	}

	public static String StringCompression(String a) {
		String test = a;
		int l = test.length();

		for (int i = 0; i < l; i++) {
			int j = i;
			while (test.charAt(i) == test.charAt(j)) {
				j++;
				if (j == test.length())
					break;
			}
			test = test.substring(0, i + 1) + (j - i) + test.substring(j);
			l = test.length();
			i++;
		}
		return test.length() >= a.length() ? a : test;
	}

}
