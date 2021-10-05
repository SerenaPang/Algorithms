package classandobjects;
import java.util.ArrayList;

/**
 * Design an accumulator
 * */
public class Accumulator {
	ArrayList<Integer> myList = new ArrayList<Integer>();
	public void add(int x) {   
    myList.add(x);
	}
	public int sum() {
    int result = 0;
    for(int i = 0; i < myList.size(); i++){
      result = result + myList.get(i);
    }
    return result;
	}
}
