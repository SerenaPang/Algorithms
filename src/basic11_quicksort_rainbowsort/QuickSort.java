package basic11_quicksort_rainbowsort;

import java.util.Random;

public class QuickSort {
	private Random random = new Random();
	
	private void swap(int[] array, int x, int y) {
		int tmp = array[x];
		array[x] = array[y];
		array[y] = tmp;
	}
	
	private void quickSort(int[] array, int left, int right) {
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
	
	public void quickSort(int[] array) {
		if(array == null || array.length <= 1) {
			return;
		}
		quickSort(array, 0, array.length - 1);
	}
}
