package basic_exam1;

public class DoubleDuplicate {
	public static int[] doubleElement(int array[], int ele) {
		int len = array.length;
		int count = 0;
		for(int i = 0; i < len; i++) {
			if(array[i] == ele) {
				count++;
			}
		}
		int newLen =array.length;
		int index = 0;
		int[] newArr = new int[len + count];
		for(int j = 0; j < newLen; j++) {
			if(array[j] == ele) {
				newArr[index] = array[j];
				newArr[index + 1] = array[j];
				index+=2;
			}else {
				newArr[index] = array[j];
				index++;
			}

		}
		return newArr;
	}
	
	public static void print(int[] arr) {
		for(int ele : arr) {
			System.out.print(ele + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {2,3,4,1,3,5,7,3};
		print(arr);
		System.out.println();
		int[] newArr = doubleElement(arr, 3);
		print(newArr);
	}
}
