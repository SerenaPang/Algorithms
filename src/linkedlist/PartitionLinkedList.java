package linkedlist;

public class PartitionLinkedList {
	//smaller than target on the left, greater than the target on the right
	public static ListNode partition(ListNode head, int target) {
		//creat dummy nodes for 2 linked list
		ListNode smaller = new ListNode(0);
		ListNode larger = new ListNode(0);
		
		//populate linked lists
		//5 1 7 3 6 10 2
		//       4 
		
		ListNode cur = head;
		ListNode smallCur = smaller;
		ListNode largeCur = larger;
		while(cur != null) {
			if(cur.val <= target) {
				smallCur.next = cur;
				smallCur = smallCur.next;
			}else {
				largeCur.next = cur;
				largeCur = largeCur.next;
			}
			cur = cur.next;
		}
		//concatenate linked lists
		smallCur.next = larger.next;
		largeCur.next = null;
		return smaller.next;
	}
	
	public static void print(ListNode head) {
		ListNode cur = head;
		while(cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(5);
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(7);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(6);
		ListNode six = new ListNode(10);
		ListNode eight = new ListNode(2);
		
		head.next = one;
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = six;
		six.next = eight;
		
		print(head);
		System.out.println();
		int target = 4;
		ListNode newList = partition(head, target);
		print(newList);
		
	}
}
