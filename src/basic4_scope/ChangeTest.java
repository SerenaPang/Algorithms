package basic4_scope;

class Simple {
	public int value;
	
	public Simple(int v) {
		value = v;
	}	
}

public class ChangeTest {
	//didn't change the value because y is a copy of x
	public static void changeIntValue(int y){
		y = 10;
	}
	
	//only change the copy, didn't change the original object
	public static void changeValue1(Simple simple) {
		//creating a new object simple
		Simple newSimple = new Simple(10);
		simple = newSimple;//make simple(a copy) points to new object simple 
	}
	
	// . dereference the object address, which access the value of 
	//the object and change the value
	public static void changeValue2(Simple simple) {
		simple.value = 10;
	}
	
	public static Simple changeValue3(Simple simple) {
		Simple newSimple = new Simple(10);
		return newSimple;
	}
	
	public static void main(String[] args) {
		//first test
		int x = 5;
		changeIntValue(x);
		System.out.println(x);
		
		//second test
		Simple s1 = new Simple(5);
		changeValue1(s1);
		System.out.println(s1.value);
		
		//Third test
		Simple s2 = new Simple(5);
		changeValue2(s2);
		System.out.println(s2.value);
		
		//Fourth test
		//will not change the value because the return value 
		//was not assigned to the original object
		Simple s3 = new Simple(5);
		changeValue3(s3);
		System.out.println(s3.value);
		
		
		//this reassigned the value of s3,
		//so it will change the value
		s3 = changeValue3(s3);
		System.out.println(s3.value);
		
	}

}
