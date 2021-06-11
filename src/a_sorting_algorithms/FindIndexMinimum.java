package a_sorting_algorithms;

public class FindIndexMinimum {
	//return the index of the smallest number in the array
	public static int findMinimum(int[] array) {
		int min = 0;
		for(int i = 1; i < array.length; i++) {
			if(array[i] < array[min]) {
				min = i;
			}
		}
		return min;
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

		int minIndex = findMinimum(array);
		System.out.println("min index: " + minIndex + " number: " + array[minIndex]);
	}
}
