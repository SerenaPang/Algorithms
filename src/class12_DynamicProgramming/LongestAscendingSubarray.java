package class12_DynamicProgramming;

public class LongestAscendingSubarray {
    /**
     * 在一个无序的array里找到最长的一个subarray，这个subarray的顺序必须是由小到大的顺序排序的
     * 开一个memo，这个memo的长度和这个input array的长度一样
     * 怎么填？  memo记录长度，当接不上的时候（顺序大到小），memo的长度按之前的不变，另起炉灶从1开始，
     * 如果能接上就增加，继承遗产
     * base case：第一个element in array
     * induction rule：和问题一样，每次填的都是之前的最长的subarray
     * 数学表达式：m[i] = m[i - 1] + 1
     * if input[i -1] < input[i]
     * <p>
     * index： 0 1 2 3 4 5 6 7
     * array： 7 2 3 1 5 8 9 6
     * 长度：   1
     * <p>
     * index： 0 1 2 3 4 5 6 7
     * array： 7 2 3 1 5 8 9 6
     * 长度：   1 1
     * <p>
     * index： 0 1 2 3 4 5 6 7
     * array： 7 2 3 1 5 8 9 6（因为此时7和2不能接上）
     * 长度：   1 1
     * <p>
     * index： 0 1 2 3 4 5 6 7
     * array： 7 2 3 1 5 8 9 6 （因为此时2和3能接上）
     * 长度：   1 1 2
     * <p>
     * index： 0 1 2 3 4 5 6 7
     * array： 7 2 3 1 5 8 9 6 （因为此时3和1不能接上）
     * 长度：   1 1 2 1
     * <p>
     * index： 0 1 2 3 4 5 6 7
     * array： 7 2 3 1 5 8 9 6 （因为此时1和5能接上）
     * 长度：   1 1 2 1 2
     * <p>
     * index： 0 1 2 3 4 5 6 7
     * array： 7 2 3 1 5 8 9 6 （因为此时8和9能接上）
     * 长度：   1 1 2 1 2 3
     * <p>
     * index： 0 1 2 3 4 5 6 7
     * array： 7 2 3 1 5 8 9 6 （因为此时9和6不能接上）
     * 长度：   1 1 2 1 2 3 4 1
     */
    public int longest(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int result = 1;
        int cur = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {//继承遗产
                cur++;
                result = Math.max(result, cur);
            } else { //另起炉灶
                cur = 1;
            }
        }
        return result;
    }
}
