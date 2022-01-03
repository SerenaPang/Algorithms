package linkedlist;
/**
 * Given a linked list, check whether it is a palindrome.
 *
 * Examples:
 *
 * Input:   1 -> 2 -> 3 -> 2 -> 1 -> null
 *
 * output: true.
 *
 * Input:   1 -> 2 -> 3 -> null
 *
 * output: false.
 *
 * Requirements:
 *
 * use recursion
 *
 * */
public class CheckIfLinkedListIsPalindrome {


    /**
     * h walk to the end, when poll from the stack, it will return the elements back wards
     * when pop from the stack, compare the current head with the original node
     * when pop from the stack, move the original node forward
     * return to upper level if the previous is equal, if previous return true and the current is true, return true, else false
     *
     * */
    //
    public boolean isPalindrome(ListNode head, ListNode[] original) {
        //1 2 5 4 2 1
        //          h
        //o
        System.out.println("head: " + head.val + " original: " + original[0].val);
        if (head == null) {
            return true;
        }
        //here we iterate the linked list and arrive at the last element
        if (head.next == null) {
            if (head.val == original[0].val) {
                return true;
            } else {
                return false;
            }
        }
        //pass original reference to each level of the recursion
        boolean result = isPalindrome(head.next, original);

        original[0] = original[0].next;
        System.out.println(" original: " + original[0].val);
        return result && head.val == original[0].val;
    }

    public void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode onea = new ListNode(1);
        ListNode twoa = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode twob = new ListNode(2);
        ListNode oneb = new ListNode(1);

        onea.next = twoa;
        twoa.next = three;
        three.next = twob;
        twob.next = oneb;

        CheckIfLinkedListIsPalindrome c = new CheckIfLinkedListIsPalindrome();
        c.print(onea);

       ListNode[] nodes = new ListNode[5];
       nodes[0] = onea;
       nodes[1] = twoa;
       nodes[2] = three;
       nodes[3] = twob;
       nodes[4] = oneb;
       boolean result = c.isPalindrome(onea,nodes);
       System.out.println("result: " + result);
    }

}
