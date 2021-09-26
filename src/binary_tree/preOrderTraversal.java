package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class preOrderTraversal {
//base case: root = null, return (void)
//subproblem: root.left, root.right
//recursion rule: root left right
	public void preOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		System.out.println(root.value);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	//input all the values of the tree to a list in preorder sequence 
	public List<Integer> preOrderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<>();
		if(root == null) {
			return res;
		}
		
		helper(root, res);
		return res;
	}
	
	private void helper(TreeNode root, List<Integer> res) {
		if(root == null) {
			return;
		}
		res.add(root.value);
		helper(root.left, res);
		helper(root.right, res);
	}
	
}
