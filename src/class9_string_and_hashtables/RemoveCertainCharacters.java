package class9_string_and_hashtables;

import java.util.HashSet;
import java.util.Set;

/**
 * Remove given characters in input string, the relative order of other characters should be remained. Return the new string after deletion.
 * Assumptions
 * The given input string is not null.
 * The characters to be removed is given by another string, it is guaranteed to be not null.
 * Examples
 * input = "abcd", t = "ab", delete all instances of 'a' and 'b', the result is "cd".
 * */
public class RemoveCertainCharacters {
    //create a set to put the target char to be removed
    //use slow and fast pointer to go through the whole string, slow pointer copy the fast pointer if keep, otherwise, fast keep moving forward
    public static String removeCertainChar(String input, String remove){
        char[] array = input.toCharArray();
        char[] remo = remove.toCharArray();
        Set<Character> targetToRemove = new HashSet<>();
        for(int i = 0; i < remo.length; i++){
            targetToRemove.add(remo[i]);
        }
        //abcde
        //i
        //s
        //f
        int slow = 0;
        for(int fast = 0; fast < array.length; fast++){
            //if it's the char we want to remove, we don't need to copy, fast move to next char
            if (targetToRemove.contains(array[fast])) {
                //do nothing
            } else {//it's the char we want to keep, then copy fast pointer to slow, slow increment to next position
                array[slow] = array[fast];
                slow++;//remember to increment the position here!
            }
        }
        System.out.println("here");
        return new String(array, 0, slow);
    }

    public static void main(String[] args) {
        String input = "abcde";
        String remove = "ab";
        System.out.println("Original String: " + input);
        System.out.println("Remove all the " + remove);
        System.out.println("After Removing: " + removeCertainChar(input, remove));
    }
}
