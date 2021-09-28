package linkedlist;

public class FindMiddleEven {
	//1 -> 2 -> 3 -> 4 -> null
	//    slow
	//         fast 
	//fast.next.next != null
	public ListNode findMiddle(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}		
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
