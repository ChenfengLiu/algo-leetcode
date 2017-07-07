package cci_linked_lists;

import java.util.Stack;

import cci_linked_lists.SumLists_2_5.LinkedListNode;

/**
 * Palindrome: Implement a function to check if a linked list is a palindrome.
 * 
 * @author chenfeng
 *
 */
public class Palindrome_2_6 {

	public static void main(String[] args) {
		// create test case
		LinkedListNode l1 = new LinkedListNode(7);
		l1.next = new LinkedListNode(1);
		l1.next.next = new LinkedListNode(1);
		l1.next.next.next = new LinkedListNode(7);

		// compute result
		boolean result = isPalindrome(l1);
		System.out.println("result is: " + result);
	}

	public static boolean isPalindrome(LinkedListNode head) {
		LinkedListNode fast = head;
		LinkedListNode slow = head;
		Stack<Integer> s = new Stack<>();
		while (fast != null && fast.next != null) {
			s.push(slow.value);
			slow = slow.next;
			fast = fast.next.next;
		}

		// if odd, skip middle node
		if (fast != null) {
			slow = slow.next;
		}

		while (slow != null) {
			int val = s.pop();

			if (val != slow.value)
				return false;
			slow = slow.next;
		}
		return true;
	}

	public static class LinkedListNode {
		LinkedListNode next;
		int value;

		public LinkedListNode(int v) {
			this.value = v;
		}
	}

}
