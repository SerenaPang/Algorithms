package combo;

import java.util.ArrayList;
import java.util.List;

/**
 * 9:22 - 9:32
 * 9:40 -10:00
 * input: no duplicate "abc" -> output: "abc" "acb" "bac" "bca" "cba" "cab"
 * base case: iterate through the whole string, when reach end
 * recursion tree: 3 levels, each level represents 1 position to put a letter
 * each node has 3 branches at the first level, and then n -1, n - 2, and 1 branch at
 * the last level
 * <p>
 * ___:each position has 3 choices: abc
 * <p>
 * what do we need to do in the current level:swap the position of the string,
 * add it to result, and swap it back
 * <p>
 * TC: O(n!)dominant level is the last 2ed level
 * SC: O(n)
 */
public class AllPermutations {
    public static List<String> findAllPermu(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null) {
            return result;
        }
        char[] array = s.toCharArray();
        helper(array, 0, result);
        return result;
    }

    public static void helper(char[] array, int index, List<String> result) {
        //base case
        if (index == array.length) {
            result.add(new String(array));
            return;
        }
        /**
         * swap and swap back
         * i represents the level and i starts from the level INDEX,
         * so that it doesn't have to start from the beginning of the string
         * and to take off the repeat letter
         * */
        for (int i = 0; i < array.length; i++) {
            swap(array, index, i);
            helper(array, index + 1, result);
            swap(array, index, i);
        }
    }

    public static void swap(char[] array, int x, int y) {
        char temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
