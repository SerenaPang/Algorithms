package dynamic.programming;
/**
 *Given an unsorted array, find the length of the longest subarray in which the numbers are in ascending order.
 *
 * Assumptions
 *
 * The given array is not null
 * Examples
 *
 * {7, 2, 3, 1, 5, 8, 9, 6}, longest ascending subarray is {1, 5, 8, 9}, length is 4.
 * {1, 2, 3, 3, 4, 4, 5}, longest ascending subarray is {1, 2, 3}, length is 3.
 * */
public class LongestAscendingSubArray1 {

    public static int longest(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int maxLen = 0;
        int[] memo = new int[array.length];
        memo[0] = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                memo[i] = memo[i - 1] + 1;
                maxLen = Math.max(maxLen, memo[i]);
            } else {
                memo[i] = 1;
            }
        }
        print(array);
        print(memo);
        return maxLen;
    }

    public static void print(int[] memo) {
        for (int i = 0; i < memo.length; i++) {
            System.out.print(memo[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        //int[] arr = new int[]{7, 2, 3, 1, 5, 8, 9, 6};
        int[] arr = new int[]{1, 2, 3, 3, 4, 4, 5};
        int res = longest(arr);
        System.out.println("Longest ascending subarray is: "  + res);
    }

}
