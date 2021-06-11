package class2_binary_search;
/**
 * given a target t, an integer array a sorted in ascending order, find the index of closest element to 
 * target t that's larger than t
 * */
public class SmallestElementLargerThanTarget {
	
	public static int smallestLargerElement(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;
		
		//find the closest elements to target
		while(left < right - 1) {
			int mid = left + (right - left)/2;
			if(array[mid] < target) {//why <=, not < ? for the same reason below, we want the larger number, not equal number to the target
				left = mid ;//why mid + 1, not mid?, because it already check that mid is less than target,
				//and here we want to number that's larger than target number
			}else {
				right = mid;
			}
		}
		//take left and right to check which one is larger than target
		if(array[right] > target) {
			return right;
		}else if(array[left] > target) {
			return left;
		}
		//return -1 if no index found
		return -1;
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {1,2,3,4,5,8,9,10,11,12};
		int target = 7;
		int num = smallestLargerElement(array, target);
		System.out.println("smallest Element That's larger than " + target + " is: " + array[num]);
	}
	
}
