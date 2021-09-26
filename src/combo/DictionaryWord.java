package combo;

/**
 * 10:39 - 10:49
 * <p>
 * input: 1.dictionary: bob,cat,rob  2.string: bobcatrob
 * output: bob|cat|rob -> true
 * <p>
 * bobcatrob
 * memo[1]:(b|obcatrob) -> false
 * memo[2]:(bo|bcatrob) -> false
 * memo[3]:(bob|catrob) -> true
 * memo[4]:(bobc|atrob) -> false
 * memo[5]:(bobca|trob) -> false
 * memo[6]:(bobcat|rob) -> true
 * memo[7]:(bobcatr|ob) -> false
 * memo[8]:(bobcatro|b) -> false
 * <p>
 * memo[2]:(bo|bcatrob) more ways to cut it...
 * (b|o) -> false | false
 * <p>
 * memo[3]:(bob|catrob)
 * (bob) -> true
 * (b|ob) -> false | false
 * (bo|b) -> false | false
 * (b|o|b) -> false | false | false
 * <p>
 * induction rule:
 */
public class DictionaryWord {
}
