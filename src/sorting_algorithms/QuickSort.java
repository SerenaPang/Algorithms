package sorting_algorithms;

public class QuickSort {
    /**
     * first pick a random one number as a pivot, and swap this number with the last number in the array
     * second partition the array starting from beginning to the end, except the pivot
     * third after one round of partition, swap the pivot back to where i is
     * <p>
     * TC: O(n ^ 2) or O(nlogn)
     * SC: O(n) or O(logn)
     */
    public static int[] quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    public static void quickSort(int[] array, int left, int right) {
        System.out.println("left: " + left);
        System.out.println("right ");
        if (left >= right) {
            return;
        }
        int pivotPos = partition(array, left, right);
        quickSort(array, left, pivotPos - 1); //pivot not included
        quickSort(array, pivotPos + 1, right);  //pivot not included
    }

    /**
     * the steps are very similiar to merge sort in the sense that
     * first it spilt the array to 2 halves, but instead to split in the mid point
     * we split it from the pivot point
     * and then we partition the 2 halves seperately,
     * and then for left halve, we pick a pivot again to split the left half
     * and partition the left left halves and the left right havlves. until
     * left and right overlap, we can not pick a pivot that is not the number itself
     * <p>
     * and now because all the elements are sorted already, the array is sorted
     */
    private static int partition(int[] arr, int left, int right) {
        int pivotIndex = pickPivot(left, right);
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, right);

        int leftBound = left;
        int rightBound = right - 1; // exclude the pivot

        while (leftBound <= rightBound) {
            if (arr[leftBound] < pivot) {
                leftBound++;
            } else if (arr[rightBound] > pivot) {
                rightBound--;
            } else {
                swap(arr, leftBound++, rightBound--);
            }
        }
        swap(arr, leftBound, right);//put pivot back to the place where it should be

        return leftBound;
    }

    public static int pickPivot(int left, int right) {
        return left + (int) (Math.random() * (right - left + 1));
    }

    public static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //  int[] arr = new int[]{7,3,9,1,4,8,2,6,5};
        //  int[] arr = new int[]{5,2,1,3,4};
        int[] arr = new int[]{2, 1, 0};
        // print(arr);
        print(quickSort(arr));
        System.out.println("3 % 7: " + (3 % 7));
        System.out.println("3 % 11: " + (3 % 21));
        System.out.println("1 % 2: " + (1 % 2));
    }
}
