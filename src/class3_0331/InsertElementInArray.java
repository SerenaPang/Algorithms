package class3_0331;

public class InsertElementInArray {
/***given an array,
 * an element to insert,
 * and the index position to insert this element
 * return a new array with the element inserted
 * */
	public static int[] insert(int[] arr, int element, int position) {
		
		int newArr[] = new int[arr.length + 1];
		
		for(int i = 0; i < position; i++) {
			newArr[i] = arr[i];
		}
		newArr[position] = element;
		
		for(int k = position; k < arr.length; k++) {
			newArr[k + 1] = arr[k];
		}
		return newArr;
	}
	
	public static void print(int[] arr) {
		for(int i = 0 ;i < arr.length; i++) {
			System.out.println(i + " - " + arr[i]);
		}
	}
	
public static void main(String[] args) {
	int arr[] = {1,2,3,4,5};
	print(arr);
	System.out.println();
	int newArr[] = insert(arr, 0, 2);
	print(newArr);
	
}
}
