package recursion;

public class ReverseBinaryTreeUpsideDown {

    /**
     * 除了subproblem，在当前层如何反转？
     * root的左孩子的左孩子指向root
     */
    public class Solution {
        public TreeNode reverse(TreeNode root) {
            if (root == null || root.left == null) {
                return root;
            }

            TreeNode newRoot = reverse(root.left);
            root.left.right = root.right;
            root.left.left = root;
            root.left = null;
            root.right = null;
            return newRoot;
        }
    }
}

