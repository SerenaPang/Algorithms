package binary_search;

/**
 * corner case:
 * -when input length is 0 or 1, does it covered?
 * -when to insert at the begining?
 * 1 when there is only 0 element
 * 2 when there is 1 element and it's larger than target
 * <p>
 * when to insert in right(which is the index position element bigger than the target)?
 * -when left is smaller than target and right is greater than target
 * <p>
 * when to insert in right + 1?
 * -left is smaller than target and right is smaller than target
 * <p>
 * when to insert at right(which is the position index that's left is smaller than target
 * and right is bigger or equals to target)?
 * <p>
 * -when left is smaller than target and right is equals to target
 */
public class InsertInArray {

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            if (nums[0] < target) {
                return 1;
            } else {
                return 0;
            }
        } else {
            int left = largestSmallerEqualsToTarget(nums, target);
            int right = left + 1;
            if (nums[left] == target) {
                return left;
            } else if (nums[left] < target && (nums[right] > target && right <= nums.length - 1)) {
                return right;
            } else if (nums[left] < target && nums[right] < target) {
                return right + 1;
            } else if (nums[left] < target && nums[right] == target) {
                return right;
            } else {
                return 0;
            }
        }
    }

    //return the index of the number that's smaller than the target(but the closest one)
    public int largestSmallerEqualsToTarget(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        //System.out.println("left " + nums[left]);
        //System.out.println("right " + nums[right]);
        if (nums[left] <= target) {
            return left;
        } else if (nums[right] <= target) {
            return right;
        }

        return 0;
    }

    public static void main(String[] args) {

        InsertInArray insertInArray = new InsertInArray();
        //  int[] nums = new int[]{1,3,5,6};
        //  int target = 1;

        // int[] nums = new int[]{1,3,5,6};
        // int target = 0;
        // int target = 2;
        //int target = 5;
        // int target = 7;


        int[] nums = new int[]{1, 3};
        int target = 3;
        int res = insertInArray.largestSmallerEqualsToTarget(nums, target);
        int result = insertInArray.searchInsert(nums, target);
        System.out.println("closest number smaller than " + target + " is " + nums[res]);
        System.out.println("insert " + target + " at index " + result);


        int target1 = 0;
        int[] nums1 = new int[]{1};
        int res1 = insertInArray.searchInsert(nums1, target1);
        System.out.println("insert " + target1 + " at index " + res1);
        //  int result = insertInArray.searchInsert(nums, target);
        //  System.out.println("insert at index: " + result);
    }
}