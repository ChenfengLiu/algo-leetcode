package cci_linked_lists;

import java.util.Arrays;
import java.util.HashMap;

import cci_linked_lists.SumLists_2_5.LinkedListNode;

public class RecursePractice {

	public static void main(String[] args) {
		// Array recurse
		int n = 3;
		int[] a1 = { 1, 2, 3 };
		int[] a2 = { 2, 3, 4 };
		int[] result = new int[3];

		System.out.println(Arrays.toString(RecurseMethod(a1, a2, 0, result)));

		// linkedlist recurse (617 + 295 = 912)
		LinkedListNode l3 = new LinkedListNode(6);
		l3.next = new LinkedListNode(1);
		l3.next.next = new LinkedListNode(7);

		LinkedListNode l4 = new LinkedListNode(2);
		l4.next = new LinkedListNode(9);
		l4.next.next = new LinkedListNode(5);

		PartialSum sum = addListsFollowUpHelper(l3, l4);

//		while (resultNode != null) {
//			System.out.println(resultNode.value);
//			if (resultNode.next == null)
//				break;
//			resultNode = resultNode.next;
//		}
		// System.out.println("1: " + resultNode.value);
		// System.out.println("2: " + resultNode.next.value);
		// System.out.println("3: " + resultNode.next.next.value);

	}

	public static int[] RecurseMethod(int[] a1, int[] a2, int n, int[] result) {
		if (n == a1.length)
			return result;

		result[n] = a1[n] + a2[n];
		n++;

		System.out.println("n is before recurse: " + n);
		RecurseMethod(a1, a2, n, result);
		System.out.println("n is after recurse: " + n);

		return result;
	}

	public static PartialSum addListsFollowUpHelper(LinkedListNode l1, LinkedListNode l2) {
		if (l1 == null && l2 == null)
			return new PartialSum();

		PartialSum sum = addListsFollowUpHelper(l1.next, l2.next);

		int val = sum.carry + l1.value + l2.value;
		
		LinkedListNode head = new LinkedListNode(val%10);
		head.next = sum.sum;
		
		sum.sum = head;
		sum.carry = val/10;
		return sum;
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
