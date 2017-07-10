package cci_bit_manipulation;

public class BitPractice {

	public static void main(String[] args) {
		// clear last bit
		int c = 29;
		System.out.println(Integer.toBinaryString(c));

		int c_1;
		c_1 = c - 1;
		c = c & (c_1);
		System.out.println(Integer.toBinaryString(c_1) + " : " + Integer.toBinaryString(c));

		c_1 = c - 1;
		c = c & (c - 1);
		System.out.println(Integer.toBinaryString(c_1) + " : " + Integer.toBinaryString(c));

		c_1 = c - 1;
		c = c & (c - 1);
		System.out.println(Integer.toBinaryString(c_1) + " : " + Integer.toBinaryString(c));

		c_1 = c - 1;
		c = c & (c - 1);
		System.out.println(Integer.toBinaryString(c_1) + " : " + Integer.toBinaryString(c));

	}

}
