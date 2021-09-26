package linkedlist;

public class GeneratLinkedList {
	//return the head of the linked list
	//@param n : generate numbers from 0 to n-1
	public ListNode generate(int n) {
		ListNode head = new ListNode(0);
		ListNode cur = head;
		for(int i = 1; i < n;i++) {
			ListNode newNode = new ListNode(i);
			cur.next = newNode;
			cur = cur.next;
		}
		return head;
	}
}
