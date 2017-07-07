package cci_linked_lists;

/**
 * Return Kth to Last: Implement an algorithm to find the kth to last element of
 * a singly linked list.
 * 
 * @author chenfeng
 *
 */
public class ReturnKthToLast_2_2 {

	public static void main(String[] args) {
		// create test case
		LinkedListNode n = new LinkedListNode(1, 0);
		n.next = new LinkedListNode(2, 1);
		n.next.next = new LinkedListNode(3, 2);

		// compute result

		// int result = kthToLast(n, 2);
		int k = 2;
		LinkedListNode result = kthToLastIterative(n, k);
		if (result != null)
			System.out.println(k + "th to last node is: " + result.value);

	}

	public static int kthToLast(LinkedListNode head, int k) {
		if (head == null)
			return -1;
		int index = kthToLast(head.next, k) + 1;
		if (index == k) {
			System.out.println(k + "th to last node is " + head.value);
		}
		return index;

	}

	public static LinkedListNode kthToLastIterative(LinkedListNode head, int k) {
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;

		// move p1 to kth node
		for (int i = 0; i <= k; i++) {
			if (p1 == null)
				return null;
			p1 = p1.next;
		}

		// move p1 and p2 till p1 hits the end
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p2;
	}

	public static class LinkedListNode {
		LinkedListNode next;
		int value;
		int index;

		public LinkedListNode(int v, int index) {
			this.value = v;
		}
	}

}
