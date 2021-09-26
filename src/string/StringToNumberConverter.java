package string;

public class StringToNumberConverter {
    public static int convert(String s) {

        /**
         * 103
         *
         * 1
         * count: 0
         * count = 0 * 10 + 1 = 1
         *
         * 0
         * count: 1
         * count = 1 * 10 + 0 = 10
         *
         * 3
         * count: 10
         * count = 10 * 10 + 3 = 103
         * */
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            int num = cur - '0';
            //use character subtract ascii char '0', so that we can can the letter's digit form
            System.out.println("num: " + num);
            count = count * 10 + num;
        }

        return count;
    }

    public static void main(String[] args) {
        // String s = "1";
        //  String s = "56";
        String s = "103";
        //String s = "22080";
        System.out.println("result: " + convert(s));
    }
}
