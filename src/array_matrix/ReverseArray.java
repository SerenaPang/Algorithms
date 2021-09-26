package array_matrix;

public class ReverseArray {
	public static int[] reverse(int[] arr) {
		int i = 0;
		int j = arr.length - 1;
		while(i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		return arr;
	}
	
public static void main(String[] args) {
	int arr[] = {2,3,8,4,1};
	//1 4 8 3 2
	InsertElementInArray.print(arr);
	System.out.println();
	int[] reversed = reverse(arr);
	InsertElementInArray.print(reversed);
}
}
