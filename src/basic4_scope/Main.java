package basic4_scope;

public class Main {
	class B{
		public void f() {
			int x1 = 7;
			A a1 = new A(); // 7
		}
		int x2 = 8;
		A a2 = new A();//7
	}
	
	class A{
		int x = 7;
		
		public void g(int num) {
			int x3 = num;
			System.out.print(x3);
		}
	}
		
	public static void main(String[] args) {
		/**
		B b = new B();
		b.f();
		b.a2.g(5);
		*/
	}

}
