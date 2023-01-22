package java143;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountFirstSecondHalfArrayUsingJava8 {

	// reverse array using java 8
	public static void devideArray(int[] arr) {

		// divide the array in two part

		int[] arr1 = Arrays.copyOfRange(arr, 0, arr.length / 2);
		int[] arr2 = Arrays.copyOfRange(arr, (arr.length) / 2, arr.length);

		// print the first of the array
		System.out.println("print first half array");
		Arrays.stream(arr1).forEach(e -> System.out.print(e + " "));
		System.out.println();

		// print the first half array reverse
		System.out.println("reverse first half array");
		List<Integer> list = new ArrayList<Integer>();
		Collections.addAll(list, Arrays.stream(arr1).boxed().toArray(Integer[]::new));
		Collections.reverse(list);
		System.out.println(list);
		System.out.println();

		// print the second half array
		System.out.println("print second half array");
		Arrays.stream(arr2).forEach(e -> System.out.println(e + " "));
		System.out.println();

		// print the second array reverse
		System.out.println("print second half array reverse");
		List<Integer> list1 = new ArrayList<Integer>();
		Collections.addAll(list1, Arrays.stream(arr2).boxed().toArray(Integer[]::new));
		Collections.reverse(list1);
		System.out.println(list1);
		System.out.println();
		findMin(arr1, arr2);// call findMin array method
		findMax(arr1, arr2);// call findMax array method
		findMaxMinFullArray(arr);
	}// CountFirstSecondHalfArrayUsingJava8() close

	private static void findMaxMinFullArray(int[] arr) {
		System.out.println("find the min from full array");
		Arrays.sort(arr);
		System.out.println(arr[0]);
		System.out.println();

		System.out.println("find the max from full array");
		Arrays.sort(arr);
		System.out.println(arr[arr.length - 1]);
	}

	// find the min from the array
	public static void findMin(int[] arr1, int[] arr2) {
		System.out.println("Min from first half array");
		Arrays.sort(arr1);
		System.out.println(arr1[0]);
		System.out.println();

		System.out.println("Min from second half array");
		Arrays.sort(arr2);
		System.out.println(arr2[0]);
		System.out.println();
	}

	// find the max from the array
	public static void findMax(int[] arr1, int[] arr2) {
		System.out.println("Max from first half array");
		Arrays.sort(arr1);
		System.out.println(arr1[arr1.length - 1]);
		System.out.println();

		System.out.println("Max from second half array");
		Arrays.sort(arr2);
		System.out.println(arr2[arr1.length - 1]);
		System.out.println();
	}

	public static void main(String[] args) {
		// this is array
		int[] arr1 = { 21, 32, 54, 76, 87, 12, 23, 45, 67, 89 };

		devideArray(arr1);

	}

}
