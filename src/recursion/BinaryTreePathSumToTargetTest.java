package recursion;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

class BinaryTreePathSumToTargetTest {

    @Test
    void test_OnePath() {
        TreeNode eight = new TreeNode(8);
        TreeNode three = new TreeNode(3);
        TreeNode ten = new TreeNode(10);
        TreeNode one = new TreeNode(1);
        TreeNode six = new TreeNode(6);
        TreeNode fourteen = new TreeNode(14);
        TreeNode four = new TreeNode(4);
        TreeNode seven = new TreeNode(7);
        TreeNode thirdteen= new TreeNode(13);

        eight.left = three;
        eight.right = ten;
        three.left = one;
        three.right = six;
        ten.right = fourteen;
        six.left = four;
        six.right = seven;
        fourteen.left = thirdteen;

        BinaryTreePathSumToTarget binaryTreePathSumToTarget = new BinaryTreePathSumToTarget();
        int target = 21;
        List<Integer> result = binaryTreePathSumToTarget.findPathSumToTarget(eight, target);

        List<Integer> expected = new ArrayList<>();
        expected.add(8);
        expected.add(3);
        expected.add(6);
        expected.add(4);

        Assert.assertEquals(result, expected);
    }


    @Test
    void test_SeveralPaths() {


    }
}