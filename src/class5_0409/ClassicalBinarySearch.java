package class5_0409;

public class ClassicalBinarySearch {
	public static int binarySearch(int[] array, int target) {
		
		int left = 0;
		int right = array.length - 1;
		
		//1 2 3 4 5 6 7 8 9
		//0 + (8 - 1) / 2 = 0 + 7/2 = 3.5 = 3
		while(left <= right) {
			int mid = left + (right - left)/2;
			
			if(array[mid] == target) {
				return mid;
			}else if(array[mid] > target) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		//len: 9
		//0 - 8
		int[] array = new int[] {1,2,3,4,5,6,7,8,9};
		
	}
}
