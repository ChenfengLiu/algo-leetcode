package leetcode_arrays_strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This coding question is to enumerate all uppercase/lowercase permutation for
 * any letter specified in $rule_char_set
 *
 * Try to provide an optimal solution
 * 
 * Input: word = “medium-one” rule_char_set = “io”
 *
 * Output: solutions = [“medium-one”, “medIum-one”, “medium-One”, “medIum-One”]
 *
 * If the character in $rule_char_set appears more than once in $word, treat #
 * them as independent variable. For example:
 *
 * Input: word = “medium-one” rule_char_set = “m” Output: solutions =
 * [“medium-one”, “Medium-one”, ‘mediuM-one”, “MediuM-one”]
 * 
 * @author chenfeng
 *
 */
public class StringPermutations {

	private static Map<Character, Integer> map;

	public static void main(String[] args) {
		// create test case
		String word = "aab";
		String rule_char_set = "c";

		// compute result
		findStringPermutations(word, rule_char_set);

	}

	public static void findStringPermutations(String n, String m) {
		map = new HashMap<Character, Integer>();
		for (int i = 0; i < m.length(); i++)
			map.put(m.charAt(i), i);

		permutation(n, n, 0);
	}

	private static void permutation(String result, String str, int index) {
		int n = str.length();
		System.out.println(result);
		for (int i = index; i < index + n; i++) {
			if (map.containsKey(str.charAt(i-index))) {
				permutation(result.substring(0, i) + toggleChar(result.charAt(i))
						+ result.substring(i + 1, result.length()), str.substring(i - index + 1, n), i + 1);
			}//End if
		}//End for loop
	}

	private static char toggleChar(char a) {
		if (Character.toUpperCase(a) == a)
			return Character.toLowerCase(a);
		else
			return Character.toUpperCase(a);
	}

}
