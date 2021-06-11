package a_sorting_algorithms;

public class SelectionSort {
	
	// in every iteration,find the smallest number in the array
	//move to the next round to find the smallest number
	// swap the smallest number position with the first number
	// until the whole array is done, return the sorted array
	//23, 5, 3, 1, 7, 3, 2, 6, 9
	public static int[] slectionSort(int[] array) {
		//sanity check
		if(array == null || array.length <= 1) {
			return array;
		}
		for(int i = 0; i < array.length - 1; i++) {///we don't have to compare the last element, it's already sorted
			int smallest = i;
			for(int j = i + 1; j < array.length; j++) {
				
				if(array[smallest] > array[j]) {
					smallest = j;
				}
			}
			swap(array, i, smallest);
		}	
		return array;
	}
	
	public static void swap(int[] array, int x, int y) {
		int tmp = array[x];
		array[x] = array[y];
		array[y] = tmp;
	}

	public static void print(int[] arr) {
		for(int i = 0; i < arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	} 
	public static void main(String[] args) {
		int[] array = new int[] {23, 5, 3, 1, 7, 3, 2, 6, 9};
		print(array);
		System.out.println("sorted array: ");
		print(SelectionSort.slectionSort(array));
	}
}
