package class10_0421;

public class CheckIfBalanced {
	public static boolean checkBalanced(TreeNode root) {
		if(root == null) {
			return true;
		}
		boolean left = checkBalanced(root.left);
		boolean right = checkBalanced(root.right);
		
		int leftHeight = GetHeight.getHeight(root.left);
		int rightHeight = GetHeight.getHeight(root.right);
		
		if(!left || !right) {
			return false;
		}
		
		if(Math.abs(leftHeight - rightHeight) > 1) {
			return false;
		}
		
		return true;
	}
	
	public static int getHeightOrUnbalance(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int leftHeight = getHeightOrUnbalance(root.left);
		int rightHeight = getHeightOrUnbalance(root.right);
		
		if(leftHeight == -1 || rightHeight == -1) {
			return -1;
		}
		
		if(Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public static boolean ifBalance(TreeNode root) {
		return getHeightOrUnbalance(root) >= 0;
	}
}
