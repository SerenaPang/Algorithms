package linkedlist;

/**
 * appendHead(int val)
 * appendTail(int val)
 * delete(int index)
 * delete(int val)
 * size()
 * getHead()
 * getTail()
 * */
public class ImplementSinglyLinkedList {
        ListNode head;
        ListNode tail;
        int size;
        public ImplementSinglyLinkedList(){
            head = null;
            tail = null;
            size = 0;
        }
        // null
        // 1
        //2
        public ListNode appendHead(int val) {
            ListNode newNode = new ListNode(val);
            size++;
            if (head == null) {
                head = newNode;
                return head;
            } else {
                newNode.next = head;
                head = newNode;
            }

            return head;
        }
        //null
        public ListNode appendTail(int val){
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
                size++;
                return head;
            } else {
                ListNode cur = head;
                while(cur.next != null) {
                    cur = cur.next;
                }
                cur.next = newNode;
                size++;
            }
            return head;
        }

        public int size(){
            return size;
        }


        public ListNode delete(int val) {
            ListNode cur = head;
            ListNode pre = null;
            if (cur != null && cur.val == val) {
                cur = cur.next;
                head = cur;
                size--;
                return head;
            } else{
                 while (cur != null && cur.val != val) {
                     pre = cur;
                     cur = cur.next;
             }
                    pre.next = cur.next;
             }
            size--;
            return head;
        }

        public ListNode getHead(){
                return head;
        }

        public ListNode getTail(){
            if (head == null) {
                return null;
            } else {
                ListNode cur = head;
                while (cur.next != null) {
                    cur = cur.next;
                }
                tail = cur;
            }
            return tail;
        }

        public void print() {
            while (head != null) {
                System.out.print(head.val + " ");
                head = head.next;
            }
        }
    public static void main(String[] args) {
        ImplementSinglyLinkedList linkedList = new ImplementSinglyLinkedList();
        linkedList.appendHead(1);
      //  linkedList.appendHead(1);
        linkedList.appendHead(2);
        linkedList.appendHead(3);
        linkedList.appendHead(4);

        linkedList.appendTail(5);
        linkedList.appendTail(6);

       // linkedList.delete(1);
        linkedList.delete(4);
        linkedList.delete(3);
        linkedList.delete(6);

        int size = linkedList.size();
        System.out.println("size: " + size);
        linkedList.print();
     //   ListNode head = linkedList.getHead();
       // System.out.println("head: " + head.val);

     //   ListNode tail = linkedList.getTail();
      //  System.out.println("tail: " + tail.val);

    }
}
