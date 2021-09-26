package sorting_algorithms;

/**
 * Given a list of unsorted elements,
 * we select the smallest element in each round and swap it with the
 * element in the first place(or swap it with the first unsorted place)
 * <p>
 * TC: O(n ^ 2)
 * SC: O(1)
 */
public class SelectionSort {

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int smallest = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[smallest]) {
                    smallest = j;
                }
            }
            swap(arr, i, smallest);
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 3, 9, 1, 4, 8, 2, 6, 5};
        print(arr);
        print(selectionSort(arr));
    }

}
