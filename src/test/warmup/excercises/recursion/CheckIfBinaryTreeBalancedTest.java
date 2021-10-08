package test.warmup.excercises.recursion;

import org.junit.jupiter.api.Test;
import org.testng.Assert;
import warmup.excercises.recursion.CheckIfBinaryTreeIsBalanced;
import warmup.excercises.recursion.TreeNode;

public class CheckIfBinaryTreeBalancedTest {
    @Test
    public void testGetHeight() throws Exception{
        CheckIfBinaryTreeIsBalanced bt = new CheckIfBinaryTreeIsBalanced();

        TreeNode five = new TreeNode(5);
        TreeNode three = new TreeNode(3);
        TreeNode eight = new TreeNode(8);
        TreeNode one = new TreeNode(1);
        TreeNode four = new TreeNode(4);
        TreeNode eleven = new TreeNode(11);

        five.left = three;
        five.right = eight;
        three.left = one;
        three.right = four;
        eight.right = eleven;

        int height = bt.getHeight(five);
        Assert.assertEquals(height, 3);
    }

    @Test
    public void testIfBalanced() throws Exception{
        CheckIfBinaryTreeIsBalanced binaryTree = new CheckIfBinaryTreeIsBalanced();

        TreeNode five = new TreeNode(5);
        TreeNode three = new TreeNode(3);
        TreeNode eight = new TreeNode(8);
        TreeNode one = new TreeNode(1);
        TreeNode four = new TreeNode(4);
        TreeNode eleven = new TreeNode(11);

        five.left = three;
        five.right = eight;
        three.left = one;
        three.right = four;
        eight.right = eleven;

        boolean isBalanced = binaryTree.isBalanced(five);
        Assert.assertEquals(isBalanced,true);
    }

    @Test
    public void testNotBalanced() throws Exception{
        CheckIfBinaryTreeIsBalanced binaryTree = new CheckIfBinaryTreeIsBalanced();

        TreeNode five = new TreeNode(5);
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1);
        TreeNode four = new TreeNode(4);

        five.left = three;
        three.left = one;
        three.right = four;

        boolean isBalanced = binaryTree.isBalanced(five);
        Assert.assertEquals(isBalanced,false);
    }



}
