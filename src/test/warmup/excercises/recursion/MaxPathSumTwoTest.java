package test.warmup.excercises.recursion;

import org.junit.jupiter.api.Test;
import org.testng.Assert;
import warmup.excercises.recursion.MaxPathSumBinaryTreeTwo;
import warmup.excercises.recursion.TreeNode;

public class MaxPathSumTwoTest {
    @Test
    public void testMaxSum() throws Exception{
        MaxPathSumBinaryTreeTwo maxSum = new MaxPathSumBinaryTreeTwo();
        TreeNode a = new TreeNode(-1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(11);
        TreeNode d = new TreeNode(6);
        TreeNode e = new TreeNode(-14);

        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;

        Assert.assertEquals(maxSum.maxPathSum(a), 18);
    }

}
