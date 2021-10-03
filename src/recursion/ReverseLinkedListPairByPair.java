package recursion;

/**
 *  一对一对反转：
 *      1  -  2  -  3  -  4  -  5  -  null
 *      |     |     \       \
 *      h   h.n    h.n.n
 *      2  -  1  -  4  -  3  -  5  -  null
 *      |     |      |
 *     nh     h     h.n.n
 *
 * 1 和2 这一对要反转成 2 指向 1，所以cur.next的next应该被设置成cur
 * 所以cur.next.next = cur是这么来的
 *
 * 下一步是反转3 和 4 这一对
 * 这是另一个sub problem，而3是现在这一对的头，cur应该为3
 * 所以cur = cur.n.n是这么来的
 *
 * 我们知道1 最终要指向4， 所以cur的next应该设置为4
 * 而4会成为3和4 这一对的new head
 * 所以cur.next = newHead是这么来的
 *
 * base case：当我们到达最后一个node的时候，下一个是null，说明没有node可以被反转了
 * 或者cur自己就是null
 * */
public class ReverseLinkedListPairByPair {
    public static ListNode reverseByPair(ListNode head) {
        //base case
        if (head == null || head.next == null) {
            return head;
        }
        //首先新的头会是第二个node
        ListNode newHead = head.next;
        //head变成第二个node，它的下一个node接的是下一对的头
        head.next = reverseByPair(head.next.next);
        //把第一个node 和第二个node反转
        newHead.next = head;
        //最后返回的是新的头
        return newHead;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
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
        print(one);


    }

}
