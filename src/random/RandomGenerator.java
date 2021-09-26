package random;

public class RandomGenerator {
    public static int pickPivot(int left, int right) {
        //left is from which lower bound we start to generate number

        return (int) (Math.random() * (right - left + 1));
        //return left + (int) (Math.random() * (right - left + 1));
    }

    public static void main(String[] args) {
        /**
         //include 0 and 1
         for (int i = 0; i < 5; i++) {
         System.out.println("Generates: " + pickPivot(0, 1) );
         }
         **/
        //include 0 and 5
        for (int i = 0; i < 20; i++) {
            System.out.println("Generates: " + pickPivot(1, 5));
        }

    }
}
