package depth.first.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of characters represented by a String, return a list containing all subsets of the characters.
 * <p>
 * Assumptions
 * <p>
 * There are no duplicate characters in the original set.
 * ​Examples
 * <p>
 * Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
 * Set = "", all the subsets are [""]
 * Set = null, all the subsets are []
 */
public class Allsubsets {

    public static List<String> allSubsets(String set) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] array = set.toCharArray();
        helper(array, 0, sb, result);
        print(result);
        return result;
    }

    /**
     * a recursive helper method for allSubsets, to find all subsets for the input array
     * by appending the character of the current index
     * <p>
     * base case: when to stop? when the index reaches to the last index of the input array
     * <p>
     * what do we need to do in the current level?
     * - when we are at current index, we have to choice:
     * 1. keep the current state by not append anything to the string(a)
     * 2. append the index to the string (ab)
     * <p>
     * a     {}
     * /  \   /  \
     * ab    a b    {}
     * / \
     * abc  ab
     * when we arrive to the next level, we do the same thing by having the 2 states of
     * 1.append the character from the next index
     * or
     * 2. not append the next index, and keep the current states
     * <p>
     * - how we are reducing the problem?
     * by incrementing the index until it reaches to the end of the string
     * <p>
     * how do we populate the result?
     * - for the 2 states that we get, first we aew at ab, and then we increment the index
     * to the next level, and then it reaches to the base case, where we add the string to
     * the list of result. BUT the next step is we have to from abc return to the previous ab,
     * so we have to remove the last character of the string builder c and get ab
     * <p>
     * now we are at  ab, we can go to the right side of the tree, by reversing ab to a, and then we arrive to a
     * <p>
     * and we hav to believe that in every level, it will do the same until we have recursively collect all the result
     * of the last level of the recursion tree
     * <p>
     * we save the result to the list when we reach the base case
     */
    public static void helper(char[] array, int index, StringBuilder sb, List<String> result) {
        if (index == array.length) {
            result.add(sb.toString());
            return;
        }
        //when we choose not to pick the the character in the current level
        //we just increment the index in every index when we call the function without appending the character
        helper(array, index + 1, sb, result);
        //when we choose to pick the character in the current level, we not only increment the index
        //but also appending the character in the current level to the string builder
        //string builder was empty at first, and then append index 0, increment
        //then index 1, 2, 3..., and because we did not delete any character in the string builder,
        //we carry all the appended characters to the next level
        //but because we are back tracking to the previous level, we have to return to the state of the last level
        //by removing the last appended character in the string builder
        helper(array, index + 1, sb.append(array[index]), result);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void print(List<String> list) {
        System.out.println("Printing list: ");
        if (list == null || list.size() == 0) {
            System.out.println("list is empty");
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println("{" + list.get(i) + "}");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String s = "abc";
        allSubsets(s);
    }
}
