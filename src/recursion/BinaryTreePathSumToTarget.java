package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * find a path that can sum to the target number in the binary tree
 *
 * target:  8 + 3 + 6 + 4 = 21
 * list: 8
 * */
public class BinaryTreePathSumToTarget {
    /**
     * This function is going to find a path that sums to target
     * */
    public List<Integer> findPathSumToTarget(TreeNode root, int target) {
        //path contains all the nodes  sum to target
        List<Integer> path = new ArrayList<>();
        helper(root, target, path);
        return path;
    }

    /**
     * This function is going to find paths that are sum to target(if there are paths)
     * */
    public List<List<Integer>> findPathsSumToTarget(TreeNode root, int target){
        List<List<Integer>> paths= new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        findPathsHelper(root, target, path, paths);
        return paths;
    }

    /**
     * helper function to find a path sum to the target
     *
     * */
    public boolean helper(TreeNode root, int target, List<Integer> path) {
        print(path);
        //put the first node in the list
        path.add(root.key);
        int sum = 0;
        //sum the nodes in the list, return true if sum equals to target
       for (int i = 0; i < path.size(); i++) {
           sum = sum + path.get(i);
           if (sum == target) {
               print(path);
               return true;
           }
       }

       //recursion call that pass the left node as root add to list, if true means nodes in the list sum to target
       if (root.left != null && helper(root.left, target, path)) {
          return true;
       }
        if (root.right != null && helper(root.right, target,path)) {
           return true;
       }
        //we have to return to the original state and then try another case
        path.remove(path.size() - 1);
        //if we are here, it means we have not found the path yet
        return false;
    }

    /**
     * helper function to find paths that each of them sums to target
     * */
    public boolean findPathsHelper(TreeNode root, int target, List<Integer> path, List<List<Integer>> paths) {
        printLists(paths);
        path.add(root.key);
        int sum = 0;
        for (int i = 0; i < path.size(); i++) {
            sum = sum + path.get(i);
            if (sum == target) {
                paths.add(path);
              // return true;
            }
        }
        if (root.left != null && helper(root.left, target, path)) {
            return true;
        }
        if (root.right != null && helper(root.right, target,path)) {
            return true;
        }

        return false;
    }

    public static void print(List<Integer> result) {
        System.out.println("Printing List: ");
        for (int i = 0 ; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
    }

    public static void printLists(List<List<Integer>> result) {
        System.out.println("Printing Lists: ");
        for (int i = 0 ; i < result.size(); i++) {
            System.out.println("List " + i);
            for (int j = 0; j < result.get((i)).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
        }
        System.out.println();
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
       // List<Integer> result = binaryTreePathSumToTarget.findPathSumToTarget(eight, target);
       List<List<Integer>> result =binaryTreePathSumToTarget.findPathsSumToTarget(eight, target);
    }
}
