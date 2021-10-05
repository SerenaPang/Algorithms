package binary.search;

public class ClosestElementInSortedArray {
	//1 2 5 6
	//target 3, return index 1 which is the number 2 : 3 - 2 = 1, 5 - 3 = 2  
	//2 is closer to 3 than 5
	public static int closestElement(int[] array, int target) {
		//sanity check
		if(array == null || array.length == 0) {
			return -1;
		}
		
		int left = 0;
		int right = array.length - 1;
		//System.out.println("rightBound: " + (right - 1));
		while(left < right - 1) {
			int mid = left + (right - left) / 2;
			if(array[mid] == target) {
				return mid;
			}
			else if(array[mid] < target) {
			//	System.out.println("left: " + left + " right: " + right + " mid: " + mid);
				left = mid;
				
			}else {
			//	System.out.println("left: " + left + " right: " + right + " mid: " + mid);
				right = mid;
				
			}
		}
		//post processing
		if(Math.abs(array[left])- target <= Math.abs(array[right]) - target) {
			return left;
		}else {
			return right;
		}
		//System.out.println("left: " + left + " right: " + right);	
	}
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,5,6};
		closestElement(arr, 3);
		
	}
}
