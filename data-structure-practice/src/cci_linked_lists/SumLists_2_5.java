package cci_linked_lists;

import cci_linked_lists.DeleteMiddleNode_2_3.LinkedListNode;
import cci_linked_lists.RecursePractice.PartialSum;

/**
 * Sum Lists: You have two numbers represented by a linked list, where each node
 * contains a single digit. The digits are stored in reverse order, such that
 * the 1 's digit is at the head of the list. Write a function that adds the two
 * numbers and returns the sum as a linked list. Sum Lists: You have two numbers
 * represented by
 * 
 * EXAMPLE
 * 
 * Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
 * 
 * Output: 2 -> 1 -> 9. That is, 912.
 * 
 * FOLLOW UP
 * 
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * 
 * EXAMPLE
 * 
 * lnput:(6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
 * 
 * Output: 9 -> 1 -> 2. That is, 912.
 * 
 * @author chenfeng
 *
 */
public class SumLists_2_5 {

	public static void main(String[] args) {
		// Create test case
		LinkedListNode l1 = new LinkedListNode(7);
		l1.next = new LinkedListNode(1);
		l1.next.next = new LinkedListNode(6);

		LinkedListNode l2 = new LinkedListNode(5);
		l2.next = new LinkedListNode(9);
		l2.next.next = new LinkedListNode(2);

		// compute result
		LinkedListNode result = addLists(l1, l2, 0);

		while (result != null) {
			System.out.println(result.value);
			if (result.next != null)
				result = result.next;
			else
				break;
		}

		// follow up
		LinkedListNode l3 = new LinkedListNode(6);
		l3.next = new LinkedListNode(1);
		l3.next.next = new LinkedListNode(7);

		LinkedListNode l4 = new LinkedListNode(2);
		l4.next = new LinkedListNode(9);
		l4.next.next = new LinkedListNode(5);

		LinkedListNode l5 = addListsFollowUp(l3, l4);

		System.out.println("Follow up: ");
		while (l5 != null) {
			System.out.println(l5.value);
			if (l5.next != null)
				l5 = l5.next;
			else
				break;
		}

	}

	public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
		if (l1 == null && l2 == null && carry == 0)
			return null;

		LinkedListNode result = new LinkedListNode(0);

		int val = carry;
		if (l1 != null)
			val += l1.value;
		if (l2 != null)
			val += l2.value;

		result.value = val % 10;

		// recurse
		if (l1 != null || l2 != null) {
			LinkedListNode next = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, val > 9 ? 1 : 0);
			result.next = next;
		}

		return result;

	}

	/**
	 * follow up
	 */
	public static LinkedListNode addListsFollowUp(LinkedListNode l1, LinkedListNode l2) {
		// find the length of the two list
		int len1 = listLength(l1);
		int len2 = listLength(l2);

		// add zeros in front of the shorter list
		if (len1 < len2)
			l1 = addZeros(l1, len2 - len1);
		else
			l2 = addZeros(l2, len1 - len2);

		// add lists
		PartialSum sum = addListsFollowUpHelper(l1, l2);

		if (sum.carry == 0)
			return sum.sum;
		else {
			LinkedListNode result = new LinkedListNode(1);
			result.next = sum.sum;
			return result;
		}
	}

	public static PartialSum addListsFollowUpHelper(LinkedListNode l1, LinkedListNode l2) {
		if (l1 == null && l2 == null)
			return new PartialSum();

		PartialSum sum = addListsFollowUpHelper(l1.next, l2.next);

		int val = sum.carry + l1.value + l2.value;

		LinkedListNode head = new LinkedListNode(val % 10);
		head.next = sum.sum;

		sum.sum = head;
		sum.carry = val / 10;
		return sum;
	}

	public static LinkedListNode addZeros(LinkedListNode n, int zeros) {
		LinkedListNode head = n;
		for (int i = 0; i < zeros; i++) {
			LinkedListNode z = new LinkedListNode(0);
			z.next = head;
			head = z;
		}
		return head;
	}

	public static int listLength(LinkedListNode n) {
		if (n == null)
			return 0;

		int i = 1;
		while (n != null) {
			if (n.next == null)
				break;
			n = n.next;
			i++;
		}
		return i;
	}

	public static class PartialSum {
		LinkedListNode sum = null;
		int carry = 0;

		public PartialSum() {

		}
	}

	public static class LinkedListNode {
		LinkedListNode next;
		int value;

		public LinkedListNode(int v) {
			this.value = v;
		}
	}

}
