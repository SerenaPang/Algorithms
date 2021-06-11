package a_sorting_algorithms;

public class MergeTwoSortedArrays {
	public static int[] merge(int[] one, int[] two) {
		int[] newArr = new int[one.length + two.length];
		
		//keep track of the index in the array
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < one.length && j < two.length) {
			if(one[i] <= two[j]){
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
		int[] one = new int[] {1,3,4,5,7};
		int[] two = new int[] {2,6,8,9};
		print(one);
		print(two);
		System.out.println("Merge: ");
		print(merge(one, two));
	}
}
