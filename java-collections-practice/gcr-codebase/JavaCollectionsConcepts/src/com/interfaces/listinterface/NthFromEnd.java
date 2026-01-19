package com.interfaces.listinterface;

import java.util.LinkedList;

public class NthFromEnd {
	// Find Nth element from end
	public static String findNthFromEnd(LinkedList<String> list, int n) {
		if (list == null || list.isEmpty() || n <= 0) {
			return null;
		}

		// Two pointers
		String fast = null;
		String slow = null;

		// Move fast pointer n steps ahead first
		int count = 0;
		for (String item : list) {
			if (count == n) {
				slow = list.getFirst(); // start slow only after fast has moved n steps
				break;
			}
			fast = item;
			count++;
		}

		// If n is larger than list size
		if (count < n) {
			return null;
		}

		// Now move both pointers until fast reaches end
		// When fast is at end, slow will be at Nth from end
		for (String item : list.subList(count, list.size())) {
			fast = item;
			slow = list.get(list.indexOf(slow) + 1); // move slow one step
		}

		return slow;
	}

	// Alternate way
	public static String findNthFromEndClean(LinkedList<String> list, int n) {
		if (list == null || list.isEmpty() || n <= 0 || n > list.size()) {
			return null;
		}

		return list.get(list.size() - n);
	}

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");

		System.out.println("List: " + list);

		System.out.println("1st from end : " + findNthFromEnd(list, 1)); // E
		System.out.println("2nd from end : " + findNthFromEnd(list, 2)); // D
		System.out.println("3rd from end : " + findNthFromEnd(list, 3)); // C
		System.out.println("5th from end : " + findNthFromEnd(list, 5)); // A
		System.out.println("6th from end : " + findNthFromEnd(list, 6)); // null
	}
}