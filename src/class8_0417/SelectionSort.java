package class8_0417;

public class SelectionSort {
	public void selectionSort(int[] array) {
		if(array == null || array.length <= 1) {
			return;
		}
		
		for(int i = 0; i < array.length - 1; i++) {
			int min = i;
			for(int j = i + 1; j < array.length; j++) {
				if(array[j] < array[min]) {
					min = j;
				}
			}
			swap(array, i, min);	
		}
	}

	public void swap(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
}
