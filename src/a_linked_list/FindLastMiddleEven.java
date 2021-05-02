package a_linked_list;

public class FindLastMiddleEven {
	//1->2->3->4->null
	//      -
	//    slow
	//             fast
	//fast != null
	
	public ListNode findMiddle(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

}
