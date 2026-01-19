package com.interfaces.queueinterface;

import java.util.*;

public class GenerateBinaryNumbers {
	public static List<String> generateBinary(int n) {
		List<String> result = new ArrayList<>();
		if (n <= 0)
			return result;

		Queue<String> queue = new LinkedList<>();
		queue.add("1"); // start with first binary number "1"

		while (result.size() < n) {
			String current = queue.poll();
			result.add(current);

			// Append '0' and '1' to current number and add to queue
			queue.add(current + "0");
			queue.add(current + "1");
		}

		return result;
	}

	public static void main(String[] args) {
		int n = 10;
		List<String> binaryNumbers = generateBinary(n);

		System.out.println("First " + n + " binary numbers:");
		System.out.println(binaryNumbers);

		// Pretty print
		for (int i = 0; i < binaryNumbers.size(); i++) {
			System.out.printf("%2d -> %s%n", (i + 1), binaryNumbers.get(i));
		}
	}
}