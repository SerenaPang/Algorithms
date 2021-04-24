package class9_0419;

import class7_0414.ListNode;

public class MergeTwoSortedLinkdeList {
	//Merge with dummy head
	public ListNode merge1(ListNode head1, ListNode head2) {
		ListNode dummy = new ListNode(0); // dummy head
		ListNode cur = dummy;
		ListNode cur1 = head1;
		ListNode cur2 = head2;
		
		while(cur1 != null && cur2 != null) {
			if(cur1.value <= cur2.value) {
				cur.next = cur1;
				cur = cur.next;
				cur1 = cur1.next;
			}else {
				cur.next = cur2;
				cur = cur.next;
				cur2 = cur2.next;
			}
		}
		//post processed
		if(cur1 == null) {
			cur.next = cur2;
		}
		
		if(cur2 == null) {
			cur.next = cur1;
		}
		
		return dummy.next;
	}
	
	//Merge without dummy head
	public ListNode merge2(ListNode head1, ListNode head2) {
		ListNode head;
		if(head1 == null) {
			return head2;
		}
		if(head2 == null) {
			return head1;
		}
		if(head1.value < head2.value) {
			head = head1;
			head1 = head1.next;
		}else {
			head = head2;
			head2 = head2.next;
		}
		
		ListNode cur = null;
		ListNode cur1 = head1;
		ListNode cur2 = head2;
		while(cur1 != null && cur2 != null) {
			if(cur1.value <= cur2.value) {
				cur.next = cur1;
				cur = cur.next;
				cur1 = cur1.next;
			}else {
				cur.next = cur2;
				cur = cur.next;
				cur2 = cur2.next;
			}
		}
		if(cur1 == null) {
			cur.next = cur2;
		}
		if(cur2 == null) {
			cur.next = cur1;
		}
		return head;
	}
}
