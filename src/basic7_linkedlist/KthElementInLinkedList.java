package basic7_linkedlist;

public class KthElementInLinkedList {

	public int count(ListNode head) {
		if(head == null) {
			return 0;
		}
		int count = 0;
		ListNode cur = head;
		while(cur != null) {
			count++;
			cur = cur.next;
		}
		return count;
	}
	
	public ListNode findKthIndex(ListNode head, int k) {
		if(head == null || k < 0) {
			return null;
		}
		
		ListNode cur = head;
		int index = 0;
		while(k != index && cur != null) {
			cur = cur.next;
			index++;
		}
		return cur;
	}
}
