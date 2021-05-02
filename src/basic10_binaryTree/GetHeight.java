package basic10_binaryTree;

public class GetHeight {
	public static int getHeight(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		int current = Math.max(leftHeight, rightHeight) + 1;
 		return current;
	}
}
