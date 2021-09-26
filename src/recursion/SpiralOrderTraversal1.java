package recursion;
import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraversal1 {

        //把皮剥了然后看里面的瓤，
        /**
         用4个for循环，每个for循环打印一个边：上面的一层，右边一层，下面一层，左边一层

         上面的一层：从0 到 size - 1 因为右上角那个不用打2次  1234
         右边一层：size-2因为打印完外面那层两边要拿走2个数字，为什么加offset？打印第二列的时候从第2个开始
         下面一层：
         左边一层

         */
        public List<Integer> spiral(int[][] matrix) {
            List<Integer> list = new ArrayList<Integer>();
            recursiveTraverse(matrix, 0, matrix.length, list);
            return list;
        }

        /**
         matrix is the input matrix
         offset is where it should start printing, start with 0 and increase as i increase
         size is the size of the matrix
         result is the list of elements in spiral order
         */
        private void recursiveTraverse(int[][]matrix, int offset, int size, List<Integer> result){
            //base case: when there is only 0 element in the matrix
            if(size == 0){
                return;
            }
            //base case: when there is only 1 element in the matrix
            if (size == 1) {
                result.add(matrix[offset][offset]);
                return;
            }
            //upper row
            for (int i = 0; i < size - 1; i++) {
                result.add(matrix[offset][offset + i]);
            }
            //right col
            for (int i = 0; i < size - 1; i++) {
                result.add(matrix[offset + i][offset + size - 1]);
            }
            //bottom row
            for (int i = size - 1; i >= 1; i--) {//printing from right to left,remember it's a spiral
                result.add(matrix[offset + size - 1][offset + i]);
            }
            //left col
            for (int i = size - 1; i >= 1; i--) {
                result.add(matrix[offset + i][offset]);
            }
            recursiveTraverse(matrix, offset + 1, size - 2, result);
        }

    }



