package cci_bit_manipulation;

/**
 * Flip Bit to Win: You have an integer and you can flip exactly one bit from a
 * O to a 1. Write code to find the length of the longest sequence of 1 s you
 * could create.
 * 
 * EXAMPLE
 * 
 * Input: 1775 (or: 11011101111)
 * 
 * Output: 8
 * 
 * @author chenfeng
 *
 */
public class FlipBitToWin_5_3 {

	public static void main(String[] args) {
		// create test case
		int a = 1775;

		// compute result
		int result = flipBit(a);
		System.out.println("result is: " + result);
	}

	public static int flipBit(int a) {
		if (~a == 0)
			return Integer.BYTES * 8;

		int currentLength = 0;
		int previousLength = 0;
		int maxLength = 1;

		while (a != 0) {
			if ((a & 1) == 1)
				currentLength++;
			else if ((a & 1) == 0) {
				previousLength = (a & 2) == 0 ? 0 : currentLength;
				currentLength = 0;
			}
			maxLength = Math.max(previousLength + currentLength + 1, maxLength);

			a = a >> 1;
		} // End while loop
		return maxLength;
	}
}
