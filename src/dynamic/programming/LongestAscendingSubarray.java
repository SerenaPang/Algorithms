package dynamic.programming;

/**
 * Given an unsorted array, find the length of the longest subarray in which the numbers are in ascending order.
 * <p>
 * Assumptions
 * <p>
 * The given array is not null
 * Examples
 * <p>
 * {7, 2, 3, 1, 5, 8, 9, 6}, longest ascending subarray is {1, 5, 8, 9}, length is 4.
 * {1, 2, 3, 3, 4, 4, 5}, longest ascending subarray is {1, 2, 3}, length is 3.
 * <p>
 * TC: O(n)
 * SC: O(1)
 */
public class LongestAscendingSubarray {

    public static int findLonggestAsnceding(int[] arr) {
        int globalMax = 0;
        int[] memo = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                memo[i] = 1;
            } else {
                if (arr[i] > arr[i - 1]) {
                    memo[i] = memo[i - 1] + 1;
                } else {
                    memo[i] = 1;
                }
                globalMax = Math.max(globalMax, memo[i]);
            }
        }
        print(memo);
        return globalMax;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // int[] arr = new int[]{7, 2, 3, 1, 5, 8, 9, 6};
        int[] arr = new int[]{1, 2, 3, 3, 4, 4, 5};
        print(arr);
        System.out.println("The longest ascending subarray length is: " + findLonggestAsnceding(arr));
    }

}
