package combo;

import java.util.ArrayList;
import java.util.List;

/**
 * 9:39 - 9: 49
 * 9:00 -9:20
 * cents type: [1,5,10,25]
 * target number: 99 cents
 * find all combinations of the coins make up to the target
 * <p>
 * recursion tree:
 * 4 levels, each level represents one coin type
 * how many branches: target number / coin value = the max number of this coin you can take
 * that doesn't go over the target amount
 * for example: 99/1 = 99, [99,0,0,0],99 1 cents and 0 others
 * 99/25 = 4, most we can take 4 25cents
 * [x,x,x,0], [x,x,x,1], [x,x,x,3], [x,x,x,4]
 * <p>
 * base case: iterate through the coin type array and reach the end
 * <p>
 * TC:O(n)the level of the recursion tree is n which is the types of the coins we have
 * SC:O(n) represents the number of coins
 */
public class CombinationOfCoins {
    public List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(target, coins, 0, cur, result);
        return result;
    }

    /**
     * i represents the number of this coin type we have taken
     * money left represents: how many money left after we pick this number of coin type
     */
    public void helper(int target, int[] coins, int index, List<Integer> cur, List<List<Integer>> result) {
        if (index == coins.length - 1) {
            if (target % coins[coins.length - 1] == 0) {
                cur.add(target / coins[coins.length - 1]);
                cur.remove(cur.size() - 1);
            }
            return;
        }
        int max = target / coins[index];
        for (int i = 0; i <= max; i++) {
            cur.add(i);
            helper(target - i * coins[index], coins, index + 1, cur, result);
            cur.remove(cur.size() - 1);
        }
    }

}
