package com.interfaces.queueinterface;

public class CircularBuffer {
	private int[] buffer;
	// index where next element will be read (front)
	private int head;
	// index where next element will be written
	private int tail;
	// current number of elements in buffer
	private int size;
	private final int capacity;

	// Constructor
	public CircularBuffer(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("Capacity must be positive");
		}
		this.capacity = capacity;
		this.buffer = new int[capacity];
		this.head = 0;
		this.tail = 0;
		this.size = 0;
	}

	// Add element to buffer (overwrite oldest when full)
	public void add(int value) {
		buffer[tail] = value;
		tail = (tail + 1) % capacity;

		// If buffer was full, move head forward
		if (size == capacity) {
			head = (head + 1) % capacity;
		} else {
			size++;
		}
	}

	// Get current elements in order (from oldest to newest)
	public int[] getCurrentElements() {
		int[] result = new int[size];
		int index = 0;
		int current = head;

		for (int i = 0; i < size; i++) {
			result[index++] = buffer[current];
			current = (current + 1) % capacity;
		}

		return result;
	}

	// Check if buffer is full
	public boolean isFull() {
		return size == capacity;
	}

	// Check if buffer is empty
	public boolean isEmpty() {
		return size == 0;
	}

	// Current number of elements
	public int size() {
		return size;
	}

	// good string representation
	@Override
	public String toString() {
		if (isEmpty()) {
			return "[]";
		}

		StringBuilder sb = new StringBuilder("[");
		int current = head;
		for (int i = 0; i < size; i++) {
			sb.append(buffer[current]);
			if (i < size - 1) {
				sb.append(", ");
			}
			current = (current + 1) % capacity;
		}
		sb.append("]");

		return sb.toString();
	}

	// Test
	public static void main(String[] args) {
		CircularBuffer cb = new CircularBuffer(3);

		System.out.println("Initial: " + cb);

		cb.add(1);
		System.out.println("After 1: " + cb);

		cb.add(2);
		System.out.println("After 2: " + cb);

		cb.add(3);
		System.out.println("After 3: " + cb);

		cb.add(4); // overwrites oldest element (1)
		System.out.println("After 4: " + cb);

		cb.add(5); // overwrites oldest element (2)
		System.out.println("After 5: " + cb);
	}
}