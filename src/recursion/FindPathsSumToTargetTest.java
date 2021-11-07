package recursion;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

class FindPathsSumToTargetTest {
    @Test
    void test_SeveralPaths() {
        TreeNode oneA = new TreeNode(1);
        TreeNode oneB = new TreeNode(1);
        TreeNode oneC = new TreeNode(1);
        TreeNode oneD = new TreeNode(1);
        TreeNode oneE = new TreeNode(1);
        TreeNode twoA = new TreeNode(2);
        TreeNode twoB = new TreeNode(2);
        TreeNode three = new TreeNode(3);

        oneA.left = oneB;
        oneA.right = twoA;
        oneB.left = twoB;
        oneB.right = oneC;
        twoA.left = three;
        twoA.right = oneD;
        oneC.right = oneE;

        FindPathsSumToTarget binaryTreePathSumToTarget = new FindPathsSumToTarget();
        int target = 4;

        List<List<Integer>> result = binaryTreePathSumToTarget.findPathsSumToTarget(oneA, target);

        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> pathOne = new ArrayList<>();
        List<Integer> pathTwo = new ArrayList<>();
        List<Integer> pathThree = new ArrayList<>();

        pathOne.add(1);
        pathOne.add(1);
        pathOne.add(1);
        pathOne.add(1);

        pathTwo.add(1);
        pathTwo.add(1);
        pathTwo.add(2);

        pathThree.add(1);
        pathThree.add(2);
        pathThree.add(1);

        expected.add(pathOne);
        expected.add(pathTwo);
        expected.add(pathThree);

        Assert.assertEquals(result, expected);
    }
}