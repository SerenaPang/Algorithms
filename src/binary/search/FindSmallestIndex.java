package binary.search;

/**
 *  1 2 3 4 4 4 target 4 return 3
 * find the largest index's value is smaller or equals to target
 * */
public class FindSmallestIndex {
    //0 1 2 3 4 5
    //1 2 3 4 4 4
    //l
    //          r
    //    m
    //
    public int findIndex(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            }
            else if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (array[left] <= target) {
            return left;
        }
        if (array[right] <= target){
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,4,4};
        int target = 4;
        FindSmallestIndex findSmallestIndex = new FindSmallestIndex();
        int result = findSmallestIndex.findIndex(array, target);
        System.out.println("The largest index's value that's smaller or equals to target " + target + " is at index " + result + " value: " + array[result]);
    }
}
