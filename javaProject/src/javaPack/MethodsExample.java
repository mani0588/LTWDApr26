package javaPack;

public class MethodsExample {

	public void sum(int a, int b) {
		// 20 lines
		System.out.println(a + b);
	}

	public void sum(int a, int b, int c) {
		// 20 lines
		System.out.println(a + b + c);
	}

	public static void sub(int a, int b) {
		// 20 lines
		System.out.println(a - b);
	}

	public static void main(String[] args) {
		MethodsExample obj = new MethodsExample();
		obj.sum(4, 7);
		obj.sum(123, 1, 5);
		
		MethodsExample.sub(11, 5);
	}
}
