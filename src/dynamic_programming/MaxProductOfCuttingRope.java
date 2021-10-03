package dynamic_programming;
    /**
     * Given a rope with positive integer-length n, how to cut the rope into m integer-length parts with length p[0], p[1], ...,p[m-1], in order to get the maximal product of p[0]*p[1]* ... *p[m-1]? m is determined by you and must be greater than 0 (at least one cut must be made). Return the max product you can have.
     *
     * Assumptions
     *
     * n >= 2
     * Examples
     *
     * n = 12, the max product is 3 * 3 * 3 * 3 = 81(cut the rope into 4 pieces with length of each is 3).
     *
     一个长度为5的绳子，切一刀（必须要切一刀），要怎么切才能使的两半绳的乘积最大，
     比如说 5怎么切？可以是
     2 3
     1 1 1 1 1
     2 1 2
     ......

     dfs的写法：

     切一刀能有多少种情况？
     4种：
     第一种：1｜1111 size为4 * 1 （子问题不切）
     第二种：11｜111             （子问题切了）
     第三种：111｜11
     第四种：1111｜1 size为1 * 4

     这4种cases又能分出不同的cases来：
     4种：
     第一种： 1｜1111  size为4 * 1
     可以分出三种情况（因为这个size为4的子问题还能再切，所以我们算出所有可能性之后，拿这些数和没有切过的size4比较，取最大的值）
     1｜1｜111
     1｜11｜11
     1｜111｜1
     左半边和右半边要相乘

     第二种：11｜111
     可以分出2种情况，因为之前所有的切法都cover在第一种情况里了，不用再管左半边，管右半边就可以了：
     11｜1｜11
     11｜11｜1

     第三种：111｜11
     第四种：1111｜1 size为1 * 4

     recursion tree： n个level，n-1，n-2，n-3

     dp的填表写法：
     只考虑切一刀：
     m[0] 0米长的绳子：invalid因为必须要切一刀
     m[1]1米长的绳子：invalid，不切就是1本身
     m[2]2米长的绳子：切一刀，变成左边右边，1｜1，1米长的绳子之前见过 m[1]
     m[3]3米长的绳子：可以这么切，它存的数是在这下面的切法里选个max就可以了
     1｜11  左大段1，右2米长的绳子（见过），所以此时m[1] m[2]取一个最大值
     1｜1｜1
     11｜1 算过了不用再算了，在表里

     m[4]4米长的绳子：
     1｜111
     11｜11
     111｜1
     为什么之前的左半边不用再看了？因为在表里了

     左大段读表，右小段计算

     */

public class MaxProductOfCuttingRope {
}
