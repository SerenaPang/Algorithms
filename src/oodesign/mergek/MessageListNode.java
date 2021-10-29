package oodesign.mergek;
/**
 * This list node contains the time stamp of the message and the message content
 * */
public class MessageListNode {
    int time = 0;
    String message;
    MessageListNode pre;
    MessageListNode next;

    MessageListNode(int time, String message) {
        this.time = time;
        this.message = message;
    }
}
