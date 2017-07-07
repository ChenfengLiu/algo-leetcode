package leetcode_contest_39;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 633. Sum of Square Numbers: Given a non-negative integer c, your task is to
 * decide whether there're two integers a and b such that a2 + b2 = c.
 * 
 * @author chenfeng
 *
 */
public class Q_1 {

	public static void main(String[] args) {
		// create test case
		int c = 2147483643;

		// test
//		boolean expected = twoSquareSumHashMap(c);
		boolean result = judgeSquareSumByTheorem(c);
//		System.out.println("result is: " + result + " (expected: " + expected + ")");
		System.out.println("result is: " + result);

	}
	
	public boolean judgeSquareSumAnswer(int c) {
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }

	public static boolean judgeSquareSum(int c) {
		if (c < 0)
			return false;
		if (c == 1)
			return true;

		// brute force
		int result = 0;
		int l = c / 2;
		for (int i = 0; i <= l; i++) {
			for (int j = 0; j <= l; j++) {
				result = (int) (Math.pow(i, 2) + Math.pow(j, 2));
				if (result == c) {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean twoSquareSumHashMap(int c) {
		if (c < 0)
			return false;

		if (c == 1)
			return true;

		Map<Integer, Integer> map = new HashMap<>();
		int target;
		int l = c / 2;
		for (int i = 0; i <= l; i++) {
			target = c - i * i;
			map.put(i * i, i);
			if (map.containsKey(target)) {
				return true;
			}
		}
		return false;
	}

	public static boolean judgeSquareSumByTheorem(int c) {
		if (c < 0)
			return false;
		//base case
		if (c == 1 || c == 0)
			return true;
		
		//check if a prime k, which k%4==3, is raised to an odd number
		ArrayList<Integer> primes = getPrimes(c);
		return checkPrimes(primes);
	}
	
	private static boolean checkPrimes(ArrayList<Integer> primes){
		Collections.sort(primes);
		
		int l = primes.size();
		int count=1;
		for(int i = 0; i < l; i++){
			if(primes.get(i)%4 == 3){
				int val = primes.get(i); 
				if(i+1 < l){
					while(val == primes.get(i+1)){
						i++;
						count++;
						if(i+1 == l)break;
					}//end while loop
				}
				
				if(count%2 == 1)return false;
				count = 1;
			}//end if
		}//end for loop
		return true;
	}

	private static ArrayList<Integer> getPrimes(int c) {
		ArrayList<Integer> result = new ArrayList<>();

		while (c % 2 == 0) {
			c = c / 2;
			result.add(2);
		}
		for (int i = 3; i <= c; i = i + 2) {
			while (c % i == 0) {
				c = c / i;
				result.add(i);
			}
		}
		return result;
	}

}
