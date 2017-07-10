package cci_bit_manipulation;

/**
 * Debugger: Explain what the following code does: ((n & (n-1 )) == 0).
 * 
 * @author chenfeng
 *
 */
public class Debugger_5_5 {

	public static void main(String[] args) {
		// n and n-1 must have no 1s in common.
		// n | n-1 | n&(n-1)
		// 0 | -1 | 0
		// 1 | 0 | 0
		// 3 | 2 | 2
		int n = 3;
		debugger(n);
	}

	public static void debugger(int n) {
		int temp = n & (n - 1);

		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(n - 1));

		System.out.println("temp is: ");
		System.out.println(temp);

		boolean tmp = temp == 0;
	}

}
