package cci_bit_manipulation;

/**
 * Next Number: Given a positive integer, print the next smallest and the next
 * largest number that have the same number of 1 bits in their binary
 * representation.
 * 
 * @author chenfeng
 *
 */
public class NextNumber_5_4 {

	public static void main(String[] args) {
		// create test case
		int n = 13948;// 0b1101 1001 1111 00
		int m = 10115; // 0b1001 1110 0000 11

		int resultN = getNextSmallest(n);
		int resultM = getPrevBiggest(m);
	}

	public static int getNextSmallest(int n) {
		int c = n;
		int c0 = 0;
		int c1 = 0;

		while (((c & 1) == 0) && (c != 0)) {
			c0++;
			c >>= 1;
		}

		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}

		if (c0 + c1 == 31 || c0 + c1 == 0)
			return -1;

		// get position of rightmost non-trailing zero
		int p = c0 + c1;

		// Flip rightmost non-trailing zero
		n |= (1 << p);

		// Clear all bits to the right of p
		n &= ~((1 << p) - 1);

		// Insert (c1-1) ones to the right
		n |= (1 << (c1 - 1)) - 1;

		return n;
	}

	public static int getPrevBiggest(int n) {
		System.out.println("n is: ");
		System.out.println(Integer.toBinaryString(n));
		int c = n;
		int c0 = 0;
		int c1 = 0;

		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}

		if (c == 0)
			return -1;

		while (((c & 1) == 0) && c != 0) {
			c0++;
			c >>= 1;
		}

		int p = c0 + c1;

		n &= ((~0) << (p + 1));
		System.out.println("clears from bit p onwards: ");
		System.out.println(Integer.toBinaryString(n));
		int mask = (1 << (c1 + 1)) - 1;
		System.out.println("Sequence of (c1+1) ones: ");
		System.out.println(Integer.toBinaryString(mask));
		n |= mask << (c0 - 1);
		System.out.println("result: ");
		System.out.println(Integer.toBinaryString(n));

		return n;
	}

}
