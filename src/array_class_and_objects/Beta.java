package array_class_and_objects;

public class Beta extends Alpha{
	public Beta() {
		System.out.print("beta ");
	}
	
	void go() {
		type = "b ";
		System.out.print(this.type + super.type);
	}
	
	public static void main(String[] args) {
		new Beta().go();
		//
	}
	
}
