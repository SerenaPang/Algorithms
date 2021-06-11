package basic_10_binaryTree;

public class CountNodes {
	public int countNodes(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = countNodes(root.left);
		int right = countNodes(root.right);
		return 1 + left + right;
	}
}
