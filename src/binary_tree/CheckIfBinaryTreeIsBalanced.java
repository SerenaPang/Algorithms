package binary_tree;

public class CheckIfBinaryTreeIsBalanced {
	//return height or unbalanced(-1)
	//sanity check: root == null, return 0
	//base case: root == null
	//subproblem: left subtree is balanced, right subtree is balanced
	//balanced definition: the height of right and left < than 1
	
	//get height of left and right
	//compare difference
	
	public int getHeigtOrUnbalance(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int left = getHeigtOrUnbalance(root.left);
		int right = getHeigtOrUnbalance(root.right);
		
		if(left == -1 || right == -1) {
			return -1;
		}
		if(Math.abs(right) - Math.abs(left) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}
	
	
	
	public int getHeight(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		return Math.max(left, right) + 1;
	}

}
