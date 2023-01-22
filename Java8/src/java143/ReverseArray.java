package java143;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseArray {
	public static void reverseArray(int[] arr) {

		// convert array into list using java8 collection
		List<Integer> list = new ArrayList<Integer>();
		Collections.addAll(list, Arrays.stream(arr).boxed().toArray(Integer[]::new));
		Collections.reverse(list);
		System.out.println("Print after reverse array");
		System.out.println(list);
		System.out.println();

		// convert list to array using toArray method
		Integer[] arr1 = list.toArray(new Integer[1]);
		System.out.println("conver list to integer array");
		Arrays.stream(arr1).forEach(e -> System.out.print(e + " "));
		System.out.println();

		// convert list to array using stream api
		Integer[] arr2 = list.stream().toArray(Integer[]::new);
		Arrays.stream(arr2).forEach(e -> System.out.print(e + " "));
	}

	public static void main(String[] args) {
		int[] arr = { 12, 13, 15, 14, 16, 17, 18, 19 };
		System.out.println("Array before reverse ::");
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();
		reverseArray(arr);
	}

}
