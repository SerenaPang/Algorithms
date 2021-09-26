package dynamic_programming;

/**
 * 10:09 - 10:19
 * input: matrix contains 0s and 1s
 * output: the largest length of the x shape
 * restriction: complete x shape, formed by 1, how we count the length is from center
 * to the end, not from one end to another end
 * 1 grid is a length 1 cross
 * 1
 * 111 : length = 2
 * 1
 * <p>
 * m[i]:
 * <p>
 * records the length of all the x shapes?
 * or the overlap x shapes, so when there is bigger x we inherited the previous x length
 * <p>
 * global max keep track of the largest length of the x
 * <p>
 * look left/right/up/down, count consecutive 1s, take min
 * for every center, 4 directions
 * m left: stand on a[i][j] and look to left a[i][j - 1]
 * m right:stand on a[i][j] and look to left a[i][j + 1]
 * m up:
 * m down:
 */
public class LargestXOf1s {
}
