package class9_string_and_hashtables;

import java.util.ArrayList;
import java.util.List;

/**
 * 10:00 - 10:10
 * input: abc
 * output: abc acb bac bca cab cba
 * <p>
 * recursion tree
 */
public class AllPermutations {
    public List<String> findAllPermutations(String s) {
        List<String> result = new ArrayList<>();
        char[] array = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        helper(array, 0, sb, result);
        return result;
    }

    public void helper(char[] array, int index, StringBuilder solutionPrefix, List<String> result) {
        if (index == array.length - 1) {
            result.add(solutionPrefix.toString());
            return;
        }
        //   swap(array, index, index + 1);

    }

    public void swap(char[] array, int x, int y) {
        char tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
}
