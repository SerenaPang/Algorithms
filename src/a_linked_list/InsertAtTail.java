package a_linked_list;

public class InsertAtTail {
	public static ListNode insert(ListNode head, int target) {
		//null 
		ListNode newNode = new ListNode(target);
		if(head == null) {
			 head = newNode;
			 return head;
		}
		//1 -> null
		if(head.next == null) {
			head.next = newNode;
			return head;
		}
		
		//1 -> 2 -> 3 -> null
		ListNode cur = head;
		while(cur.next != null) {
			cur = cur.next;
		}
		cur.next = newNode;
		return head;
	}
	
	public static void print(ListNode head) {
		ListNode cur = head;
		while(cur!= null){
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		
		head.next = one;
		one.next = two;
		two.next = three;
		
		print(head);
		System.out.println();
		ListNode newList = insert(head, 4);
		print(newList);
	}
}
