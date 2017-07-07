package leetcode_math_logicPuzzles;

import java.util.ArrayList;

/**
 * Quetion 625: Minimum Factorization -- Given a positive integer a, find the
 * smallest positive integer b whose multiplication of each digit equals to a.
 * 
 * If there is no answer or the answer is not fit in 32-bit signed integer, then
 * return 0
 * 
 * @author chenfeng
 *
 */
public class MinFactorization_625 {

	public static void main(String[] args) {
		// create test case
		int a = 18000000;

		int result = smallestFactorization(a);
		System.out.println("result is: " + result);

	}

	public static int smallestFactorization(int a) {
		if (a < 10)
			return a;
		String answer = "";
		int i = 9;
		while (a != 1) {
			while (a % i == 0) {
				a = a / i;
				answer = i + answer;

			}
			i--;
			if (i == 1 && a > 9)
				return 0;

		}
		try {
			return Integer.parseInt(answer);
		} catch (NumberFormatException e) {
			return 0;
		}

	}

}
