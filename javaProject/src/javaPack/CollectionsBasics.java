package javaPack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionsBasics {

	// Group of objects
	// List - allow duplicates and maintain the order of insertion
	// Set - no duplicates and no order maintained

	public static void main(String[] args) {

//		int a = 10;
//		Integer b = 2147483647;

//		CollectionsBasics cb1 = new CollectionsBasics();
//		CollectionsBasics cb2 = new CollectionsBasics();
//		CollectionsBasics cb3 = new CollectionsBasics();
//		
//		List<CollectionsBasics> cbList = new ArrayList<>();
//		cbList.add(cb1);

		List<Integer> nums = new ArrayList<>();
		nums.add(10);
		nums.add(20);
		nums.add(20);
		nums.add(30);
		System.out.println(nums);
		System.out.println(nums.size());
		System.out.println(nums.get(1));

		Set<Integer> nums1 = new HashSet<>();
		nums1.add(10);
		nums1.add(20);
		nums1.add(20);
		nums1.add(30);
		System.out.println(nums1);
		System.out.println(nums1.size());
		System.out.println(nums1.toArray()[1]);

	}

}
