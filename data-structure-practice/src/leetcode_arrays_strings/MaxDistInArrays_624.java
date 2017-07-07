package leetcode_arrays_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Question 624: Maximum Distance in Arrays -- Given m arrays, and each array is
 * sorted in ascending order. Now you can pick up two integers from two
 * different arrays (each array picks one) and calculate the distance. We define
 * the distance between two integers a and b to be their absolute difference
 * |a-b|. Your task is to find the maximum distance.
 * 
 * Note: 1. Each given array will have at least 1 number. 2. There will be at
 * least two non-empty arrays. 3. The total number of the integers in all the m
 * arrays will be in the range of [2, 10000]. 4. The integers in the m arrays
 * will be in the range of [-10000, 10000].
 * 
 * @author chenfeng
 *
 */
public class MaxDistInArrays_624 {

	public static void main(String[] args) {

		// create test arrays
		List<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> a1 = new ArrayList<>();
		ArrayList<Integer> a2 = new ArrayList<>();
		ArrayList<Integer> a3 = new ArrayList<>();
		a1.add(1);
		a1.add(2);
		a1.add(3);
		a2.add(4);
		a2.add(5);
		a3.add(1);
		a3.add(2);
		a3.add(3);
		arr.add(a1);
		arr.add(a2);
		arr.add(a3);

		// compute result
		int result = maxDistance(arr);
		System.out.println("result is: " + result);
	}

	public static int maxDistance(List<ArrayList<Integer>> arrays) {
		int numArrays = arrays.size();
		int result = Integer.MIN_VALUE;
		int min = arrays.get(0).get(0), max = arrays.get(0).get(arrays.get(0).size()-1);
		for (int i = 1; i < numArrays; i++) {
			result = Math.max(result, Math.abs(arrays.get(i).get(0) - max));
			result = Math.max(result, Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min));
			min = Math.min(min, arrays.get(i).get(0));
			max = Math.max(max, arrays.get(i).get(arrays.get(i).size()-1));
		}
		return result;
	}

}
