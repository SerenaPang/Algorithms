package a_linked_list;

public class FindMiddleNode {
	//1 -> 2 -> 3 -> 4 -> null(even)
	//   slow
	//         fast
	//fast.next.next != null
	
	//1 -> 2 -> 3 -> null(odd)
	//   slow
	//         fast
	//fast.next != null
	
	public ListNode findMiddle(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
