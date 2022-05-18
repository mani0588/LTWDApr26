package javaPack;

public class JavaBasics {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Welcome!!!");

		Thread.sleep(1000);

		String name = "Mani";
		int age = 16;

		System.out.println("My name is " + name);

		System.out.println("My name is " + name + " and age is " + age);
		System.out.println(String.format("My name is %s and age is %d", name, age));

		System.out.println("Execution done");

	}

}
