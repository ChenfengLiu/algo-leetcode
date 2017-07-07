package cci_linked_lists;

import cci_linked_lists.DeleteMiddleNode_2_3.LinkedListNode;

/**
 * Intersection: Given two (singly) linked lists, determine if the two lists
 * intersect. Return the inter­ secting node. Note that the intersection is
 * defined based on reference, not value. That is, if the kth node of the first
 * linked list is the exact same node (by reference) as the jth node of the
 * second linked list, then they are intersecting.
 * 
 * @author chenfeng
 *
 */
public class Intersection_2_7 {

	public static void main(String[] args) {
		// create test case
		LinkedListNode l1 = new LinkedListNode(7);
		l1.next = new LinkedListNode(2);
		l1.next.next = new LinkedListNode(1);

		LinkedListNode l2 = new LinkedListNode(3);
		l2.next = new LinkedListNode(1);
		l2.next.next = new LinkedListNode(5);
		l2.next.next.next = new LinkedListNode(9);
		l2.next.next.next.next = l1;

		LinkedListNode l3 = new LinkedListNode(4);
		l3.next = new LinkedListNode(6);
		l3.next.next = l1;

		// compute result
		LinkedListNode result = findIntersection(l2, l3);
		System.out.println("result is: " + result.value);
	}

	public static LinkedListNode findIntersection(LinkedListNode l1, LinkedListNode l2) {
		if (l1 == null && l2 == null)
			return null;

		// find tail and list size
		ListWrapper lw1 = getTailAndSize(l1);
		ListWrapper lw2 = getTailAndSize(l2);

		// if tails are different, no intersection
		if (lw1.tail != lw2.tail)
			return null;

		// set point to the heads
		LinkedListNode shorter = lw1.size < lw2.size ? l1 : l2;
		LinkedListNode longer = lw1.size < lw2.size ? l2 : l1;

		// longer pointer step forward
		int l = Math.abs(lw1.size - lw2.size);
		longer = getKthNode(longer, l);

		// Move both pointers until collision occurs
		while (shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}

		return longer;
	}

	public static LinkedListNode getKthNode(LinkedListNode n, int k) {
		LinkedListNode c = n;
		while (k > 0 && c != null) {
			c = c.next;
			k--;
		}
		return c;
	}

	public static ListWrapper getTailAndSize(LinkedListNode l) {
		if (l == null)
			return null;

		int size = 1;
		LinkedListNode n = l;
		while (n.next != null) {
			size++;
			n = n.next;
		}
		return new ListWrapper(n, size);
	}

	public static class ListWrapper {
		LinkedListNode tail;
		int size;

		public ListWrapper(LinkedListNode t, int s) {
			tail = t;
			size = s;
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
