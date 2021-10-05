package array.matrix;

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 * <p>
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 */
public class SqaureNumbersInSortedOrder {
    public static int[] sortedSquares(int[] nums) {
        int leftBound = 0;
        int rightBound = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            int sqare = 0;

            if (Math.abs(nums[leftBound]) < Math.abs(nums[rightBound])) {
                leftBound++;
            } else if (Math.abs(nums[rightBound]) >= Math.abs(nums[leftBound])) {
                rightBound--;
            } else {
                swap(nums, leftBound++, rightBound--);
            }
        }
        return nums;
    }

    public int[] sortedSquare(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0;
        int right = n - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            int square = 0;
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                square = nums[right];
                right--;
            } else {
                square = nums[left];
                left++;
            }
            res[i] = square * square;
        }
        return res;
    }

    public static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-4, -1, 0, 3, 10};
        print(arr);
        print(sortedSquares(arr));
    }

}
