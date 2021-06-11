package a_queue_linkedlist;

public class ReverseLinkedListIterative {
	//1 -> 2 -> 3 -> 4 -> null
//pre cur nxt
	
//store nxt and let cur points to pre
//update pre and cur: pre = cur,  cur = nxt
//repeat until cur == null
//return pre becuase pre has reach to the end of the list which becomes the head of the list after reverse
	
	public static ListNode reverse(ListNode head) {
		//sanity check
		if(head == null || head.next == null) {
			return head;
		}
		ListNode cur = head;
		ListNode pre = null;
		ListNode nxt = null;
		
		while(cur != null) {
			nxt = cur.next;//store 2
			cur.next = pre;//1 points to null
			pre = cur;//move pre to 1
			cur = nxt;//move current to 2
		}
		return pre;
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
