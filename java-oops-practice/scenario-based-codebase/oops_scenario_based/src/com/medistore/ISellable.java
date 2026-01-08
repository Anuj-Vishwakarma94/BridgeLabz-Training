package com.medistore;

public interface ISellable {
	double sell(int units);
	boolean checkExpiry();
}
