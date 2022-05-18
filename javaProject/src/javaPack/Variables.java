package javaPack;

public class Variables {

	// local variable
	// instance / non-static variable
	// class / static variable

	int a = 10; // non-static
	static int b = 20; // static

	public static void main(String[] args) {

		int c = 30; // local

		Variables obj = new Variables(); // obj creation
		System.out.println(obj.a);

		System.out.println(Variables.b);

		System.out.println(c);

	}

}
