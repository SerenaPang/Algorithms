package sorting.algorithms;

public class Partition {
	/**
	 * rearrange the array so that the numbers smaller than the array[pivot] are on the left and
	 * the numbers greater than array[pivot] are on the right side
	 * */
	public static int[] partition(int[] array, int pivotIndex) {
		//1,7,2,6,8,3,4,5,9
	   //     pivot 
		int value = array[pivotIndex];
		swap(array, pivotIndex, array.length - 1); //将pivot和最后一个数字进行交换
		int left = 0;
		int right = array.length - 2; //现在最后一个数字是pivot所以不用管他，先处理pivot之外的所有数
			
		while(left <= right) {
			//System.out.print(" " + left);
			//left++;
			if(array[left] < value) {
				left++;
			}else {
				swap(array, left, right);
				right--;
			}			
		}
		swap(array, left, array.length - 1);
		return array;
	}
	
	public static void swap(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
	
	public static void print(int[] arr) {
		for(int i = 0; i < arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	 
	public static void main(String[] args) {
		int[] one = new int[] {1,7,2,6,8,3,4,5,9};
		print(one);
		
		int pivotIndex = 3;
		System.out.println("pivot number: " + one[pivotIndex] + " at index " + pivotIndex);
		System.out.println();
		print(partition(one, pivotIndex));
	}
}
