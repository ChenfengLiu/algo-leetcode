package cci_arrays_strings;

import java.util.Arrays;

/**
 * Rotate Matrix: Given an image represented by an NxN matrix, where each pixel
 * in the image is 4 bytes, write a method to rotate the image by 90 degrees.
 * Can you do this in place?
 * 
 * @author chenfeng
 *
 */
public class RotateMatrix_1_7 {

	public static void main(String[] args) {
		// create test case
		// 1,2,3 -> 7,4,1
		// 4,5,6 -> 8,5,2
		// 7,8,9 -> 9,6,3

		// (n-1,0),(n-2,0)(n-3,0)
		// (n-1,1),(n-2,1)(n-3,1)
		// ...

		int[][] img = { { 1, 2 }, { 3, 4 } };
		
		//compute result
		int[][] result = RotateMatrix(img);
		System.out.println(Arrays.deepToString(result));
	}

	public static int[][] RotateMatrix(int[][] img) {
		int n = img.length;
		int[][] result = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j] = img[n - j - 1][i];
			}
		}
		return result;
	}

}
