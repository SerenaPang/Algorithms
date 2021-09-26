package recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    /**
     在棋盘上的皇后不会互相攻击，攻击范围：横竖斜着米子
     没有一对皇后能放在同一行或每一列，因为如果相同就进入攻击范围了
     用dfs解决：recursion tree
     有几层：8层，每个level对应着每个col，就是每个queen占一层
     有几叉？8个branches，可以尝试把8个queen放在8个不同的col
     第0层：第0行第0列
     第1层：。。。
     写个for循环，比如第4个queen到第4行，查每个列，挨个放看会不会和其他queen冲突
     */
    public List<List<Integer>> nqueens(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        helper(n, cur, result);
        return result;
    }
    /**
     n is the number of queens we want to put in chessboard
     cur is the queen's position(i represents row[i] and the number col[i] represents the queen's col position)
     result store all queen's row and col position
     */
    private void helper(int n, List<Integer> cur, List<List<Integer>> result){
        //base case: for all the row, we know where the queen is
        if (cur.size() == n) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }

        for (int i = 0; i < n; i++) {
            //check if putting a queen at column i is valid at current row, num of row represents row position
            if (valid(cur, i)) {
                cur.add(i);
                helper(n, cur, result);
                cur.remove(cur.size() - 1);
            }
        }
    }
    /**
     index0 1 2 3 4 5
     list{2,3,4,7,1,8}

     */
    private boolean valid(List<Integer> cur, int column){
        //for every column we check if there is already a queen in this col, and row too
        int row = cur.size();
        for (int i = 0; i < row; i++) {
            if (cur.get(i) == column || Math.abs(cur.get(i) - column) == row - i) {
                return false;
            }
        }
        return true;
    }
}
