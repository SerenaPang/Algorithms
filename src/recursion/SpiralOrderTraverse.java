package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * print the matrix like a spiral(clockwise)
 * base case: where do we stop? what's the condition we already know?
 * - we stop when it's the last element
 * how do we know it's the last element?
 * - when col - 1 < 0 ||row - 1 < 0
 * <p>
 * what do we need to do in every recursive function call?
 * print the horizontal row,
 * print the vertical left col,
 * print the bottom horizontal row,
 * print the left vertical row,
 * <p>
 * how do we print the rows and cols?
 * <p>
 * -
 * first round:
 * from r[0][i] i++ until matrix.len - 2
 * [0]to be decrease[0,1..]i++ to matrix.len - 2, to be decrease
 * <p>
 * from r[i][matrix.len - 1] i++ to matrix.len - 2
 * [0,1...][matrix len - 1] to decrease
 * <p>
 * from r[matrix.len - 1][i] i-- to zero
 * [matrix len - 1]to decrease[]
 * from r[i][0] i-- to zero
 * <p>
 * <p>
 * what's the problem that's a little smaller than the original problem?
 * - row-1 and col- 1
 */
public class SpiralOrderTraverse {
    public static List<Integer> spiralTraverse(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rowLen = matrix.length - 1;
        int colLen = matrix[0].length - 1;
        int round = 0;
        helper(matrix, round, rowLen, colLen, res);
        return res;
    }

    public static void helper(int[][] matrix, int round, int rowLen, int colLen, List<Integer> result) {
        int row = rowLen;
        int col = colLen;

        if (row == 0 && col == 0) {
            return;
        }
        if (row == 1) {
            result.add(matrix[row][col]);
            return;
        }

        //upper row
        for (int i = round; i < row; i++) {
            int cur = matrix[round][i];
            result.add(cur);
        }

        //right col
        for (int i = round; i < row; i++) {
            int cur = matrix[i][col];
            result.add(cur);
        }

        //bottom row
        for (int i = col; i > round; i--) {
            int cur = matrix[row][i];
            result.add(cur);
        }

        //left col
        for (int i = row; i > round; i--) {
            int cur = matrix[i][round];
            result.add(cur);
        }

        round++;
        row--;
        col--;

        helper(matrix, round, row, col, result);
    }

    public static void print(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9,}
        };
        print(spiralTraverse(matrix));

        int[][] matrix11 = new int[][]{
                {1, 2, 3, 10},
                {4, 5, 6, 20},
                {7, 8, 9, 30},
                {40, 50, 60, 70}
        };
        print(spiralTraverse(matrix11));

        int[][] matrix2 = new int[][]{
                {1, 2, 3, 10},
                {4, 5, 6, 20},
                {7, 8, 9, 30},
        };
        print(spiralTraverse(matrix2));
    }

}

