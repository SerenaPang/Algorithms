package sorting_algorithms;

/**
 * first split the array in half
 * second split each halve recursively until array can not be split anymore
 * third merge the two halves by comparing which one is bigger, and swap if necessary
 * until there is nothing left to be merged
 */
public class MergeSort {

    public static int[] mergeSort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        return split(arr, left, right);
    }

    public static int[] split(int[] arr, int left, int right) {

        if (left == right) {
            //  System.out.println("left: " + arr[left]);
            //here in the base case, we return this one element as an array
            return new int[]{arr[left]};

        }

        System.out.println("left: " + left);
        System.out.println("right: " + right);
        int mid = left + (right - left) / 2;
        int[] leftArr = split(arr, left, mid);
        int[] rightArr = split(arr, mid + 1, right);


        return merge(leftArr, rightArr);
    }

    public static int[] merge(int[] one, int[] two) {
        int oneLen = one.length;
        int twoLen = two.length;
        int[] res = new int[oneLen + twoLen];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < oneLen && j < twoLen) {
            if (one[i] < two[j]) {
                res[index] = one[i];
                index++;
                i++;
            } else {
                res[index] = two[j];
                index++;
                j++;
            }
        }

        //remember to do the post processing since we might have one halve smaller than the other halve
        //and we have to put the rest of the number from the halve that's left out
        while (i < oneLen) {
            res[index] = one[i];
            index++;
            i++;
        }

        while (j < twoLen) {
            res[index] = two[j];
            index++;
            j++;
        }

        return res;
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
        print(mergeSort(arr));
    }
}
