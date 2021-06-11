package a_linked_list;

public class InsertInSortedLinkedList {

public static ListNode insert(ListNode head, int target) {
	ListNode newNode = new ListNode(target); 
	//null
	if(head == null) {
		head = newNode;
		return head;
	}
	
	//num -> null
	if(head.next == null) {
		if(head.value > target) {
			newNode.next = head;
			head = newNode;
		}else {
			head.next = newNode;
		}
	}
	
	ListNode pre = head;
	
	//1 2 3 4   6 8
	//pre
	//insert  5
	
	//1 2 3 5 
	//insert  6
	
	while(pre.next != null && pre.next.value < target) {
		pre = pre.next;
	}
	newNode.next = pre.next;
	pre.next = newNode;
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
	ListNode four = new ListNode(4);
	ListNode six = new ListNode(6);
	ListNode eight = new ListNode(8);
	
	head.next = one;
	one.next = two;
	two.next = three;
	three.next = four;
	four.next = six;
	six.next = eight;
	
	print(head);
	System.out.println();
	ListNode newList = insert(head, 9);
	print(newList);
}
}