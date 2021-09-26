package recursion;
/***
 * move all 0s to the end of the array
 * assumption: we don't have to keep the order of the original array
 * 
 * TC:O(n)
 * SC:O(1)
 * */
public class MoveTargetToTheEnd {
	public static int[] moveZero(int[] array) {
		//sanity check
		if(array == null || array.length <= 1) { //if the array does not exist or there is 0 or 1 element in the array 
			return array;
		}
		int left = 0;
		int right = array.length - 1;
		while(left <= right) {
			if(array[left] != 0) {//if the number is not 0, we move on
				left++;
			}else if(array[right] == 0) {//if it is 0, and it's at the end, we move on because it's already at the end
				right--;
			}else {
				swap(array, left, right);//left is 0 so we have to move 0 to the end, right has to change because it has add by 1
				left++;
				right--;
			}
		}
		return array;
	}
	
	public  static void swap(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
	
	public static void print(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		int[]array = new int[]{1,2,0,3,0,4,5,0,0,6,7,8,9};
		print(array);
		System.out.println();
		print(moveZero(array));
	}
}
