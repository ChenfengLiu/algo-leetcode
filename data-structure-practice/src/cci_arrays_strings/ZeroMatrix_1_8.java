package cci_arrays_strings;

import java.util.Arrays;

/**
 * Zero Matrix: Write an algorithm such that if an element in an MxN matrix is
 * 0, its entire row and column are set to 0.
 * 
 * @author chenfeng
 *
 */
public class ZeroMatrix_1_8 {

	public static void main(String[] args) {
		// create test case
		int[][] test = { { 0, 2 }, { 3, 4 } };
		// compute result

		int[][] result = setZeroMatrix(test);
		System.out.println(Arrays.deepToString(result));
	}

	public static int[][] setZeroMatrix(int[][] test) {
		int r = test.length;
		int c = test[0].length;

		boolean[] row = new boolean[r];
		boolean[] col = new boolean[c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (test[i][j] == 0) {
					row[i] = true;
					col[j] = true;
				}
			}
		} // End for loop

		for (int i = 0; i < r; i++) {
			if (row[i]) {
				for (int k = 0; k < c; k++) {
					test[i][k] = 0;
				}
			}
		} // End for loop

		for (int j = 0; j < c; j++) {
			if (col[j]) {
				for (int k = 0; k < c; k++) {
					test[k][j] = 0;
				}
			}
		} // End for loop

		return test;
	}

}
