package dynamic_programming;

/**
 * 9:32 - 9:42
 * input: 1.string1 2.string2
 * output: minimum operations needed to transform str1 to str2
 * operations include: replace, delete and insert
 * note: when insert/delete indexes will change
 * <p>
 * string1: sigh
 * string2: asith
 * one way of transform s1 to s2:
 * iterate the string from index 0 to the end
 * 0123
 * sigh
 * insert at index 0:a
 * sigh->asigh
 * <p>
 * delete: g
 * sigh-> asigh -> asih
 * <p>
 * inset: t
 * sigh-> asigh -> asih -> asith
 * <p>
 * m[i]: stores number of operation needed to change the s1 to s2
 */
public class EditDistance {

}
