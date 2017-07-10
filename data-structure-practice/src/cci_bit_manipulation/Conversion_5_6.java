package cci_bit_manipulation;

/**
 * Conversion: Write a function to determine the number of bits you would need
 * to flip to convert integer A to integer B.
 * 
 * EXAMPLE
 * 
 * Input: 29 (or: 11101), 15 (or: 01111)
 * 
 * Output: 2
 * 
 * @author chenfeng
 *
 */
public class Conversion_5_6 {

	public static void main(String[] args) {
		// create test case
		int a = 29;
		int b = 15;

		// compute result

	}

	public static int bitSwapRequired(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c = c >> 1) {
			count += c & 1;
		}
		return count;
	}

	public static int bitSwapRequired2(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c = c & (c - 1)) {
			count++;
		}
		return count;
	}

}
