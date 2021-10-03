package string;
/**
 * Remove Adjacent Repeated Characters I
 *
 * Remove adjacent, repeated characters in a given string,
 * leaving only one character for each group of such characters.
 *
 * Example
 * “aaaabbbc” is transferred to “abc”
 * Corner Cases
 *
 * If the given string is null, returning null or an empty string are both valid.
 * */
public class RemoveAdjacentRepeatedCharacters {
    /**
     * abcaabba
     *   s
     *         f
     *
     *
     * aaaabbbc
     *  s
     *
     * a
     *
     * abc ababc
     *   s
     *         f
     * ab
     *
     * */

    public static String remove(String s) {
        if (s == null) {
            return null;
        }
        char[] array = s.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            //repeated elements will be ignore except for the first character in the
            //sequence
            if (fast == 0 || array[fast] != array[slow - 1]) {
                array[slow] = array[fast];
                slow++;
            }
        }
        return new String(array, 0, slow);
    }

    public static void swap(char[] array, int  x, int y) {
        char tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
    public static void main(String[] args) {
        String s = "aaaabbbc";
        String res = remove(s);
        System.out.println(res);
    }
}
