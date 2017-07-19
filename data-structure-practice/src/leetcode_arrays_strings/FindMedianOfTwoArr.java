package leetcode_arrays_strings;

/**
 * Find the median numbers of two very large array of sorted integers. Assuming
 * both arrays have the same large length = N.
 * 
 * The result should be the same as if you concatenated the two arrays into a #
 * single array, sorted it and then returned the middle two numbers (This is #
 * O(n log n) and thus not an acceptable solution)
 * 
 * For example:
 * 
 * Input:
 * 
 * array_int1 = [ 10, 20, 30, 40, 51, 61, 71]
 * 
 * array_int2 = [ 15, 25, 31, 86, 600, 700, 900]
 * 
 * Output: median numbers = 40, 51
 * 
 * @author chenfeng
 *
 */
public class FindMedianOfTwoArr {

	public static void main(String[] args) {
		// create test case
		int[] a = { 10, 20, 30, 40, 51, 61, 71 };
		int[] b = { 15, 25, 31, 86, 600, 700, 900 };
		int n = a.length;

		// compute result
		int[] result = new int[2];
		result = findMedianOfTwoArrays(a, b, n);
		System.out.println("result is: " + "( " + result[0] + ", " + result[1] + " )");
	}

	public static int[] findMedianOfTwoArrays(int[] a, int[] b, int n) {
		if (a[n - 1] < b[0])
			return new int[] { a[n - 1], b[0] };
		if (a[0] > b[n - 1])
			return new int[] { b[n - 1], a[0] };

		return findMedianOfTwoArrays(a, b, 0, 0, a.length - 1, b.length - 1);
	}

	private static int[] findMedianOfTwoArrays(int[] a, int[] b, int aStart, int bStart, int aEnd, int bEnd) {

		while ((aEnd - aStart) > 1 || (bEnd - bStart) > 1) {
			int m1 = a[(aEnd + aStart) / 2];
			int m2 = b[(bEnd + bStart) / 2];

			if (m1 == m2)
				return new int[] { m1, m2 };

			if (m1 < m2) {
				aStart = (aEnd + aStart) / 2;
				bEnd = ((bEnd - bStart) % 2 == 0) ? (bEnd + bStart) / 2 : (bEnd + bStart) / 2 + 1;
			} else {
				bStart = (bEnd + bStart) / 2;
				aEnd = ((aEnd - aStart) % 2 == 0) ? (aEnd + aStart) / 2 : (aEnd + aStart) / 2 + 1;
			}

			System.out.println("aStart is: " + aStart + " // aEnd is: " + aEnd);
			System.out.println("bStart is: " + bStart + " // bEnd is: " + bEnd);
		} // End while loop

		int m1 = Math.max(a[aStart], b[bStart]);
		int m2 = Math.min(a[aEnd], b[bEnd]);
		return new int[] { m1, m2 };
	}

}
