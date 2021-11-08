package recursion;

public class FindMaxHeightInBT {

    public int findMaxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findMaxHeight(root.left);
        int right = findMaxHeight(root.right);
        return Math.max(left, right) + 1;
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
   //     TreeNode thirteen= new TreeNode(13);

        eight.left = three;
        eight.right = ten;
        three.left = one;
        three.right = six;
        ten.right = fourteen;
        six.left = four;
        six.right = seven;
      //  fourteen.left = thirteen;

        FindMaxHeightInBT m = new FindMaxHeightInBT();
        int height = m.findMaxHeight(eight);
        System.out.println("The max height of the tree is: " + height);
    }
}
