package recursion;

import java.util.ArrayList;
import java.util.List;

public class FindPathsSumToTarget {

    /**
     * This function is going to find paths that are sum to target(if there are paths)
     * */
    public List<List<Integer>> findPathsSumToTarget(TreeNode root, int target){
        System.out.println("JTesting");
        List<List<Integer>> paths= new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        helper(root,target, 0, path,paths);
        return paths;
    }

    /**
     * helper function to find paths that each of them sums to target
     * */
    public boolean findPathsHelper(TreeNode root, int target, List<Integer> path, List<List<Integer>> paths) {
        //printLists(paths);
        path.add(root.key);
        int sum = 0;
        for (int i = 0; i < path.size(); i++) {
            sum = sum + path.get(i);
            if (sum == target) {
                paths.add(new ArrayList<>(path));
            }
        }
        if (root.left != null && findPathsHelper(root.left, target, path, paths)) {
            return true;
        }
        if (root.right != null && findPathsHelper(root.right, target,path, paths)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    /**
     * optimize n times of adding elements in the list, we will pass the sum of all the nodes we visited previously to the next level and add it to see if it equals to target
     * when we return to the riginal state, we will have the previous sum in the previous stage, and we have to remove the last elemnt from the list
     * */
    public void helper (TreeNode root, int target, int currentSum, List<Integer> path, List<List<Integer>> paths) {
        if (root == null) {
            return;
        }

        path.add(root.key);
        currentSum += root.key;
        if (currentSum == target) {
            paths.add(new ArrayList<>(path));
            //here we have to remove the added element since we don't want to pass it to the next iteration
            path.remove(path.size() - 1);
            return;
        }

        helper(root.left, target, currentSum, path, paths);
        helper(root.right, target, currentSum, path, paths);

        path.remove(path.size() - 1);
    }


    public static void printLists(List<List<Integer>> result) {
        System.out.println("Printing Lists: ");
        for (int i = 0 ; i < result.size(); i++) {
            System.out.print("List " + i + " [ ");
            for (int j = 0; j < result.get((i)).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.print("]");
        }
        System.out.println();
    }

    public static void main(String[] args) {

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
        printLists(result);
    }
}
