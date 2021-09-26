package linkedlist;

public class InsertListNode {
	/**insert a target number into a sorted ascending ordered linked list
	 * in the right position
	 * @param head : head of the linked list
	 * @param target: number to be insert into the linked list
	 */
	public ListNode insert(ListNode head, int target) {
		ListNode newNode = new ListNode(target);
		//case 0: null
		if(head == null) {
			return newNode;
		}
		
		//case 1:  1 2 3 4 insert 0, insert at the beginning
        if (target <= head.val) {
            newNode.next = head;
            return newNode;
        }
		//case 2: 1 2 3 4 insert 5, insert at the end of the list
		ListNode cur = head;
		while(cur != null) {
			cur = cur.next;
		}
		cur.next = newNode;
		
		//case 3: 1 2 4 5 insert 3, insert in the middle
        while (cur.next != null && cur.next.val < target) {
            cur = cur.next;
        }
		newNode.next = cur.next;
		cur.next = newNode;
		return head;
	}

}
