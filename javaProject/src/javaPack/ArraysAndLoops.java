package javaPack;

import java.util.Arrays;

public class ArraysAndLoops {

	public static void main(String[] args) {

		// Arrays - Group of values with same datatype
		int[] nums = { 10, 20, 30, 40 };

		System.out.println("Number of values " + nums.length);

		System.out.println(nums[0]);
		System.out.println(Arrays.toString(nums));

		// for loop
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}

		// for each loop
		for (int num : nums) {
			System.out.println(num);
		}

	}

}
