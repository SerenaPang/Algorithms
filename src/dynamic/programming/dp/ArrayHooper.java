package dynamic.programming.dp;

/**
 * Given an array A of non-negative integers, you are initially positioned at index 0 of the array.
 * A[i] means the maximum jump distance from that position (you can only jump towards the end of the array).
 * Determine if you are able to reach the last index.
 * <p>
 * Assumptions
 * The given array is not null and has length of at least 1.
 * Examples
 * <p>
 * {1, 3, 2, 0, 3}, we are able to reach the end of array(jump to index 1 then reach the end of the array)
 * <p>
 * {2, 1, 1, 0, 2}, we are not able to reach the end of array

 *
 */
public class ArrayHooper {
    public static boolean canJump(int[] arr) {
        if (arr.length == 1) {
            return true;
        }
        boolean[] memo = new boolean[arr.length];
        print(memo);
        //the first element after the base case(which is the last element)
        for (int i = arr.length - 2; i >= 0; i--) {
            System.out.println("Element: " + arr[i] + " Index: " + i);
            if (i + arr[i] >= arr.length - 1) {
             //   System.out.println("element: " + arr[i]);
                memo[i] = true;
            } else {
                for (int j = arr[i]; j >= 1; j--) {
                    if (memo[j + i]) {
                        memo[i] = true;
                        break;
                    }
                }
            }
        }
        print(memo);
        return memo[0];
    }

    public static void print(int[] memo) {
        for (int i = 0; i < memo.length; i++) {
            System.out.print(memo[i] + " ");
        }
        System.out.println();
    }

    public static void print(boolean[] memo) {

        for (int i = 0; i < memo.length; i++) {
            System.out.print(memo[i] == true ? " true " : " false ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1, 3, 2, 0, 3};
       // print(arr);
        canJump(arr);
    }
}
