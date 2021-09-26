package combo;

public class RemoveDuplicate {
	public static int[] removeDup(int[] array, int duplicate) {
		int len = array.length;
		int count = 0;
		for(int i = 0; i < len; i++) {
			if(array[i] == duplicate) {
				count++;
			}
		}
		int newArr[] = new int[len - count];
		int index = 0;
		for(int j = 0; j < len; j++) {
			if(array[j] == duplicate) {
				continue;
			}
			newArr[index++] = array[j];
		}
		return newArr;
	}
	
	public static void print(int[] arr) {
		for(int ele : arr) {
			System.out.print(ele + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {2,3,3,4};
		print(arr);
		int[] newArr = removeDup(arr, 3);
		print(newArr);
	}

}
