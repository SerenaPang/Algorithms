package stack;


import linkedlist.ImplementSinglyLinkedList;
import linkedlist.ListNode;

//    append head
//   321
//   pop
//  2 1
public class ImplementStack {

    ImplementSinglyLinkedList stack = new ImplementSinglyLinkedList();

    public void offer(int val) {
        stack.appendHead(val);
    }

    public int size() {
        return stack.size();
    }

    public ListNode peek() {
        return stack.getHead();
    }

    public void pop() {
        stack.delete(0);
    }

}
