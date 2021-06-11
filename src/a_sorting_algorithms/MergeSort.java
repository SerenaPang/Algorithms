package a_sorting_algorithms;

public class MergeSort {
	//{1,7,2,6,8,3,4,5,9};
	/**
	 * pass in the range to sort
	 * return the result array
	 * */
	public static int[] mergeSort(int[] array) {
		if(array == null || array.length == 0) {
			return array;
		}
		//have a recursion method to break the array to half and half and half
		int left = 0;
		int right = array.length - 1;
		
		return sort(array, left, right);
	}
	
	/**
	 * recursion method breaks the array to half each iteration
	 * until it reaches the bases case
	 * return the sorting and merging result of each iteration
	 * */
	public static int[] sort(int[] array, int left, int right) {
		//base case
		if(left == right) {
			return new int[] {array[left]};
		}		
		int mid = left + (right - left) / 2;
		int[] one = sort(array, left, mid); 
		int[] two = sort(array, mid + 1, right);
		return merge(one, two); 
	}
	
	//1 2 7 4 
	//5 6 3 8
	public static int[] merge(int[] one, int[] two) {
		int newArr[] = new int[one.length + two.length];
		//keep track of the index in 2 arrays and 
		//populate new elements in the new array
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < one.length && j < two.length) {
			if(one[i] < two[j]) {
				newArr[k] = one[i];
				i++;
			}else {
				newArr[k] = two[j];
				j++;
			}
			k++;
		}
		
		//post processing
		
		while(i < one.length) {
			newArr[k] = one[i];
			i++;
			k++;
		}
		
		while(j < two.length) {
			newArr[k] = two[j];
			j++;
			k++;
		}
		return newArr;
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
		System.out.println("Merge: ");
		print(mergeSort(one));
	}
}
