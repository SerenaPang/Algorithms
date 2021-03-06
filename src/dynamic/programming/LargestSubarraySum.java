package dynamic.programming;
    /**

     有正数有负数的array，找一个连续的subarray，这个subarray里的所有值加起来是最大的sum

     mi的物理意义：最长的array sum的结尾element
     base case：m0的时候，第一个element
     index： 0 1 2  3  4  5  6  7    8
     array： 1 2 4 -1 -2 10 -1 -100  2
     m    ： 1

     index： 0 1 2  3  4  5  6  7    8
     array： 1 2 4 -1 -2 10 -1  -100 2 因为只有2自己，和2 + 之前的1= 3比起来3更大，所以记录3
     m    ： 1 3

     index： 0 1 2  3  4  5  6  7    8
     array： 1 2 4 -1 -2 10 -1  -100 2 因为只有4自己，和4 + 之前的3= 7比起来7 > 4 更大，所以记录7
     m    ： 1 3 7

     index： 0 1 2  3  4  5  6  7    8
     array： 1 2 4 -1 -2 10 -1  -100 2 因为只有4自己，和4 + 之前的3= 7比起来7 > 4 更大，所以记录7(继承遗产)
     m    ： 1 3 7

     index： 0 1 2  3  4  5  6  7    8
     array： 1 2 4 -1 -2 10 -1  -100 2 因为只有-1自己（另起炉灶的话在这里并不比继承遗产好），和-1 + 之前的7= 6比起来6 > -1 更大，所以记录6
     m    ： 1 3 7  6

     index： 0 1 2  3  4  5  6  7    8
     array： 1 2 4 -1 -2 10 -1  -100 2 因为只有-2自己（另起炉灶的话在这里并不比继承遗产好），和-2 + 之前的6= 4比起来4 > -2 更大，所以记录4
     m    ： 1 3 7  6  4

     index： 0 1 2  3  4  5  6  7    8
     array： 1 2 4 -1 -2 10 -1  -100 2 因为只有10自己（另起炉灶的话在这里并不比继承遗产好），和10 + 之前的4= 14比起来14 > 10 更大，所以记录14
     m    ： 1 3 7  6  4 14

     index： 0 1 2  3  4  5  6   7    8
     array： 1 2 4 -1 -2 10 -1  -100  2 因为只有-1自己（另起炉灶的话在这里并不比继承遗产好），和-1 + 之前的14= 13比起来13 > -1 更大，所以记录13
     m    ： 1 3 7  6  4 14 13

     index： 0 1 2  3  4  5  6   7    8
     array： 1 2 4 -1 -2 10 -1  -100  2 因为只有-100自己（另起炉灶的话在这里并不比继承遗产好，虽然之前只有13也比没有好），和-100 + 之前的13= -87比起来87 >
     -100 更大，所以记录-87
     m    ： 1 3 7  6  4 14 13  -87

     index： 0 1 2  3  4  5  6   7    8
     array： 1 2 4 -1 -2 10 -1 -100   2 因为只有2自己 另起炉灶的比继承遗产好（遗产是-87），和2 + 之前的-87= -85比起来2 > -87，所以记录2
     m    ： 1 3 7  6  4 14 13 -87    2

     */


    public class LargestSubarraySum {
        public int largestSum(int[] array) {
            int result = array[0];
            int cur = array[0];
            for (int i = 1; i < array.length; i++) {
                cur = Math.max(cur + array[i], array[i]);//inherit, start from the beginning
                result = Math.max(result, cur);//update global max
            }
            return result;
        }
    }
