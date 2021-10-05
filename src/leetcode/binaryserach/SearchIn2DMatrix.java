package leetcode.binaryserach;
/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 */
public class SearchIn2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowL = matrix.length;
        int colL = matrix[0].length;
        int size = rowL * colL;
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //calculate the element's position in the matrix
            int row = mid / colL;
            int col = mid % colL;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;
        boolean res = searchMatrix(matrix, target);
        if (res) {
            System.out.println(target + " is in the matrix");
        } else {
            System.out.println(target + " is NOT in the matrix");
        }
    }
}
