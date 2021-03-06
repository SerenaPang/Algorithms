package binary.search;

/**
 *  1 2 3 4 4 4 target 4 return 3
 * find the largest index's value is smaller or equals to target
 * */
public class FindSmallestIndex {
    //target value: 3, should return 2
    //0 1 2 3 4 5 6
    //1,2,3,3,4,4,4
    //l
    //            r
    //      m

    public int findIndex(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        if (array[left] == target) {
            return left;
        }
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        System.out.println("left: " + array[left] + " right: " + array[right]);
        if (array[left] <= target) {
            return left;
        } else if (array[right] <= target){
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
        FindSmallestIndex findSmallestIndex = new FindSmallestIndex();
        int result = findSmallestIndex.findIndex(array, target);
        System.out.println("The largest index's value that's smaller or equals to target " + target + " is at index " + result + " value: " + array[result]);
    }
}
