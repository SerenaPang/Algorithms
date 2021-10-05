package dynamic.programming;
/**
 *Get the Kth number in the Fibonacci Sequence. (K is 0-indexed, the 0th Fibonacci number is 0 and the 1st Fibonacci number is 1).
 *
 * Examples
 *
 * 0th fibonacci number is 0
 * 1st fibonacci number is 1
 * 2nd fibonacci number is 1
 * 3rd fibonacci number is 2
 * 6th fibonacci number is 8
 * Corner Cases
 *
 * What if K < 0? in this case, we should always return 0.
 * Is it possible the result fibonacci number is overflowed?
 * We can assume it will not be overflowed when we solve this problem on this online judge,
 * but we should also know that it is possible to get an overflowed number,
 * and sometimes we will need to use something like BigInteger.
 * */
public class FibonacciNumber1 {
    /**
     *
     * 0 1 2 3 4 5 6
     * 0 1 1 2 3 5 8
     *
     * base case: 0 and 1
     * memo records the result of (index - 1) + (index - 2)
     * */
    public static long fibonacci(int K) {
        if (K <= 0) {
            return 0;
        }
        long[] memo = new long[K + 1];

        for (int i = 0; i <= K; i++) {
            //base case
          if (i == 0) {
              memo[i] = 0;
          } else if (i == 1) {
              memo[i] = 1;
          } else {
              memo[i] = memo[i - 1] + memo[i - 2];
          }
        }
        print(memo);
        return memo[K];
    }

    public static void print(long[] memo) {
        for (int i = 0; i < memo.length; i++) {
            System.out.print(memo[i] + " ");
        }
    }

    public static void main(String[] args) {
        fibonacci(6);
      //  System.out.println();
    }
}
