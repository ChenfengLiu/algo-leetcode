package leetcode_arrays_strings;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

import random_generator.Random_String;

/**
 * Question 575: Distribute Candies -- Given an integer array with even length,
 * where different numbers in this array represent different kinds of candies.
 * Each number means one candy of the corresponding kind. You need to distribute
 * these candies equally in number to brother and sister. Return the maximum
 * number of kinds of candies the sister could gain.
 * 
 * Note: 1. The length of the given array is in range [2, 10,000], and will be
 * even. 2. The number in given array is in range [-100,000, 100,000].
 * 
 * @author chenfeng
 *
 */
public class DistributeCandies_575 {

	public static void main(String[] args) throws IOException {
		// int numOfStrings = 10000;
		// int numLength = 5;
		// String randomNumberFileName = "random_numbers.txt";
		//
		// // create random number array
		// Random_String rs = new Random_String(numOfStrings, numLength,
		// Random_String.generateType.NUMERIC,
		// randomNumberFileName);
		//
		// Scanner scanNumber = new Scanner(new File(randomNumberFileName));
		// int[] candies = new int[numOfStrings];
		// int i = 0;
		//
		// while (scanNumber.hasNext()) {
		// candies[i] = Integer.parseInt(scanNumber.nextLine());
		// i++;
		// }
		// scanNumber.close();

		int[] candies = { 1, 1, 6, 6, 6, 6 };
		// compute result
		int result = distributeCandies(candies);
		System.out.println("result is: " + result);
	}

	public static int distributeCandies(int[] candies) {
		HashSet<Integer> hs = new HashSet<>();
		for (int c : candies) {
			hs.add(c);
		}
		return Math.min(hs.size(), candies.length / 2);
	}

}
