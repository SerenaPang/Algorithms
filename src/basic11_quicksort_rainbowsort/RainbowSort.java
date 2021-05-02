package basic11_quicksort_rainbowsort;

public class RainbowSort {
	public void rainowSort(int[] array) {
		if(array == null || array.length <= 1) {
			return;
		}
		int i = 0;
		int j = 0;
		int k = array.length - 1;
		
		while(j <= k) {
			if(array[j] == 1) {
				swap(array, i, j);
				i++;
				j++;
			}else if(array[j] == 2) {
				j++;
			}else {
				swap(array, j, k);
				k--;
			}
		}
	}
	
	public void swap(int[] array, int x, int y) {
		int tmp = array[x];
		array[x] = array[y];
		array[y] = tmp;
	}
	
}
