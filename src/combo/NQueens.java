package combo;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static List<List<Integer>> findValidPositionForNQueens(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        helper(n, cur, result);
        return result;
    }

    public static void printChessBoard(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        System.out.println("Print ChessBoard: ");
        for (int i = 0; i < row; i++) {
            System.out.println(" ");
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
        }
        System.out.println("Finished");
    }

    public static void printList(List<Integer> myList) {
        System.out.print("Print List: { ");
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
        System.out.print("}");
    }

    /**
     * we are going to put the queens to a single row, so that every queen can stay
     * in a different row
     * row: records the row that queen have taking
     */
    public static int[][] setQueenOnRows(int n, int[][] chessboard) {
        List<Integer> rows = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rows.add(i);
        }
        int row = chessboard.length;
        int col = chessboard[0].length;
        for (int i = 0; i < row; i++) {
            System.out.println(" ");
            for (int j = 0; j < col; j++) {
                // System.out.print(chessboard[i][j] + "  ");
                chessboard[i][0] = 1;
            }
        }
        printList(rows);
        return chessboard;
    }

    public static int[][] setQueenOnCols(int n, int[][] chessboard) {
        List<Integer> rows = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rows.add(i);
        }
        int row = chessboard.length;
        int col = chessboard[0].length;
        for (int i = 0; i < row; i++) {
            System.out.println(" ");
            for (int j = 0; j < col; j++) {
                // System.out.print(chessboard[i][j] + "  ");
                chessboard[0][j] = 1;
            }
        }
        printList(rows);
        return chessboard;
    }

    /**
     * set all the diagonal of this element to be 1
     * queen:0 1 2 3 4 5 6 7
     * row:  0 1 2 3 4 5 6 7
     * col: {               }
     */
    public static int[][] setQueenOnDiagonal(int n, int[][] chessboard) {
        int row = chessboard.length;
        int col = chessboard[0].length;
        int position = chessboard[0][0];
        for (int i = 0; i < row; i++) {
            System.out.println(" ");
            for (int j = 0; j < col; j++) {
                // System.out.print(chessboard[i][j] + "  ");
                //j - col position == i - row position
                if (Math.abs(j - 0) == Math.abs(i - 0)) {
                    chessboard[i][j] = 1;
                }
            }
        }
        return chessboard;
    }

    public static void helper(int n, List<Integer> cur, List<List<Integer>> result) {
        if (cur.size() == n) {
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (ifValid(cur, i)) {//row, col
                cur.add(i);
                helper(n, cur, result);
                cur.remove(cur.size() - 1);
            }
        }
    }

    /**
     * How do I check if I can put a queen in a position on chessboard?
     * check if the same cols, and horizontally there are queens
     * <p>
     * only when it's valid, we can add that position to cur
     */
    public static boolean ifValid(List<Integer> cur, int col) {
        int row = cur.size();//the number of queens in the chessboard
        for (int i = 0; i < row; i++) {
            if (cur.get(i) == col || Math.abs(cur.get(i) - col) == row - i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //8*8 matrix
        int[][] matrix = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0},
        };
        // printChessBoard(matrix);
        int n = 8;
        // printChessBoard(setQueenOnRows(n, matrix));
        // printChessBoard(setQueenOnCols(n, matrix));
        printChessBoard(setQueenOnDiagonal(n, matrix));
    }
}
