package class9_string_and_hashtables;
/**
 *Given an array of elements, reorder it as follow:
 *
 * { N1, N2, N3, …, N2k } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k }
 * { N1, N2, N3, …, N2k+1 } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1 }
 * Try to do it in place.
 *
 * Assumptions
 *
 * The given array is not null
 * Examples
 *
 * { 1, 2, 3, 4, 5, 6} → { 1, 4, 2, 5, 3, 6 }
 * { 1, 2, 3, 4, 5, 6, 7, 8 } → { 1, 5, 2, 6, 3, 7, 4, 8 }
 * { 1, 2, 3, 4, 5, 6, 7 } → { 1, 4, 2, 5, 3, 6, 7 }
 *
 * */
/**
 解法1:对input做一个merge sort，但我们不能比较数字所以要写一个新的comparator让字母小于数字
 解法2： ABCD1234 -> A1B2C3D4
 将ABCD1234分成四个chunck：AB CD 12 34
 然后将中间两个chunck的位置 AB CD12 34调换变成AB 12CD 34
 再将AB 12CD 34左半部分的AB12 CD34 的B1两个调转 变成A1B2， 右半部分做同样的操作

 但如果是奇数个怎么办？
 还是一样的切成4个chunck， 但要怎么切？: ABCDEFG1234567 -> ABCD EFG 1234 567 注意第一个chunk要和第三个chunck 里的letter个数一样，必须要等长
 因为当中间不对称的时候没办法再换字母
 ABC     DEFG 123 4567
 |  \
 l1 l2  lm    m   rm r
 有了坐标就可以做爱虎事件
 */
public class StringShuffling {
}
