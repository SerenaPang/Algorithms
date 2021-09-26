package recursion;

public class ReverseLinkedListInPairs {
    /**
     一对一对反转：
     1-2-3-4-5-null
     2-1-4-3-5-null
     */
    public ListNode reverseInPairs(ListNode head) {
            //base case: when there is nothing left to reverse
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = head.next; //首先要保存头节点的next， 2
            head.next = reverseInPairs(head.next.next); //原来的头节点为1，但反转后要和之后的nodes接上，
            //下一对的原头节点是3，但是这一对也应该被reverse，所以返回的值是4，于是1和4接上
            newHead.next = head;//翻转一对，1-2 变成2-1，2变成了新的头
            return newHead;
    }
}
