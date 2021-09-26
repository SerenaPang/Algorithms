package recursion;

public class practice {
    public static void main(String[] args) {
        String s = "Student";
        int slow = 3;
       char[] array = s.toCharArray();
        System.out.println(new String(array, 0 , slow));
    }
}
