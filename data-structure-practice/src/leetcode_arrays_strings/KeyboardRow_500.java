package leetcode_arrays_strings;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import random_generator.Random_String;

/**
 * Question 500: Keyboard Row -- Given a List of words, return the words that
 * can be typed using letters of alphabet on only one row's of American keyboard
 * like the image below.
 * 
 * @author chenfeng
 *
 */
public class KeyboardRow_500 {

	public static void main(String[] args) throws IOException {
		int numOfStrings = 10;
		int numLength = 4;
		String randomAlphabetFileName = "random_alphabets.txt";

		// create random array
		Random_String rs = new Random_String(numOfStrings, numLength, Random_String.generateType.ALPHABETIC,
				randomAlphabetFileName);

		Scanner scan = new Scanner(new File(randomAlphabetFileName));
		String[] words = new String[numOfStrings];
		int i = 0;

		while (scan.hasNext()) {
			words[i] = scan.nextLine();
			i++;
		}
		scan.close();

		// compute result
		String[] result = findWords(words);
		System.out.println("result is: ");
		System.out.println(Arrays.deepToString(result));

	}

	public static String[] findWords(String[] words) {
		String[] keyboard = { "qwertyuiop", "asdfghjkl", "zxcvbnm" };
		HashMap<Character, Integer> hm = new HashMap<>();
		for (int i = 0; i < keyboard.length; i++) {
			for (int j = 0; j < keyboard[i].length(); j++) {
				hm.put(keyboard[i].charAt(j), i);
			}
		}

		ArrayList<String> result = new ArrayList<>();

		for (String w : words) {
			String wtemp = w.toLowerCase();
			int l = w.length();

			int value = hm.get(wtemp.charAt(0));
			boolean test = true;
			for (int i = 1; i < l; i++) {
				if (value != hm.get(wtemp.charAt(i))) {
					test = false;
					break;
				}
			}
			if (test) {
				result.add(w);
				test = false;
			}
		}
		return (String[]) result.toArray(new String[result.size()]);
	}
}
