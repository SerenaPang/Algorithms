package class4_0403;

public class VariableScope {
	
	public static void main(String[] args) {
		int i = 0;
		{
			int j = 1;
			{
				i = 1;
				j = 2;
				int k = 3;
			}
			
			System.out.println("i:" + i);
			System.out.println("j:" + j);
			//System.out.println("k:" + k);
			//k打不出来因为不在看得到的scope
			
			i = 2;
		}
		System.out.println("i:" + i);
		//System.out.println("j:" + j);
		//can not see j because it's outside the scope
		int k = 3;
		System.out.println("k: " + k);
	}
	//System.out.println("i:" + i);
	//can not see i, it's outside the scope
}
