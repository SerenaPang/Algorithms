package class9_string_and_hashtables;
/**
 * Given a string, remove all leading/trailing/duplicated empty spaces.
 * Assumptions:
 * The given string is not null.
 * Examples:
 * “  a” --> “a”
 * “   I     love MTV ” --> “I love MTV”
 * */
public class RemoveSpaces {
   /**
    *  case1: space in the beginning of the string(a space in front of a char): don't copy
    *  case2: space in between chars(a space in middle, chars in both sides): copy that space
    *  case3: space at the end of the string: don't copy
    * */
    //use a slow and fast pointer, slow keep all the chars we want, fast iterate through the whole string
    // if fast is a space, recognize its location by asking if in front of/ in the back of the space is a space or not
    //to decide if we want to copy it to slow or not
   public static String removeSpaces(String s){
       // "   I      love MTV "
       // "   I      love MTV "
       //  s
       char[] array = s.toCharArray();
       int slow = 0;
       for (int fast = 0; fast < array.length; fast++) {
           //how to make sure to delete all beginning spaces?
           //by checking if the spaces are consecutive i is space and i - 1 is space __
           //how to make sure we keep one space in between character?
           //by checking if the spaces are consecutive i is space and i - 1 is space a_b
           //how to delete all trailing spaces?
           //post processing e_ end - 1 is space or not
         if (array[fast] == ' ' && (fast == 0 || array[fast - 1] == ' ')) {
            continue;//skip space, not copying it
         }
         array[slow] = array[fast];
         slow++; //letters or a single space in between chars that we want to keep
       }
       //post processing last space in string
       if(slow > 0 && array[slow - 1] == ' '){
           System.out.println("slow: " + slow + " : " + array[slow]);
           slow--;
       }
       return new String(array, 0, slow);
   }

    public static String removeUnderScore(String s){
        //String s = "___I__love_yahoo_"
        char[] array = s.toCharArray();
        int end = 0;
        printString(array);
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            //System.out.print(array[i]);
            if (array[i] == '_' && (i == 0 || array[i - 1] != '_')) {
                System.out.println("here " + i + " " + array[i]);
                continue;
            }
            array[end] = array[i];
            end++;
            if (end > 0 && array[end - 1] == '_') {
                end--;
            }

        }
        return new String(array, 0, end);
    }
    public static void testingRmoveSpace(String s){
        System.out.println("Original String: " + s);
        System.out.println("Remove all leading/trailing and extra spaces");
        System.out.println(removeSpaces(s));
    }

    public static void printString(char[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(i);

        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);

        }
    }
   public static void main(String[] args) {
        String s ="   I      love MTV ";
        //testingRmoveSpace(s);
        String y = "___I__love_yahoo_";
       System.out.println(removeUnderScore(y));

   }

}
