package a_binary_tree;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {
	public void postOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.value);
	}
	
	public List<Integer> postOrderTraversal(TreeNode root){
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
		helper(root.right, res);
		res.add(root.value);
	}
}
