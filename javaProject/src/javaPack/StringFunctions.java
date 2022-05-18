package javaPack;

import java.util.Arrays;

public class StringFunctions {

	public static void main(String[] args) {

		String name = "We offer packaging paper, and efficient transport solutions. Interim report 2022 Q1";

		System.out.println(name.length());

		String[] words = name.split(" ");
		System.out.println(words.length);
		System.out.println(Arrays.toString(words));

		System.out.println(name.replace("paper", "book"));

		System.out.println(name.replaceAll("[^0-9]", ""));
		System.out.println(name.replaceAll("[^A-z]", ""));

		System.out.println(name.toLowerCase());
		System.out.println(name.toUpperCase());

		System.out.println(name.substring(0, 10));
		System.out.println(name.substring(10));

		System.out.println(name.charAt(3));
		System.out.println(name.indexOf('o'));
		System.out.println(name.indexOf('o', name.indexOf('o') + 1));

		String name1 = "Chennai - 600100";
		String name2 = "chennai - 600100";

		System.out.println(name1.equals(name2));
		System.out.println(name1.equalsIgnoreCase(name2));

		System.out.println(name1.startsWith("Chen"));
		System.out.println(name1.endsWith("100"));
		System.out.println(name1.contains("-"));

		String name3 = " Chennai  100  ";
		System.out.println(name3);
		System.out.println(name3.trim());

	}
}
