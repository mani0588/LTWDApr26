package javaPack;

public class ExceptionHandling { // Object

	// checked / compile time exception
	// unchecked / run time exception

	// throws
	// try catch

	public static void main(String[] args) throws InterruptedException {

		Thread.sleep(2000); // checked / compile time exception

		try {
			System.out.println(10 / 0); // unchecked / run time exception
		} catch (Exception e) {
			System.out.println("Exception handled");
			 e.printStackTrace();
			 
			 // throw new ArithmeticException("Divisible by '0' is not valid, please check the input");
		}

		System.out.println("Done");

	}

}
