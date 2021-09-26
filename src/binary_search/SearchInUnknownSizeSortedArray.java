package binary_search;

import java.util.Dictionary;

/**
 * TC:O(logT),T is the index of target value
 * SC:O(1)
 * 
 * The dictionary is an unknown sized sorted array, it only provides get(int index
 * )function, if the index asked for is out of right bound, it will return null
 * 
 * the elements in the dictionary are all integers
 * 
 * the main idea is to extend the right boundary until we find the target
 * */
public class SearchInUnknownSizeSortedArray {

	public int saerch(Dictionary dictionary, int target) {
		//if the dictionary is null we use -1 indicates target not found
		if(dictionary == null) {
			return -1;
		}
		//setting the boundary for binary search
		//extends the right bound until we are sure the target is within the [left, right] range
		int left = 0;
		int right = 1; //dictionary.get(right)
		while(dictionary.get(right) != null && right < target) {
			//check if the right bound needs to be extends more to the right
			left = right;//left move to the position of right
			right = 2 * right; //right boundary extends 2 times
		}
		return binarySearch(dictionary, target, left, right);//use 
	}
	
	/**
	 * classical binary search
	 * */
	public int binarySearch(Dictionary dict, int target, int left, int right) {
		while(left <= right) {
			int mid = left + (right - left)/2;
			//dict.get(mid) > target
			if(dict.get(mid) == null || mid > target) {
				right = mid - 1;
			}else if(mid < target) {
				left = mid + 1;
			}else {
				return mid;
			}
		}	
		return -1;
	}
	
}
