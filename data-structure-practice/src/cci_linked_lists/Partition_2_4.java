package cci_linked_lists;

import cci_linked_lists.DeleteMiddleNode_2_3.LinkedListNode;

/**
 * Partition: Write code to partition a linked list around a value x, such that
 * all nodes less than x come before all nodes greater than or equal to x. If x
 * is contained within the list the values of x only need to be after the
 * elements less than x (see below). The partition element x can appear anywhere
 * in the "right partition"; it does not need to appear between the left and
 * right partitions.
 * 
 * EXAMPLE
 * 
 * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
 * 
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 * 
 * @author chenfeng
 *
 */
public class Partition_2_4 {

	public static void main(String[] args) {
		// create test case
		int[] arr = { 3, 5, 8, 5, 10, 2, 1 };

		LinkedListNode n = new LinkedListNode(arr[0]);
		LinkedListNode head = n;

		for (int i = 1; i < arr.length; i++) {
			n.next = new LinkedListNode(arr[i]);
			n = n.next;
		}

		// compute result
		LinkedListNode result = partition(head, 5);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(result.value);
			result = result.next;
		}

	}

	public static LinkedListNode partition(LinkedListNode node, int x) {
		LinkedListNode head = node;
		LinkedListNode tail = node;

		while (node != null) {
			LinkedListNode next = node.next;
			if (node.value < x) {
				// Insert node before head
				node.next = head;
				head = node;
			} else {
				// Insert node after tail
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;

		return head;
	}

	public static class LinkedListNode {
		LinkedListNode next;
		int value;

		public LinkedListNode(int v) {
			this.value = v;
		}
	}

}
