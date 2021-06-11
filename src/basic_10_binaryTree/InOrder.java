package basic_10_binaryTree;

public class InOrder {
	public void inOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		inOrder(root.left);
		System.out.println(root.value);
		inOrder(root.right);
	}
}
