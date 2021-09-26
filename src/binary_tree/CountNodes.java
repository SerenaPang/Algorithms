package binary_tree;

public class CountNodes {
	//base case: when root is null, return 0
	//subproblem: root.left root.right
	//recursion rule: left + right + 1
	
	public int countNodes(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int right = countNodes(root.right);
		int left = countNodes(root.left);
		return right + left + 1;
	}

}
