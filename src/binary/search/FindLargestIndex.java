package binary.search;

public class FindLargestIndex {

    public int findIndex(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        if (array[right] == target) {
            return left;
        }
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println("left: " + array[left] + " right: " + array[right]);
        if (array[left] >= target) {
            return left;
        } else if (array[right] >= target){
            return right;
        } else {
            return right;
        }
    }

    public static void main(String[] args) {
        //int[] array = new int[]{1,2,3,4,4,4};
        //int[] array = new int[]{1,1,1,1,1,1};
        //int[] array = new int[]{1,2,3,3,4,4,4};
        int[] array = new int[]{1,2,3,4};
        //if target does not exist, return the value closest to target(smaller than target)
        int target = 5;
        FindLargestIndex findLargestIndex = new FindLargestIndex();
        int result = findLargestIndex.findIndex(array, target);
        System.out.println("result: " + array[result]);
    }
}
