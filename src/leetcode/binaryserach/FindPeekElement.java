package leetcode.binaryserach;

/**
 * A peak element is an element that is strictly greater than its neighbors.
 * <p>
 * Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
 * <p>
 * You may imagine that nums[-1] = nums[n] = -∞.
 * <p>
 * You must write an algorithm that runs in O(log n) time.
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 */
public class FindPeekElement {
    public static int findPeek(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {//4,5,4, 3 ,2,1
                right = mid;
            } else { //2, 3 ,4,5,4
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        // int[] nums = new int[]{1,2,1,3,5,6,4};
        int[] nums = new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1};
        int res = findPeek(nums);
        System.out.println("Peek is at index: " + res);
    }
}
