package basic_10_binaryTree;

public class preOrder {
	public void preOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		
		if(root.left == null && root.right == null) {
			System.out.println(root.value);
			return;
		}
		
		System.out.println(root.value);
		preOrder(root.left);
		preOrder(root.right);
	}
}
