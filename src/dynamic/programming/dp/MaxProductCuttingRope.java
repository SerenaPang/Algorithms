package dynamic.programming.dp;

/**
 * m【i】存的是i段绳子最好的切法。
 * _ _ _ _ _
 * m0 = 0 不成立，因为必须切一刀
 * _ ｜_ _ _ _
 * _ _｜ _ _ _
 * _ _ _｜ _ _
 * _ _ _ _｜ _
 * m1 = 1 （1 * 4）
 * _ _｜ _ _ _
 * _ ｜_｜ _ _ _
 * m2 = max(切一道在2好： 2 * 3，还是切一刀在1然后再切一刀在2好：1*1*3) = max（6， 3）= 6
 * _ _ _ ｜_ _
 * _ ｜_ _ ｜_ _
 * _ _｜ _ ｜_ _
 * _｜ _｜ _ ｜_ _
 * m3 = max（切一刀在3好， 还是3段绳子最好的切法好：有 1 * 2 ；2 * 1；1*1*1）= max（3，2）
 * <p>
 * _ _ _ _ ｜_
 * _｜ _ _ _ ｜_
 * _ _｜ _ _ ｜_
 * _ _ _｜ _ ｜_
 * <p>
 * m4 = （切一刀在4好，还是一段绳子最优切 * 3段绳子最优切好；2段绳子最优切 * 2段绳子最优切；3段绳子最优切*1段绳子最优切）可以查表，因为之前切过
 */
public class MaxProductCuttingRope {
    public static int maxProduct(int length) {
      int[] memo = new int[length + 1];
      memo[1] = 0;
      for (int i = 2; i <= length; i++) {
          for (int j = 1; j < i; j++) {
             System.out.println("i: " + i + " j: " + j + " i - j: " + (i - j)  + " memo[i]: " + memo[i] +  " memo[j]: " + memo[j]);
              System.out.println("Math.max( " + "memo[i]: " + memo[i] +
                      " , Math.max( j: " + j + " , memo[j]: " +
                      memo[j] + ")");
             memo[i] = Math.max(memo[i], Math.max(j, memo[j]) *(i - j));
          }
          System.out.println();
      }
      return memo[length];
    }

    public static void main(String[] args) {
        int length = 5;
        maxProduct(5);

    }
}
