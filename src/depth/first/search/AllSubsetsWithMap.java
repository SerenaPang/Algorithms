package depth.first.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * base case: when do we stop?
 * -when there is no letter to be append
 */
public class AllSubsetsWithMap {

    public static HashMap<Integer, List<Integer>> subSets(Integer[] arr) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashMap<Integer, List<Integer>> sum = new HashMap<Integer, List<Integer>>();
        if (arr == null) {
            return sum;
        }
        List<Integer> sub = new ArrayList<Integer>();
        helper(arr, sub, 0, result, sum);
        return sum;
    }

    private static void helper(Integer[] arr, List<Integer> sub, int index, List<List<Integer>> result, HashMap<Integer, List<Integer>> sum) {
        if (index == arr.length) {
            int sumOneSub = 0;
            for (int i = 0; i < sub.size(); i++) {
                sumOneSub = sumOneSub + sub.get(i);
            }
            sum.put(sumOneSub, new ArrayList<>(sub));
            result.add(new ArrayList<>(sub));
            return;
        }
        helper(arr, sub, index + 1, result, sum);
        sub.add(arr[index]);
        helper(arr, sub, index + 1, result, sum);
        sub.remove(sub.size() - 1);
    }

    public static void print(HashMap<Integer, List<Integer>> sum) {
        System.out.println("Print Map: ");
        System.out.println(sum.entrySet());
    }

    public static void print(List<List<Integer>> res) {
        int count = 0;
        for (List<Integer> sub : res) {
            System.out.println(sub);
            count++;
        }
        System.out.println("Total number of subsets: " + count);
    }

    public static void main(String[] args) {
        //Integer[] arr = new Integer[]{1,2,3,4,5};
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5};
        HashMap<Integer, List<Integer>> res = subSets(arr);
        print(res);
    }
}
