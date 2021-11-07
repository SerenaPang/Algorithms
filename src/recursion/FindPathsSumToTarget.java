package recursion;

import java.util.ArrayList;
import java.util.List;

public class FindPathsSumToTarget {

    /**
     * This function is going to find paths that are sum to target(if there are paths)
     * */
    public List<List<Integer>> findPathsSumToTarget(TreeNode root, int target){
        List<List<Integer>> paths= new ArrayList<>();
        if (root == null) {
            return paths;
        }
        List<Integer> path = new ArrayList<>();
        findPathsHelper(root, target, path, paths);
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
