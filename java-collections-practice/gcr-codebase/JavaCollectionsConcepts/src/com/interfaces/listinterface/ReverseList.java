package com.interfaces.listinterface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseList {

	// Two pointers (O(n) time, O(1) extra space)
	public static void reverseList(List<Integer> list) {
		int left = 0;
		int right = list.size() - 1;

		while (left < right) {
			// Swap elements at left and right positions
			Integer temp = list.get(left);
			list.set(left, list.get(right));
			list.set(right, temp);

			left++;
			right--;
		}
	}

	// Using remove + add (O(n²) for ArrayList)
	public static List<Integer> reverseUsingRemoveAdd(List<Integer> list) {
		List<Integer> reversed = new ArrayList<>();
		// or new LinkedList<>()

		while (!list.isEmpty()) {
			reversed.add(list.remove(list.size() - 1));
		}

		return reversed;
	}

	public static void main(String[] args) {
		// ArrayList
		System.out.println("=== ArrayList ===");
		List<Integer> arrayList = new ArrayList<>();
		for (int i = 1; i <= 6; i++) {
			arrayList.add(i);
		}

		System.out.println("Original ArrayList : " + arrayList);

		reverseList(arrayList);
		System.out.println("Reversed ArrayList : " + arrayList);

		System.out.println();

		// LinkedList
		System.out.println("=== LinkedList ===");
		List<Integer> linkedList = new LinkedList<>();
		for (int i = 10; i <= 15; i++) {
			linkedList.add(i);
		}

		System.out.println("Original LinkedList : " + linkedList);

		reverseList(linkedList);
		System.out.println("Reversed LinkedList  : " + linkedList);

		System.out.println();
		// Alternative inefficient way
		List<Integer> ll = new LinkedList<>(List.of(100, 200, 300, 400));
		System.out.println("Original: " + ll);

		List<Integer> rev = reverseUsingRemoveAdd(ll);
		System.out.println("Reversed (using remove+add): " + rev);

	}
}