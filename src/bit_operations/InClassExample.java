package bit_operations;

public class InClassExample {

    public static void main(String[] args) {
        /**
         * 0:false 1: ture
         * &&: logical and true and false
         * 因为是true and false， bits必须都是true才能得到true
         * 1 & 1 -> 1
         * 1 & 0    0
         *
         * ~: not
         * |: or
         * ^:xor 不进位的加法
         *
         * <<: 左移left shift 右侧补充0
         * 移k位：2的k次方 1000：是2的三次方 10000： 2的四次方
         *
         * right shift：右移 正数左边是零（正数）补零，负数补1
         *
         * */
        System.out.println(0b1100);
        System.out.println(0b1100 & 0b1100);
        /**
         * 怎么把0b00101010的右边第3位拿出来？
         * 方法1：
         * 0b00000001
         * <<3
         * 用一个mask，只有第三位是1， 然后&它俩
         * 0b00001000 &
         * 0b00101010
         *       ?
         *       当结果为1就是1，0就是0
         *
         * 方法2：0b00101010右移k位，左边补充0 然后&1
         * 0b00000101&
         * 0b00000001
         *
         * 方法2更通用因为结果不是0就是1，方法1给的是数字的结果可能会返回8
         *
         * 如何把x的第k bit变成1？
         * 用or ｜ 用mask or上1就可以
         * 1左移k位 ｜or 上 x
         *
         *如何把x的第k bit变成0？
         * x = 0b1010111000  k是3
         *用& 先量身定制做一个mask
         *     0b1010111100
         *     &上就完事，其他bit不变唯独第k bit变了
         *
         *
         * */

    }
}
