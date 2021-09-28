package linkedlist;

public class FindMiddleOdd {
//1 -> 2 -> 3 -> null
//   slow
//         fast
//fast.next != null

	public ListNode findMiddle(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
