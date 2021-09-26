package recursion;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraversal2 {
    /**
     note that in this question, the length of the row is different from the length
     */
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        int m = matrix.length;//3 rows
        if (m == 0) {
            return list;
        }
        int n = matrix[0].length;//4 cols
        int left = 0;
        int right = n - 1;//col
        int up = 0;
        int down = m - 1;//row

        while (left < right && up < down) {
            //upper row
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
            //right col
            for (int i = up + 1; i <= down - 1; i++) {
                list.add(matrix[i][right]);
            }
            //bottom row
            for (int i = right; i >= left; i--) {
                list.add(matrix[down][i]);
            }
            //left col
            for (int i = down - 1; i >= up + 1; i--) {
                list.add(matrix[i][left]);
            }
            left++;
            right--;
            up++;
            down--;
        }

        //becasue the length of the row and column are different, we need to do some post processing
        //if nothing left
        if (left  > right || up > down) {
            return list;
        }
        //if one col left
        if (left == right) {
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][up]);
            }
        } else {//if one row left
            for (int i = left; i <= right; i++){
                list.add(matrix[up][i]);
            }
        }
        return list;
    }
}

