package combo;

/**
 * 10:27 - 10:39
 * input: rope of length n : _____
 * restriction: at least cut 1 once,
 * output: find all possible ways cutting rope and find the cut way that generates the
 * max product
 * <p>
 * memo[1]: _|____
 * memo[2]: __|___
 * memo[3]: ___|__
 * memo[4]: ____|_
 * <p>
 * <p>
 * find the biggest product of all cases CUTTING the rest of the rope,
 * and then compare that product with the product of NOT CUTTING it
 * record the max at memo
 * memo[1]: _|____ last 4 meters rope, more ways to cut it...
 * _|____
 * _|_|___
 * _|__|_
 * _|_|_|_|_
 * <p>
 * memo[2]: __|___ last 3 meters rope, more ways to cut it...
 * __|___
 * __|_|__
 * __|__|_
 * __|_|_|_
 */
public class MaxProductCuttingRope {
    public int maxProduct(int length) {
        int[] array = new int[length + 1];
        array[1] = 0;
        for (int i = 2; i <= length; i++) {
            for (int j = 1; j < i; j++) {//partitioning the rightmost rope
                //not cutting it: j cutting it: array[j]
                array[i] = Math.max(array[i], Math.max(j, array[j] * (i - j)));
            }
        }
        return array[length];
    }
}
