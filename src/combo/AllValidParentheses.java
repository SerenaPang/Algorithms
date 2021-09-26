package combo;

import java.util.ArrayList;
import java.util.List;

/**
 * 9:33 - 9:38
 * 4:50 - 5:20
 * 8:41- 9:00
 * input: n pairs of "()"
 * output: valid paren -> "(()())" "((()))" "()"
 * not valid -> "(((()" ")("
 * <p>
 * recursion tree:
 * 先加左括号然后再抵消
 * recursion tree：
 * n pairs n *2 positions：
 * how many level：number of positions
 * 每层几个状态？2个，不是"（" 就是 "）"
 * 需要剪枝：if invalid。。。
 * 什么时候可以加左括号：只要有左就加
 * 什么时候可以加右括号：左大于右
 * <p>
 * number of the left paren matches the number of right paren
 * 左手至少有一个多的（ 去match 右边的）
 * base case: iterate though all parent til no paren is left
 * <p>
 * TC: O(n^2) because we have the recursion tree n levels and each level we have 2 options
 * SC: O(n) we have created an array of size 2 * n pairs
 */
public class AllValidParentheses {

    public List<String> validParen(int k) {
        List<String> result = new ArrayList<String>();
        char[] cur = new char[k * 2];//positions avaliable
        helper(cur, k, k, 0, result);
        return result;
    }

    public void helper(char[] cur, int left, int right, int index, List<String> result) {
        //when left and right paren are both consumed
        if (left == 0 && right == 0) {
            result.add(new String(cur));
            return;
        }
        //when there are more left paren to put in the array
        if (left > 0) {
            cur[index] = '(';
            helper(cur, left - 1, right, index + 1, result);
        }
        /**when there are more left paren than right paren
         because every time we put 1 left paren, we decrement left by 1
         so when we have less left means we have put more left in the array
         and that's when we can put right paren, because we need more left paren to match with
         the right paren
         */
        if (right > left) {
            cur[index] = ')';
            helper(cur, left, right - 1, index + 1, result);
        }

    }

}
