package class9_string_and_hashtables;
/**
 * Remove adjacent, repeated characters in a given string, leaving only one character for each group of such characters.
 * Assumptions
 * Try to do it in place.
 * Examples
 * “aaaabbbc” is transferred to “abc”
 * Corner Cases
 * If the given string is null, returning null or an empty string are both valid.
 * */
public class RemoveAdjacentDuplicates {
    public static String removeDup(String s){
        /***s convert to an array, have 2 pointers iterate thru the whole array, slow pointer would keep the first occurrence of the char
         * and the we have a fast pointer check if the later char is equals to the current char, if equal to slow, don't copy it,
         * but if different, slow pointer ++ and copy that char
        */
        char[] array = s.toCharArray();
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            //we will only keep 1 copy of the char: aaaabbbc  -> abc
            char currentChar = array[i];
            System.out.print("index: " + i + " " + currentChar + " ");
            System.out.println("end: " + end);
            //note end - 1 is checking the one in the previous is not the same as the cur char
            if(i == 0 || array[end - 1] != currentChar){
                //note here the ||or has sequence, so it must be check if
                //index == 0 first
                array[end] = array[i];
                end++;
            }
        }
        return new String(array, 0, end);
    }
    public static void main(String[] args) {
        String s = "aaaabbbc";
        System.out.println("Original String: " + s);
        System.out.println(removeDup(s));
    }
}
