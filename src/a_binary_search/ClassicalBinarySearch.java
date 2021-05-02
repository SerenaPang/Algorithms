package a_binary_search;

//given a sorted array in ascending order, return the index of the target number
public class ClassicalBinarySearch {
	public static int findTargetNumber(int[] array, int target) {
		if(array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(target == array[mid]) {
				return mid;
			}else if(target < array[mid]) {
				right = mid - 1;
			}else { //target > array[mid]
				left = mid + 1;
			}
		}
		return -1;
	}

}
