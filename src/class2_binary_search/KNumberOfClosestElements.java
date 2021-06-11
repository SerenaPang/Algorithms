package class2_binary_search;
/**
 * find k number of elements close to target t in array a
 * */
public class KNumberOfClosestElements {
	public static int[] kClosest(int[] array, int target, int k) {
		//sanity check
		if (array == null || array.length == 0) {
			return array;
		}
		//corner case: to find 0 number of closest elements
		if (k == 0) {
			return new int[0];
		}
		//find the closest element smaller than target
		int left = largestElementThatsSmallerOrEqualsToTargetNumber(array, target);
		int right = left + 1; //the element next to left, which is the next closest number for the target
		int[] result = new int[k];
		
		//check if the left element or the right element is closer to target
		//but needs to make sire left and right has more elements to consider
		for(int i = 0; i < k;i++) {
			//the right side does not have more elements to put
			//the left side has more elements to put, and the right has more elements to put
			//and the left side is closer to target
			//left和right从中心开花，从中间往外找更多close的数
			//start to middle -- left right ++ to the end
			if(right >= array.length || left >= 0 && target - array[left] <= array[right] - target) {
				//put the left element to the new result array
				result[i] = array[left];
				left--;//and then move to the next closer element in the array
			}else {//right side is closer
				result[i] = array[right];//put the right element to the result array
				right++;//move to the next element
			}
		}
		//return the results found
		return result;
	}

	/**
	 * find the closest element smaller than target
	 * always looking for the number that's SMALLER than the target number
	 * eg: [5,7,8]; target: 7;  will return 5 even if 8 is closer to 7,but 8 is bigger than the target
	 * so it will return 5, which is smaller than the target number
	 * */
	private static int largestElementThatsSmallerOrEqualsToTargetNumber(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] <= target) { //middle number is smaller than target
				left = mid;
			} else {
				right = mid;
			}
		}
		//now process left and right
		if(array[right] <= target) {//right is closer and smaller than the target
			return right;
		}	
		if(array[left] <= target) {//right is closer and smaller than the target
			return left;
		}
		//if left and right are both larger than the target...
		return -1;
	}
	public static void main(String[] args) {
		int[] array = new int[] {1,2,3,4,5,7,8,9,10,11,12};
		int target = 7;
		int num = largestElementThatsSmallerOrEqualsToTargetNumber(array, target);
		System.out.println("largest Element That's Smaller Or Equals To " + target + " Target Number: " + num);
	}
}
