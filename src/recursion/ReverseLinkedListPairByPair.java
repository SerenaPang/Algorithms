package recursion;
/**
 *  一对一对反转：
 *      1  -  2  -  3  -  4  -  5  -  null
 *      |     |     \       \
 *      cur   cur.n  cur.n.n  cur.n.n.n
 *      2  -  1  -  4  -  3  -  5  -  null
 *      |           |
 *     head         newH
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


}
