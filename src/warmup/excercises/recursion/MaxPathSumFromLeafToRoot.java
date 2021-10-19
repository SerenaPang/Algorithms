package warmup.excercises.recursion;
/**
 * Given a binary tree in which each node contains an integer number. Find the maximum possible path sum from a leaf to root.
 *
 *
 * Assumptions
 * The root of given binary tree is not null.
 *
 *
 * Examples
 *
 *
 *          10
 *        /    \
 *      -2      7
 *     /  \
 *    8   -4
 * The maximum path sum is 10 + 7 = 17.
 *
 * */
public class MaxPathSumFromLeafToRoot {
    /**
     * current level:calculate the sum of left and right subtree
     * How do we make sure it's a leaf node not a parent node?
     * - we have to check if root.left && root.right are null
     * */
    public int maxPathSumLeafToRoot(TreeNode root) {
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
        int currentMaxSum = Math.max(right, left);
        max[0] = Math.max(currentMaxSum + root.value, max[0]);
        return Math.max(left, right) + root.value;
    }

}
