package basic_exam1;

/**
 * 10:12 - 10:22
 * input: {3,5,2,5,6,7,10,1} unsorted
 * output:    {2,5,6,7,10} ascending order
 * index:    0 1 2 3 4 5  6 7
 * input:   {3,5,2,5,6,7,10,1}
 * memo[0] : 1
 * memo[1] :   2
 * memo[2] :     1
 * memo[3] :       2
 * memo[4] :         3
 * memo[5] :           4
 * memo[3] :             5
 * memo[3] :                1
 * <p>
 * memo stores the length of the longest ascending array we have seen so far
 * <p>
 * induction rule:
 */
public class LongestAscendingSubArray {
    public int longest(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int globalMax = 1;
        int cur = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) { //later > previous -> inherit
                cur++;
                globalMax = Math.max(globalMax, cur);
            } else {
                cur = 1;
            }
        }
        return globalMax;
    }
}
