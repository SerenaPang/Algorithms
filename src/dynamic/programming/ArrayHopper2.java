package dynamic.programming;

/**
 * 9:25 - 9:31
 * input: {3,3,1,0,4}
 * restriction: minimum number of jumps to the end
 * <p>
 * when recording the jumps in memo, condition to compare which option(steps jump to the end) is
 * is smaller, record the smaller one in memo
 * <p>
 * {3,3,1,0,4}
 * m[1]: 4 steps{
 * 0:
 * 1:
 * 2:
 * 3:
 * }
 * m[2]: 0 step
 * m[i]represents the minimum steps that are needed to jump to the target
 */
public class ArrayHopper2 {
    public int minJump(int[] array) {
        int length = array.length;
        int[] minJump = new int[length];
        minJump[0] = 0;
        /**
         * i is the index from 1 to the end of the array
         * j is the value of i, which checks all the value cases
         *
         *  {1,2,3}
         *     i:1
         *   j: {
         *       1:
         *       0:
         *   }
         *  {1,0,2}
         * */

        for (int i = 1; i < length; i++) {
            minJump[i] = -1;//unreachable
            for (int j = i - 1; j >= 0; j--) {
                if (j + array[j] >= i && minJump[i] != -1) { //if j < i we are not able to jump
                    if (minJump[i] == -1 || minJump[i] > minJump[j] + 1) {
                        minJump[i] = minJump[j] + 1;
                    }
                }
            }
        }

        return minJump[length - 1];
    }
}
