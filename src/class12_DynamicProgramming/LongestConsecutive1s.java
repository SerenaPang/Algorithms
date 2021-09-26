package class12_DynamicProgramming;

/**
 * 9:47 - 9: 55
 * <p>
 * input: {0,1,0,1,1,1,0}
 * restriction: consecutive 1s
 * output:{1,1,1} -> length: 3
 * <p>
 * {0,1,0,1,1,1,0}
 * m[1]:{0}
 * 0 (we want 1, not 0)
 * m[2]:{0,1}
 * 0 1
 * m[3]:{0,1,0} (reset to 0)
 * 0 1 0
 * m[4]:{0,1,0,1}
 * 0 1 0 1 (start accumulating)
 * <p>
 * m[4]:{0,1,0,1,1}
 * 0 1 0 1 2 (consecutive, increment the length)
 * <p>
 * m[4]:{0,1,0,1,1,1}
 * 0 1 0 1 2 3 (consecutive, increment the length)
 * <p>
 * m[5]:{0,1,0,1,1,1,0}
 * 0 1 0 1 2 3 0(reset)
 * <p>
 * global max keep track of the max length
 * <p>
 * only when previous one is 1 we can inherit + 1, else we set it to 0
 */
public class LongestConsecutive1s {
}
