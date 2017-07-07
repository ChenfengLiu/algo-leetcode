package cci_linked_lists;

import cci_linked_lists.Intersection_2_7.LinkedListNode;

/**
 * Loop Detection: Given a circular linked list, implement an algorithm that
 * returns the node at the beginning of the loop.
 * 
 * DEFINITION
 * 
 * Circular linked list: A (corrupt) linked list in which a node's next pointer
 * points to an earlier node, so as to make a loop in the linked list.
 * 
 * EXAMPLE
 * 
 * Input: A -> B -> C -> D -> E -> C [the same C as earlier]
 * 
 * Output: C
 * 
 * 
 * @author chenfeng
 *
 */
public class LoopDetection_2_8 {

	public static void main(String[] args) {
		// create test case
		LinkedListNode loop = new LinkedListNode(9);
		loop.next = new LinkedListNode(2);
		loop.next.next = new LinkedListNode(1);
		loop.next.next.next = loop;

		LinkedListNode l2 = new LinkedListNode(3);
		l2.next = new LinkedListNode(1);
		l2.next.next = new LinkedListNode(5);
		l2.next.next.next = new LinkedListNode(9);
		l2.next.next.next.next = loop;

		// compute result
		LinkedListNode result = findLoopHead(l2);
		System.out.println("loop head is: " + result.value);

	}

	public static LinkedListNode findLoopHead(LinkedListNode l1) {
		// use fast runner and slow runner method
		LinkedListNode slow = l1, fast = l1;

		// find meeting point
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}
		
		// no meeting point means no loop
		if(fast == null || fast.next == null) return null;
		
		//reset slow to head. Both slow and fast are k steps from the loop head
		slow = l1; 
		while(slow!=fast){
			slow = slow.next;
			fast = fast.next;
		}

		return fast;
	}

	public static class LinkedListNode {
		LinkedListNode next;
		int value;

		public LinkedListNode(int v) {
			this.value = v;
		}
	}

}
