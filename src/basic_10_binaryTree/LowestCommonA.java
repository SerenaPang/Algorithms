package basic_10_binaryTree;

public class LowestCommonA {
	
	/**
	 * 			5
	 * 		9		12
	 *  2      3         14
	 * 
	 * */
	
	public static TreeNode findLCA(TreeNode one, TreeNode two) {
		//case 1: one and two are not in the same subtree, return the lowest root
		//case 2: one is the ancestor of two, return one
		//case3: two is the ancestor of one, return two
		//corner case: 1.one or two are null return null
		//2. one and two are the same nodes return one||two
		if(one == null || two == null) {
			return null;
		}
		if(one == two) {
			return one;
		}
		
		TreeNode[] node1 = {one};
		System.out.println("node1: ");
		System.out.println(node1[0].value);
		
		
		TreeNode[] node2 = {two};
		System.out.println("node2: ");
		System.out.println(node2[0].value);
		int depthOne = getDepth(node1);
		int depthTwo = getDepth(node2);
		if(node1[0] != node2[0]) {
			return null;
		}
		//note: depth deeper means node is lower
		//two is ancestor of one or they have the same ancestor
		if(depthOne >= depthTwo) {
			return getLCA(one, two, depthOne - depthTwo);
		}else {//one is the ancestor of two
			return getLCA(two, one, depthTwo - depthOne);
		}
	}
	
	public static TreeNode getLCA(TreeNode lowerNode, TreeNode higherNode, int depthDifference) {
		System.out.println("Depth Difference: " + depthDifference);
		//go down until we found the deepest node
		while(depthDifference > 0) {
			lowerNode = lowerNode.parent;
			depthDifference--;
		}
		//go up until they are at the same level is when the found the common ancestor
		while(lowerNode != higherNode) {
			lowerNode = lowerNode.parent;
			higherNode = higherNode.parent;
		}
		return lowerNode;//the parent location
	}
	
	public static void printAsArray(TreeNode[] nodes) {
		for(int i = 0; i < nodes.length; i++) {
			System.out.print(nodes[i].value + " ");
		}
	}

	public static void print(TreeNode root) {
		if(root == null) {
			return;
		}		
		print(root.left);
		System.out.print(root.value + " ");
		print(root.right);
	}
	
	private static int getDepth(TreeNode[] node) {
		int count = 1;
		while(node[0].parent != null) {
			node[0] = node[0].parent;
			count++;
		}
		return count;
	}
	
public static void main(String[] args) {
	//5 9 12 2 3 14
	TreeNode a = new TreeNode(5);
	TreeNode b = new TreeNode(9);
	TreeNode c = new TreeNode(12);
	TreeNode d = new TreeNode(2);
	TreeNode e = new TreeNode(3);
	TreeNode f = new TreeNode(14);
	
	a.left = b;
	b.left = d;
	b.right = e;
	a.right = c;
	c.right = f;
	
	b.parent = a;
	c.parent = a;
	d.parent = b;
	e.parent = b;
	f.parent = c;
	//print(a);
	TreeNode[] node1 = {f};//14
	TreeNode[] node2 = {d};//2
	System.out.println("print node1");
	printAsArray(node1);
	System.out.println();
	int depth1 = getDepth(node1);
	int depth2 = getDepth(node2);
	System.out.println("Depth of " +  f.value + ": " + depth1);
	System.out.println("Depth of " +  d.value + ": " + depth2);
	System.out.println("The LCA for the two nodes is: " + findLCA(f, d).value);

}

}
