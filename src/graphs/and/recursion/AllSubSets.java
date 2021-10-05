package graphs.and.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 9.08-9.22
 * 1:55- 2:25
 * a b c
 * 0 0 0
 * 1 1 1
 * <p>
 * "abc" -> {},{a},{b},{c},{ab},{ac},{bc},{abc}
 * base case: when we have iterate through the whole string
 * <p>
 * recursion tree:
 * each level represents 1 letter, there are 2 branches represents take or not take
 * <p>
 * what do we want from the previous level?(parent node)
 * previous combination of letters
 * <p>
 * what do we report?
 * the final combination
 * <p>
 * what do we need to do in the current level?
 * decide take or not take(when take string builder + charAt i, when done take, reverse to the
 * original parent node, remove builder + charAt i)
 * and then add to result
 * <p>
 * recursion rule: index reach the end of the string
 * <p>
 * tips: add and delete count has to be the same
 * <p>
 * TC: binary tree, weight of the node is the same O(1), count the last level of node
 * O(2^n)
 * SC: Pink Path depth, O(n)
 */
public class AllSubSets {
    public static List<String> subSets(String str) {
        List<String> result = new ArrayList<String>();
        if (str == null) {
            return result;
        }
        char[] array = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        findAllSubset(array, 0, sb, result);
        return result;
    }

    /**
     * input: input string
     * index: index of the string
     * solutionPrefix: prefix is set, we are going to concatenate/not concatenate more letter
     */
    public static void findAllSubset(char[] input, int index, StringBuilder solutionPrefix, List<String> result) {
        //System.out.println("Solution Prefix: " + solutionPrefix.toString() + " ");
        if (index == input.length) {
            // System.out.println("Solution Prefix: " + solutionPrefix.toString());
            result.add(solutionPrefix.toString());
            return;
        }
        //not pick
        findAllSubset(input, index + 1, solutionPrefix, result);
        //pick
        solutionPrefix.append(input[index]);
        findAllSubset(input, index + 1, solutionPrefix, result);
        //remove
        solutionPrefix.deleteCharAt(solutionPrefix.length() - 1);
    }

    public static void printList(List<String> mList) {
        System.out.println("Print All subsets: ");
        for (int i = 0; i < mList.size(); i++) {
            System.out.println("{" + mList.get(i) + "} ");
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        List<String> result = new ArrayList<>(subSets(s));

        System.out.println("size: " + result.size());
        printList(result);
    }

}
