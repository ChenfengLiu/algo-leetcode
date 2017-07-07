package cci_linked_lists;

import cci_linked_lists.ReturnKthToLast_2_2.LinkedListNode;

/**
 * Delete Middle Node: Implement an algorithm to delete a node in the middle
 * (i.e., any node but the first and last node, not necessarily the exact
 * middle) of a singly linked list, given only access to that node.
 * 
 * EXAMPLE
 * 
 * lnput:the node c from the linked list a->b->c->d->e->f
 * 
 * Result: nothing is returned, but the new linked list looks like
 * 
 * a->b->d->e->f
 * 
 * @author chenfeng
 *
 */
public class DeleteMiddleNode_2_3 {

	public static void main(String[] args) {
		// create test case
		LinkedListNode n = new LinkedListNode(1, 0);
		n.next = new LinkedListNode(2, 1);
		n.next.next = new LinkedListNode(3, 2);

		// compute result
		boolean result = deleteNode(n.next);
		System.out.println("result is: " + result);

	}

	public static boolean deleteNode(LinkedListNode n) {
		if (n == null || n.next == null)
			return false;
		LinkedListNode next = n.next;
		n.value = next.value;
		n.next = next.next;
		return true;
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
