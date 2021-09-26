package practice_ground;

public class Modulus {

    public static void main(String[] args) {

        int[] array = new int[]{4, 9, 10, 11, 15, 10002, 12345};
        for (int i = 0; i < array.length; i++) {
            int mod = array[i] % 10;
            int val = array[i] / 10;
            System.out.println("num: " + array[i] + " mod by 10: " + mod + " divided by 10 : " + val);
        }
    }
}
