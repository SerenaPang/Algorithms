package recursion;

public class FindMinElementInBT {
    public int findMin(TreeNode root) {
        int[] globalMin = new int[]{Integer.MAX_VALUE};
        helper(root, globalMin);
        return globalMin[0];
    }

    public void helper(TreeNode root, int[] globalMin) {
        if (root == null) {
            return;
        }
        helper(root.left, globalMin);
        helper(root.right, globalMin);
        if (root.key < globalMin[0]) {
            globalMin[0] = root.key;
        }
    }
    public static void main(String[] args) {
        TreeNode eight = new TreeNode(8);
        TreeNode three = new TreeNode(3);
        TreeNode ten = new TreeNode(10);
        TreeNode one = new TreeNode(1);
        TreeNode six = new TreeNode(6);
        TreeNode fourteen = new TreeNode(14);
        TreeNode four = new TreeNode(4);
        TreeNode seven = new TreeNode(7);
        TreeNode thirteen= new TreeNode(13);

        eight.left = three;
        eight.right = ten;
        three.left = one;
        three.right = six;
        ten.right = fourteen;
        six.left = four;
        six.right = seven;
        fourteen.left = thirteen;

        FindMinElementInBT min = new FindMinElementInBT();
        int minNum = min.findMin(eight);
        System.out.println("The minimun value in this tree is: " + minNum);
    }
}
