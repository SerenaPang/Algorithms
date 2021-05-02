package basic9_linkedlist;

public class ReverseLinkedList {
	//Iterative
	public ListNode reverse(ListNode head) {
		if(head == null) {
			return null;
		}
		ListNode pre = null;
		ListNode cur = head;
		while(cur != null) {
			ListNode nxt = cur.next;
			//record cur.next
			cur.next = pre;
			//assign cur.next to previous node so that it exchange position
			pre = cur; 
			cur = nxt;
		}
		return pre;
	}
		
	//Recursive
	public ListNode reverseRecursive(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode newHead = reverseRecursive(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}	
}
