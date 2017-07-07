package pac1;

public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode c1 = l1;
		c1.next = new ListNode(4);
		c1 = c1.next;
		c1.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		ListNode c2 = l2;
		c2.next = new ListNode(6);
		c2 = c2.next;
		c2.next = new ListNode(4);

		System.out.println("l1: " + printListNode(l1));
		System.out.println("l2: " + printListNode(l2));
		
		System.out.println(printListNode(addTwoNumbers(l1,l2)));

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode resultcopy = result;
		int sum = 0;
		while (l1 != null || l2 != null) {

			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}

			resultcopy.next= new ListNode(sum % 10);
			resultcopy = resultcopy.next;
			sum /= 10;

		}
		if(sum == 1){
			resultcopy.next = new ListNode(1);
		}
		return result.next;
	}

	public static String printListNode(ListNode l) {
		String result = "[ ";
		while (l.next != null) {
			result += l.val + ", ";
			l = l.next;
		}
		result += l.val + " ]";
		return result;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
