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
        int slow = 0;
        //aaaabbbc
        //s
        //    f
        for (int fast = 0; fast < array.length; fast++) {

            if (array[slow] != array[fast - 1]) {

                slow++;
                array[fast] = array[slow];
            }

        }
        return new String(array, 0, slow);
    }
    public static void main(String[] args) {
        String s = "aaaabbbc";
        System.out.println("Original String: " + s);
        System.out.println(removeDup(s));
    }
}
