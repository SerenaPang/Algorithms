package basic4_scope;

public class Student {
	String name;
	int age;
	double gpa;
	boolean enrolled;
	
	public static String schoolName = "LaiOffer";
	
	public Student(String name, int age, double gpa, boolean enrolled) {
		this.name = name;
		this.age = age;
		this.gpa = gpa;
		this.enrolled = enrolled;
	}
	
	public Student(String name, int age, boolean enrolled) {
		this.name = name;
		this.age = age;
		this.enrolled = enrolled;
	}
	
	public int computeAgeDiff(Student peer) {
		return this.age - peer.age;
	}
	
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public double getGpa() {
		return this.gpa;
	}
	
	public void saySchoolName() {
		System.out.println("I am " + this.name + " from " + schoolName);
	}

}
