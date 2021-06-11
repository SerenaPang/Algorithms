package a_queue_linkedlist;

public class ReverseLinkedListRecursive {
	
	public static ListNode reverse(ListNode head) {
		//base case
		if(head == null || head.next == null) {
			return head;
		}
		//  1   ->   2   ->   3   ->   null
		// head  head.next
		ListNode newHead = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
	
	public static void print(ListNode head) {
		ListNode cur = head;
		while(cur!= null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}	
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		head.next = one;
		one.next = two;
		two.next = three;
		three.next = four;
		print(head);
		System.out.println();
		ListNode newHead = reverse(head);
		print(newHead);
	}
}
