package cci_bit_manipulation;

/**
 * Binary to String: Given a real number between 0 and 1 (e.g., 0.72) that is
 * passed in as a double, print the binary representation. If the number cannot
 * be represented accurately in binary with at most 32 characters, print"ERROR:"
 * 
 * @author chenfeng
 *
 */
public class BinaryToString_5_2 {

	public static void main(String[] args) {
		// create test case
		double num = 0.101;
	}

	public String printBinary(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}

		String binaryString = ".";
		while (num > 0) {
			if (binaryString.length() >= 32)
				return "ERROR";

			double r = num * 2;
			if (r >= 1) {
				binaryString = binaryString + "1";
				num = r - 1;
			} else {
				binaryString = binaryString + "0";
				num = r;
			}
		} // End while loop
		return binaryString;
	}
}
