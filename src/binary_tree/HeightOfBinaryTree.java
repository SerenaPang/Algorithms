package binary_tree;

public class HeightOfBinaryTree {
//base case: root == null
//subproblem: root.left root.right
//recursion rule: Math.max(root.left, root.right) + 1
	
	public int getHeight(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		return Math.max(left, right) + 1;
	}
}
