package binary.tree;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
	//visit sequence: left root right
	
	//base case: root == null 
	//subproblem: root.left root.right
	//recursive rule: left root right
	public void inOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		
		inOrder(root.left);
		System.out.println(root.value);
		inOrder(root.right);
	}
	
	//return the list of keys of each node in the tree
	public List<Integer> inOrderTraversal(TreeNode root){
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
		helper(root.left, res);
		res.add(root.value);
		helper(root.right, res);
	}
	
	

}
