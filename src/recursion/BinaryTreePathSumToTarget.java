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
        //path contains all the nodes sum to target
        List<Integer> path = new ArrayList<>();
        if (root == null) {
            return path;
        }
        helper(root, target, path);
        return path;
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

    public static void print(List<Integer> result) {
        System.out.println("Printing List: ");
        for (int i = 0 ; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
    }
}
