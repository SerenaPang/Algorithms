package binary_search;

public class FindFirstAndLastPosition {
    /**
     * first we find ou the first occurance, and then iterate to the
     * point where it reaches to a number tha's not the target, then we just add that to result
     * */
    public static int[] find(int[] nums, int target) {
        int firstOccur = findFirst(nums, target);
        if (firstOccur == -1) {
            return new int[]{-1, -1};
        } else {
            int left = firstOccur;
            int right = nums.length;
            while (left < right && nums[left] == target ) {
                left++;
            }
            return new int[]{firstOccur, left-1};
        }
    }

    public static int findFirst(int[] array, int target) {
        int left = 0;
        int right = array.length -1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (array[left] == target) {
            return left;
        } else if (array[right] == target){
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,7,7,7,8,9};
        //expect [2,4]
        int target = 7;
      //  System.out.println("First Occur: " + findFirst(nums, target));
        int[] res = find(nums, target);
        System.out.println("First Occur: " + res[0]);
        System.out.println("Last Occur: " + res[1]);
    }
}
