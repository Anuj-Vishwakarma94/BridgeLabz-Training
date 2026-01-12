package com.callcentre;
import java.util.*;
public class Manager {
	Queue<Customer>normalQueue=new LinkedList<>();
	PriorityQueue<Customer> vipQueue = new PriorityQueue<>(
	        new Comparator<Customer>() {
	            public int compare(Customer c1, Customer c2) {
	                return c1.callTime - c2.callTime;
	            }
	        }
	    );
	HashMap<String, Integer>callCountMap=new HashMap<>();
	public void addCustomer(Customer customer) {
		callCountMap.put(
				customer.name,
				callCountMap.getOrDefault(customer.name, 0) + 1
				);
		if(customer.isVip) {
			vipQueue.offer(customer);
		}
		else {
			normalQueue.offer(customer);
		}
	}
	public void handlecalls() {
		Customer customer;
		if(vipQueue.isEmpty()) {
			customer=vipQueue.poll();
		}
		else if(normalQueue.isEmpty()) {
			customer=normalQueue.poll();
		}
		else {
			System.out.println("No calls in Queue");
			return;
		}
		System.out.println("Handling call of: " + customer.name);
	}
	public void showCallCounts() {
		for (String name : callCountMap.keySet()) {
            System.out.println(name + " called " + callCountMap.get(name) + " times");
        }
	}
}
