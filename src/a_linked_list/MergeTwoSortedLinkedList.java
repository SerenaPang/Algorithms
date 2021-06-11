package a_linked_list;

public class MergeTwoSortedLinkedList {
	
	public static ListNode merge(ListNode one, ListNode two) {
	
		ListNode newList = new ListNode(0);
		ListNode cur = newList;
	
		//compare nodes in 2 lists and populate new list
		while(one != null && two != null) {
			if(one.value <= two.value) {
				cur.next = one;
				one = one.next;
			}else {
				cur.next = two;
				two = two.next;
			}
			cur = cur.next;
		}
		//post processing
		//one:1 2 3 4 two:5 6 7 8
		//new List: 1 2 3 4, all elements in two are left
		if(one != null) {
			cur.next = one;
		}else{
			cur.next = two;
		}
		return newList.next;
	}
	
	public static void print(ListNode head) {
		ListNode cur = head;
		while(cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
	}
	
	public static void main(String[] args) {
		//list one
		ListNode one = new ListNode(1);
		ListNode seven = new ListNode(7);
		ListNode three = new ListNode(3);
		ListNode six = new ListNode(6);
		ListNode ten = new ListNode(10);
		ListNode eight = new ListNode(8);
		
		one.next = seven;
		seven.next = three;
		three.next = six;
		six.next = ten;
		ten.next = eight;
		System.out.println("List one: ");
		print(one);
		System.out.println();
		
		//list two
		ListNode two = new ListNode(5);
		ListNode sevenTeen = new ListNode(17);
		ListNode twentyThree = new ListNode(23);
		ListNode four = new ListNode(4);
		ListNode zero = new ListNode(0);
		ListNode nine = new ListNode(9);
		ListNode threeRep = new ListNode(3);
		
		two.next = sevenTeen;
		sevenTeen.next = twentyThree;
		twentyThree.next = four;
		four.next = zero;
		zero.next = nine;
		nine.next = threeRep;
		
		System.out.println("List two: ");
		print(two);
		
		System.out.println();
		System.out.println("Merge: ");
	//	ListNode newList = merge(one, two);
		print(merge(one, two));
		System.out.println("here");
	}
}
