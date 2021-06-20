package practice_ground;

public class Testing {

	public static void main(String[] args) {
		System.out.println(4%1);
		System.out.println(4/1);
		int count = 0;
		String s = "12";
		int len = s.length();
		for (int i = 0; i < len; i++) {
			count = count * 10 + s.charAt(i) - '0';
			System.out.println("num: " + (s.charAt(i) - '0'));
		}
		System.out.println("count = " + count);
	}
}
