package leetcode_arrays_strings;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import random_generator.Random_String;

/**
 * Question 561: Array Partition I -- Given an array of 2n integers, your task
 * is to group these integers into n pairs of integer, say (a1, b1), (a2, b2),
 * ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large
 * as possible.
 * 
 * 
 * @author chenfeng
 *
 */
public class ArrayPartitionI_561 {

	public static void main(String[] args) throws IOException {

		int numOfStrings = 1000;
		int numLength = 4;
		String randomNumberFileName = "random_numbers.txt";

		// create random array
		// Random_String rs2 = new Random_String(numOfStrings, numLength,
		// Random_String.generateType.NUMERIC,
		// randomNumberFileName);
		//
		// Scanner scanNumber = new Scanner(new File(randomNumberFileName));
		// int[] nums = new int[numOfStrings];
		// int i = 0;
		//
		// while (scanNumber.hasNext()) {
		// nums[i] = Integer.parseInt(scanNumber.nextLine());
		// i++;
		// }
		// scanNumber.close();

		// example array
		int[] nums = { 1, 2, 3, 4 };

		// compute result
		int result = arrayPairSum(nums);
		System.out.println("result is: " + result);

	}

	public static int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int l = nums.length;
		int sum = 0;
		for (int i = 0; i < l; i += 2) {
			sum += nums[i];
		}

		return sum;
	}

}
