package cci_linked_lists;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Remove Dups! Write code to remove duplicates from an unsorted linked list.
 * How would you solve this problem if a temporary buffer is not allowed?
 * 
 * @author chenfeng
 *
 */
public class RemoveDups_2_1 {

	public static void main(String[] args) {
		// create test case
		LinkedList<Integer> ll = new LinkedList<>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(3);
		ll.add(1);
		
		// compute result
		LinkedList<Integer> result = RemoveDups(ll);
		System.out.println(Arrays.toString(result.toArray()));

	}

	public static LinkedList<Integer> RemoveDups(LinkedList<Integer> ll) {
		HashSet<Integer> set = new HashSet<>();
		LinkedList<Integer> result = new LinkedList<>();
		
		while (!ll.isEmpty()) {
			if (set.contains(ll.get(0))) {
				ll.remove(0);
			} else{
				set.add(ll.get(0));
				result.add(ll.get(0));
				ll.remove(0);
			}
		}

		return result;
	}
}
