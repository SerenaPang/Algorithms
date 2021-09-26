package class12_DynamicProgramming;

/**
 * 9:11 - 9:21
 * input: {1,3,2,0,3} or {1,3,2,1,3}
 * note: value means the max number of jumps we can have,
 * we can jump less than the value or = to the value
 * output: true/false
 * <p>
 * because eventually we have to jump from the beginning of the array to the
 * end of the array, so we can start jumping from the last number to the begining
 * of the array
 * 0 1 2 3 4
 * {1,3,2,0,3}
 * m[1]:
 * 0: jump to index 1, value 3
 * {
 * 3(at index 1):
 * 0: jump 3 steps (out of bound)
 * 1: jump 1 steps -> true
 * 2: jump 2 steps (out of bound)
 * }
 * 1: jump to index 3, value 0
 * 2: jump to index 1, value 3
 */
public class ArrayHopper1 {
    public boolean canJump(int[] array) {
        if (array.length == 1) {
            return true;
        }
        boolean[] canJump = new boolean[array.length];
        //last to the 2ed number
        for (int i = array.length - 2; i >= 0; i--) {
            if (i + array[i] >= array.length - 1) {//if we are at the// last to the 2ed number, it means we are able tojump from there to the end
                canJump[i] = true;
            } else {//we check if there are any indexes are going to reach to the end
                for (int j = array[i]; j >= 1; j--) {//for all the steps, we check if there are any cases we can jump to the target
                    if (canJump[j + i]) {
                        canJump[i] = true;
                        break;
                    }
                }
            }
        }

        return canJump[0];
    }

}
