package a_linked_list;

public class hasCycle {
	 public boolean hasCycle(ListNode head) {
		 if(head == null) {
			 return false;
		 }
		 ListNode slow = head;
		 ListNode fast = head;
		 while(fast != null && fast.next != null) {
			 slow = slow.next;
			 fast = fast.next.next;
			 if(slow == fast) {
				 return true;
			 }
		 }
		 return false;
	 }

}
