package class9_string_and_hashtables;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array of size N - 1, containing all the numbers from 1 to N except one, find the missing number.
 * Assumptions: The given array is not null, and N >= 1
 * Examples
 * A = {2, 1, 4}, the missing number is 3
 * A = {1, 2, 3}, the missing number is 4
 * A = {}, the missing number is 1
 * */
public class MissingNumber1 {
    public static int findMissingNumber(int[] array){
        int result = 0;
        //put all the number to hash set and then iterate through the set to find which one is missing
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            numbers.add(array[i]);
        }
        printSet(numbers);
        int n = array.length;
        System.out.println("Length: " + n);
        //here note that we are not checking 1 to n including n, if it's in the set, it's good, if not ,return it
        for (int j = 1; j < n + 1; j++) {
            System.out.println("j: " + j);
            if (!numbers.contains(j)) {
                result = j;
            }
        }
        return result;
    }
    public static void printSet(Set<Integer> numbers){
        Object[] nums = numbers.toArray();
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i].toString() + " ");
        }
    }
    public static void main(String[] args) {
        int[] array = {2, 1, 4};
        int result = findMissingNumber(array);
        System.out.println("The missing number is : " + result);
    }
}
