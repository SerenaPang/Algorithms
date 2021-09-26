package class9_string_and_hashtables;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all numbers that appear in both of two sorted arrays (the two arrays are all sorted in ascending order).
 * Assumptions
 * In each of the two sorted arrays, there could be duplicate numbers.
 * Both two arrays are not null.
 * Examples
 * A = {1, 1, 2, 2, 3}, B = {1, 1, 2, 5, 6}, common numbers are [1, 1, 2]
 * */
public class commonNumberInTwoSortedArray {
    public static List<Integer> findCommonNumber(int[] a, int[] b){
        List<Integer> result = new ArrayList<>();
        //2 pointers each iterate thru 2 arrays to check if the number is the same one adn add it to result array
        //if the number in one array is smaller, it needs to move forward until it reach to the
        //one that's equal or greater to it in another array
        int i = 0;
        int j = 0;
        while(i < a.length && j < b.length){
            if(a[i] == b[j]){
                result.add(a[i]);
                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else{
                j++;
            }
        }
        printArrayList(result);
        return result;
    }
    public static void printArrayList(List<Integer> array){
        for (int i = 0; i < array.size(); i++) {
            System.out.print( array.get(i) + " " );
        }
    }
    public static void printArray(int[] array){
        System.out.println("Print Array ");
        for (int i = 0; i < array.length; i++) {
            System.out.print( array[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] a = {1,1,2,2,3};
        int[] b = {1,1,2,5,6};
        printArray(a);
        printArray(b);
        System.out.println("common number in array" + " : ");
        printArrayList(findCommonNumber(a,b));
    }
}
