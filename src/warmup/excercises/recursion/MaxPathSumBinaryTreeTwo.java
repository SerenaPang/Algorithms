package warmup.excercises.recursion;
/**
 * Given a binary tree in which each node contains an integer number. Find the maximum possible sum from any node to any node (the start node and the end node can be the same).
 *
 * Assumptions
 *
 * ​The root of the given binary tree is not null
 * Examples
 *
 *    -1
 *
 *   /    \
 *
 * 2      11
 *
 *      /    \
 *
 *     6    -14
 *
 * one example of paths could be -14 -> 11 -> -1 -> 2
 *
 * another example could be the node 11 itself
 *
 * The maximum path sum in the above binary tree is 6 + 11 + (-1) + 2 = 18
 *
 * How is the binary tree represented?
 *
 * We use the level order traversal sequence with a special symbol "#" denoting the null node.
 *
 * For Example:
 *
 * The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
 *
 *     1
 *
 *   /   \
 *
 *  2     3
 *
 *       /
 *
 *     4
 *
 * */
public class MaxPathSumBinaryTreeTwo {
    /**
     * for every node, it received the max sum from the sub tree, which means it has to calculate the
     * max path with the result of the right node or the left node, and
     * we have to choose the left or right side, if one of the side generates negative result
     * we don't include it in the path,
     */
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        helper(root, max);
        return max[0];
    }

    public int helper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, max);
        int right = helper(root.right, max);
        left = left < 0 ? 0 : left;
        right = right < 0 ? 0 : right;
        max[0] = Math.max(root.value + right + left, max[0]);
        return root.value + Math.max(left, right);
    }

}
