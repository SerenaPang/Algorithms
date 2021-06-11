package practice_ground;
/**
 * Given a target integer, a positive integer k and a sorted integer array 
 * in ascending order, find the k number of numbers to target in array
 * */
public class ClosestInSortedArray {
	public int[] kClosest(int target, int k, int[] array) {
		//sanity check
		if(array == null || array.length == 0) {
			return array;
		}
		//corner case
		if(k == 0) {
			return new int[0];
		}
	
		int left = 0;
		int right = array.length - 1;
		
		while(left < right - 1) {
			int mid = left + (right - left)/2;
			if(array[left] <= array[mid]) {
				right = mid;
			}else {
				left  = mid;
			}
		}
		
		//array of all closest elements to k
		int[] closestNums = new int[k];
		//find the closest element and compare the right and left to see which one is closer to target	
		//how to make sure left and right has more elemensts to compare
		for(int i = 0; i < k; i++) {
			if(Math.abs(left) - target >= Math.abs(right)) {
				//right is closer, take right
				closestNums[i] = array[right];
			}else {
				closestNums[i] = array[left];
			}
		}
		
	
		
	 
		return closestNums;
	}

}
