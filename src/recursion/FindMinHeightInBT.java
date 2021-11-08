package recursion;

public class FindMinHeightInBT {
    public int findMinHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = findMinHeight(root.left);
        }
       if (root.right != null) {
          right = findMinHeight(root.right);
       }
        return Math.min(left,right) + 1;
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

        FindMinHeightInBT m = new FindMinHeightInBT();
        int height = m.findMinHeight(eight);
        System.out.println("The min height of the tree is: " + height);
    }

}
