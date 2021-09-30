package recursion;
import java.util.ArrayList;
import java.util.List;
/**
 * Get all valid ways of putting N Queens on an N * N chessboard so that no two Queens threaten each other.
 *
 * Assumptions
 *
 * N > 0
 * Return
 *
 * A list of ways of putting the N Queens
 * Each way is represented by a list of the Queen's y index for x indices of 0 to (N - 1)
 * Example
 *
 * N = 4, there are two ways of putting 4 queens:
 *
 * [1, 3, 0, 2] --> the Queen on the first row is at y index 1, the Queen on the second row is at y index 3, the Queen on the third row is at y index 0 and the Queen on the fourth row is at y index 2.
 *
 * [2, 0, 3, 1] --> the Queen on the first row is at y index 2, the Queen on the second row is at y index 0, the Queen on the third row is at y index 3 and the Queen on the fourth row is at y index 1.
 *
 * */

public class NQueensTwo {
    /**
     * @param n is the number of queens we want to put on the chessboard; n is also the size of the chessboard n * n
     *
     * @return List<List<Integer>> result list contains a list of ways putting th
     * n queens on the chessboard
     *
     * <List<Integer>: one of the possible placed position of all the queen;
     * so the indexes represents the rows that the queen is at;
     * and the values of the list represents the columns that the queen is at
     * */
    public static List<List<Integer>> nqueens(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> currentPossibleSolution = new ArrayList<>();
        helper(n, currentPossibleSolution, result);
        return result;
    }
    /**
     * This recursive helper function, finds all valid possible positions placed
     * of the queens and populate the positions to the result
     * */
    public static void helper(int n, List<Integer> currentPossibleSolution, List<List<Integer>> result) {
        //base case: when we are at the last row of the chessboard
        if (currentPossibleSolution.size() == n) {
            result.add(new ArrayList<>(currentPossibleSolution));
            return;
        }
        //what do we need to do in the current level, place the queen in the right position
        /**
         * every row should placed one queen, but in which column we put this queen
         * does not attack the other queens on the chessboard?
         *
         * we put the queen in the first col, and then we put the others,if this position works,
         * we can continue putting the next queen with the previous position, until we reach
         * to the last row of the chessboard,if it works, then we can add this solution to
         * the result.
         *
         * if not, we have to move on and start with putting the queen in the
         * second col, and check if we can put the rest of the queens in the chessboard,
         * with the queen position in the first row and second col
         *
         * */
        for (int i = n; i < n - 1; i++) {
                if (isValid(currentPossibleSolution, i)) {
                    //here this place is valid, let's add it to result
                    currentPossibleSolution.add(i);
                    //let's use this valid position to try to place the rest
                    helper(n,currentPossibleSolution, result);
                    //let's use the last position of the position to try to place the at another place
                    currentPossibleSolution.remove(currentPossibleSolution.size() - 1);
                }
            }
        }


    /**
     * function that takes in the positions of all the queens in the chessboard
     * and the position we want to place the queen; check if the same row, col, also
     * the diagonal has queen.
     *
     * //calculate diagonal: |row - row| == |col - col|
     * @return false if the row and col and diagonal exist a queen; true if not
     * */
    public static boolean isValid(List<Integer> possiblePlacement, int col) {
        //for every row ,we test the col
        int row = possiblePlacement.size();
        for (int i = 0; i < possiblePlacement.size(); i++) {
            if (possiblePlacement.get(i) == col || Math.abs(i - row) == Math.abs(possiblePlacement.get(i) - col)) {
                return false;
            }
        }
        return true;
    }
}
