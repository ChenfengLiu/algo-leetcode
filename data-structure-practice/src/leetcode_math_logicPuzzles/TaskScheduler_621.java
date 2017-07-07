package leetcode_math_logicPuzzles;

import java.util.Arrays;

/**
 * Question 621: Task Scheduler -- Given a char array representing tasks CPU
 * need to do. It contains capital letters A to Z where different letters
 * represent different tasks.Tasks could be done without original order. Each
 * task could be done in one interval. For each interval, CPU could finish one
 * task or just be idle.
 * 
 * However, there is a non-negative cooling interval n that means between two
 * same tasks, there must be at least n intervals that CPU are doing different
 * tasks or just be idle.
 * 
 * You need to return the least number of intervals the CPU will take to finish
 * all the given tasks.
 * 
 * @author chenfeng
 *
 */
public class TaskScheduler_621 {

	public static void main(String[] args) {
		// create test case
		char[] tasks = { 'A', 'B', 'A', 'B', 'A', 'B' };
		int n = 3;

		// compute result;
		int result = leastInterval(tasks, n);
		System.out.println("result is: " + result);

	}

	public static int leastInterval(char[] tasks, int n) {
		int[] tArr = new int[26];
		for (char c : tasks) {
			tArr[c - 'A']++;
		}
		Arrays.sort(tArr);
		
		//from leetcode user: fatalme
		int i = 25;
        while(i >= 0 && tArr[i] == tArr[25]) i--;
        return Math.max(tasks.length, (tArr[25] - 1) * (n + 1) + 25 - i);
	}

}
