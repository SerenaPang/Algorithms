package basic_11_quicksort_rainbowsort;

import java.util.Random;

public class QuickSort {
	private static Random random = new Random();
	
	public static void swap(int[] array, int x, int y) {
		int tmp = array[x];
		array[x] = array[y];
		array[y] = tmp;
	}
	
	private static void quickSort(int[] array, int left, int right) {
		if(left >= right) {
			return;
		}
		
		int pivotIndex = random.nextInt(right - left + 1);
		swap(array, pivotIndex, right);
		int i = left;
		int j = right - 1;
		while(i <= j) {
			if(array[i] < array[right]) {
				i++;
			}else {
				swap(array, i, j);
				j--;
			}
		}
		swap(array, right, i);
		
		quickSort(array, left, i - 1);
		quickSort(array, i + 1, right);
	}
	
	public static int[] quickSort(int[] array) {
		if(array == null || array.length <= 1) {
			return array;
		}
		quickSort(array, 0, array.length - 1);
		return array;
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
		print(quickSort(one));
	}
}
