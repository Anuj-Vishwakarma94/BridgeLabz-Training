package com.stackandqueue.circulartourproblem;

import java.util.Stack;
public class CircularTourProblem {

	    static class Pump {
	        int petrol;
	        int distance;

	        Pump(int p, int d) {
	            petrol = p;
	            distance = d;
	        }
	    }

	    public static int findStartPoint(Pump[] pumps) {

	        int n = pumps.length;
	        Stack<Integer> stack = new Stack<>();

	        // Push all indices as candidates
	        for (int i = n - 1; i >= 0; i--) {
	            stack.push(i);
	        }

	        while (!stack.isEmpty()) {

	            int start = stack.pop();
	            int tank = 0;
	            int count = 0;
	            int i = start;

	            while (count < n) {
	                tank += pumps[i].petrol - pumps[i].distance;
	                if (tank < 0) break;

	                i = (i + 1) % n;
	                count++;
	            }

	            if (count == n && tank >= 0) {
	                return start;
	            }
	        }

	        return -1; // No valid starting point
	    }

	    public static void main(String[] args) {

	        Pump[] pumps = {
	            new Pump(6, 4),
	            new Pump(3, 6),
	            new Pump(7, 3)
	        };

	        int result = findStartPoint(pumps);

	        if (result == -1)
	            System.out.println("No solution exists");
	        else
	            System.out.println("Start at pump index: " + result);
	    }
	}
