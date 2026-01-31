package com.smartcitymanagementsystem;

public interface GeoUtils 
{
	static double calculateDistance( int locationA, int locationB )
	{
		return Math.abs( locationA - locationB );
	}

}
