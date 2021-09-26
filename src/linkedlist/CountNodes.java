package linkedlist;

public class CountNodes {
	public static int count(ListNode head) {
		int count = 0;
		ListNode cur = head;
		while(cur != null) {
			count++;
			cur = cur.next;
		//	count++;
		//it's the same to put count++ before or after line 9
		}
		return count;
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
		int count = count(head);
		System.out.println("count: " + count);
	}
}
