package graphs_recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * params:
 * int column: which is the column we want to put the queen
 * List<Integer> :which is all queens' position
 * base case: when we iterate through all row and put all queens in the matrix
 * what's the problem that's one size smaller than the current problem?
 * n queens, n-1, n-2, n-3, n-4...
 * what do we need to report in the current level? what do we need to do in the current level?
 * 1. when we put the current queen at this col, does it attack other queens? (check
 * col, check diagonal),
 * 2. if the current position works, we add it to the result list
 */
public class NQueensRevised {
    /**
     * what do we want to return?
     * a chessboard with all the queens in the appropriate positions
     * which data structure we are going to use?
     * a List of integer which stores 1 (or current)solution for all the positions available for all the queens in the chessboard
     * a List of the List of integer to store all the final solution of all position of
     * all the queens
     */
    public static List<List<Integer>> nQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        return result;
    }

    /**
     * params:
     * we need column to check if we are able to put the queen in that column
     * we need cur List to check all positions for the queens
     * we need to add the current solution to the result list
     * find all the solutions using dfs
     * in this case, we don't need to return any thing to the previous level,
     * but we need to verify if we can put the queen in a specific position
     */
    public static void helper(int n, List<Integer> cur, List<List<Integer>> result) {
        //base case
        if (cur.size() == n) {
            result.add(new ArrayList<>(cur));
            return;
        }
        /**recursive rule: if valid, add to cur list, cur list is going to contains 1 solution for putting all queens not attacking each other
         if not valid, after checking 1 solution, we have to clear all configurations on the chessboard and check the next configuration
         because we are using cur as the container to put 1 solution, when we try out different solutions, we need to
         remove the last configuration, and try to put the queen at another position
         */
        for (int col = 0; col < n; col++) {//note i is the col index
            if (isValid(col, cur)) { //pass the current col and cur to check if valid to put a queen
                helper(n, cur, result);
                cur.add(col);
                cur.remove(cur.size() - 1);
            }
        }

    }

    /**
     * params:col represents the current col we want to try to put the queen
     * cur's index represents the row index, cur's value represents the col value
     * <p>
     * check if the position is a valid position to put the queen
     */
    public static boolean isValid(int col, List<Integer> cur) {
        int row = cur.size();
        for (int i = 0; i < cur.size(); i++) {
            //diagonal: y2 - y1 == x2 - x1
            if (col == cur.get(i) || Math.abs(cur.get(i) - col) == i - row) {
                return false;
            }
        }
        return true;
    }
}
