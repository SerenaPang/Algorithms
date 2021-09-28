package linkedlist;
/**
 * after we found the meeting point, it's not necessary is the staring point
 * so we have to let slow start from head, and fast start from the MEETING POINT we just found
 *
 * and both move forward by 1 step until slow and fast overlap
 *
 * */
public class CycleNodeInLinkedList {

    public static ListNode findCycleHead(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
       // slow = slow.next;
      //  fast = fast.next.next;

        while (slow != null && fast != null) {

            System.out.println("before: slow " + slow.val + " fast " + fast.val);
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println("meet: slow " + slow.val + " fast " + fast.val);
                break;
            }
            System.out.println("after: slow " + slow.val + " fast " + fast.val);
            System.out.println();
        }
        if (slow != fast) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void print(ListNode head) {
       while (head != null) {
           System.out.print(head.val + " ");
           head = head.next;
       }
       System.out.println("Done");
    }
    public static void main(String[] args) {
       ListNode one = new ListNode(1);
       ListNode two = new ListNode(2);
       ListNode three = new ListNode(3);
       ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
       one.next = two;
       two.next = three;
       three.next = four;
       four.next = five;
       five.next = six;
       six.next = three;
       //print(one);
     //  ListNode start =  findCycleHead(one);
        ListNode start =  findCycleHead(two);
       System.out.println("starting node is " + start.val);
    }
}
