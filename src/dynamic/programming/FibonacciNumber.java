package dynamic.programming;

public class FibonacciNumber {
    /**
     fib(n - 1) + fib(n - 2)
     之前有的数值直接读，没有的就计算，从哪边开始填，从知道的不用填表的开始填
     填表格：current如何计算？：把前两个加起来 linear scan 回头看两个result
     0 1 2 3 4 5
     0 1

     0 1 2 3 4 5
     0 1 1

     0 1 2 3 4 5
     0 1 1 2

     0 1 2 3 4 5
     0 1 1 2 3

     0 1 2 3 4 5......1000
     0 1 1 2 3 5

     如何优化？
     考虑到我们只需要前两个数字，其实之前的数都没必要存，我们keep一个rolling update variable记录前两个就行
     */
    public long fibonacci(int K) {

        if (K <= 0) {
            return 0;
        }
        long[] array = new long[K + 1];//memo
        array[1] = 1; //base case
        for (int i = 2; i <= K; i++) {
            array[i] = array[i - 2] + array[i - 1];
        }
        return array[K];
    }
}
