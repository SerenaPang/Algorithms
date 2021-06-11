package a_sorting_algorithms_quick_sort;

import java.util.Random;

public class QuickSort {
	public static Random random = new Random();
	public static int[] quickSort(int[] array) {
		//sanity check
		if(array == null || array.length == 0) {
			return array;
		}
		int left = 0;
		int right = array.length - 1;
		
		quickSort(array, left, right); //call the method to sort the array
		return array; //return the sorted array
	}
	//recursive method that splits the array each iteration and partition each iteration to reach the base case
	public static void quickSort(int[] array, int left, int right) {
		//base case
		if(left >= right) {
			return;
		}
		int pivotIndex = left + random.nextInt(right - left + 1);
		
		//swap the pivot number with the number in the right most of the array
		swap(array, pivotIndex,right);
				
		int i = left;
		int j = right - 1;
		
		while(i <= j) {
			//compare with array right, not array[j]
			if(array[i] < array[right]) {//if number is less than pivot, stay in the same region
				i++;
			}else {//if number is large than the pivot, swap it with right it's joining to the right region
				swap(array, i, j);
				j--;
			}
		}
		//swap the pivot back to the position that fits it
		swap(array, i, right);
		quickSort(array, left, i - 1); //does not include the pivot because we switch it to the end  
		quickSort(array, i + 1, right);//of the array
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
		print(quickSort(one));
	}
}
