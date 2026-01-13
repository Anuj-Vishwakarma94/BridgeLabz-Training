package com.trafficmanager;

import java.util.Queue;
import java.util.LinkedList;

class Roundabout {
	// Vehicles currently in roundabout - Circular LinkedList
	private Vehicle head = null;
	private int currentCount = 0;

	// Max vehicles allowed in roundabout at once
	private final int MAX_IN_ROUNDABOUT = 5;

	// Waiting vehicles Queue
	private Queue<Vehicle> waitingQueue = new LinkedList<>();

	// Try to let next vehicle enter the roundabout
	void tryEnter() {
		if (waitingQueue.isEmpty()) {
			System.out.println("No vehicles waiting.");
			return;
		}

		if (currentCount >= MAX_IN_ROUNDABOUT) {
			System.out.println("Roundabout full (" + currentCount + "/" + MAX_IN_ROUNDABOUT + ")");
			return;
		}

		Vehicle entering = waitingQueue.poll();
		addToCircularList(entering);
		currentCount++;
		System.out.println("-> " + entering.numberPlate + " entered roundabout");
	}

	// Add vehicle to waiting queue
	void arrive(String numberPlate) {
		Vehicle v = new Vehicle(numberPlate);
		waitingQueue.add(v);
		System.out.println("-> " + numberPlate + " joined waiting queue (queue size: " + waitingQueue.size() + ")");
	}

	// Vehicle exits the roundabout
	void exit(String numberPlate) {
		if (head == null) {
			System.out.println("Roundabout is empty.");
			return;
		}

		Vehicle current = head;
		Vehicle prev = null;

		do {
			if (current.numberPlate.equals(numberPlate)) {
				// Found vehicle to exit
				if (current == head && current.next == head) {
					// Only one vehicle
					head = null;
				} else if (current == head) {
					// Exit head
					head = head.next;
					Vehicle last = head;
					while (last.next != current)
						last = last.next;
					last.next = head;
				} else {
					// Normal case
					prev.next = current.next;
				}

				currentCount--;
				System.out.println("-> " + numberPlate + " exited roundabout (" + currentCount + " remaining)");
				tryEnter(); // try to let next waiting vehicle in
				return;
			}

			prev = current;
			current = current.next;
		} while (current != head);

		System.out.println(numberPlate + " not found in roundabout.");
	}

	// Add newly entered vehicle to circular list
	private void addToCircularList(Vehicle newVehicle) {
		if (head == null) {
			head = newVehicle;
			head.next = head;
			return;
		}

		Vehicle temp = head;
		while (temp.next != head) {
			temp = temp.next;
		}
		temp.next = newVehicle;
		newVehicle.next = head;
	}

	// Print current state
	void printState() {
		System.out.println("\n=== Roundabout Status ===");
		System.out.print("Vehicles in roundabout (" + currentCount + "/" + MAX_IN_ROUNDABOUT + "): ");

		if (head == null) {
			System.out.println("(empty)");
		} else {
			Vehicle temp = head;
			do {
				System.out.print("  " + temp.numberPlate);
				temp = temp.next;
				if (temp != head)
					System.out.print(" -> ");
			} while (temp != head);
			System.out.println();
		}

		System.out.println("Waiting queue (queue size: " + waitingQueue.size() + "):");
		if (waitingQueue.isEmpty()) {
			System.out.println("  (empty)");
		} else {
			for (Vehicle v : waitingQueue) {
				System.out.println("  " + v.numberPlate);
			}
		}
		System.out.println();
	}
}