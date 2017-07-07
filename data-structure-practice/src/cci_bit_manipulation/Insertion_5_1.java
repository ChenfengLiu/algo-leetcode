package cci_bit_manipulation;

import practice_utils.Bit_Manipulation_Util;

/**
 * Insertion: You are given two 32-bit numbers, N and M, and two bit positions,
 * i and j. Write a method to insert Minto N such that M starts at bit j and
 * ends at bit i. You can assume that the bits j through i have enough space to
 * fit all of M. That is, if M = 10011, you can assume that there are at least 5
 * bits between j and i. You would not, for example, have j = 3 and i = 2,
 * because M could not fully fit between bit 3 and bit 2.
 * 
 * EXAMPLE
 * 
 * Input: N = 10000000000, M = 10011, i = 2, j = 6
 * 
 * Output: N = 10001001100
 * 
 * @author chenfeng
 *
 */
public class Insertion_5_1 {

	public static void main(String[] args) {
		// create test case

		int n = 1024;
		int m = 19;
		System.out.println("m is: " + Integer.toBinaryString(m));
		System.out.println("n is: " + Integer.toBinaryString(n));

		int i = 2, j = 6;
		System.out.println("result is: " + Integer.toBinaryString(insertBits(n, m, i, j)));
	}

	public static int insertBits(int n, int m, int i, int j) {
		Bit_Manipulation_Util bmu = new Bit_Manipulation_Util();

		// clear bits j through i in n
		int jTo0 = bmu.ClearBitsIthrough0(n, j);
		int MSBToi = bmu.ClearBitsMSBthroughI(n, i);
		int mask = jTo0 | MSBToi;

		int n_cleared = n & mask;

		// shift m to line up with bits j through i
		int m_shifted = m << i;

		// merge m and n
		return n_cleared | m_shifted;
	}

}
