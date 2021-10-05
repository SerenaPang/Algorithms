package depth.first.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AllSubsetsWithList {


    public static List<List<Integer>> subSets(Integer[] arr) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (arr == null) {
            return result;
        }
        List<Integer> sub = new ArrayList<Integer>();
        helper(arr, sub, 0, result);
        return result;
    }

    private static void helper(Integer[] arr, List<Integer> sub, int index, List<List<Integer>> result) {
        if (index == arr.length) {
            result.add(new ArrayList<>(sub));
            return;
        }

        helper(arr, sub, index + 1, result);
        sub.add(arr[index]);
        helper(arr, sub, index + 1, result);
        sub.remove(sub.size() - 1);
    }

    public static void main(String[] args) {
        //Integer[] arr = new Integer[]{1,2,3,4,5};
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5};
        List<List<Integer>> res = subSets(arr);
    }
}
