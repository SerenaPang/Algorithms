package recursion;

public class FindMaxElementInBT {
    public int findMax(TreeNode root) {
        int[] globalMax = new int[1];
        globalMax[0] = Integer.MIN_VALUE;
        helper(root, globalMax);
        return globalMax[0];
    }

    public void helper(TreeNode root, int[] globalMax) {
        if (root == null) {
            return ;
        }
        helper(root.left, globalMax);
        System.out.println(root.key);

        if (root.key > globalMax[0]) {
            globalMax[0] = root.key;
        }
        helper(root.right, globalMax);
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

        FindMaxElementInBT m = new FindMaxElementInBT();
        int result = m.findMax(eight);
        System.out.println("The max number in this tree is: " + result);
    }
}
