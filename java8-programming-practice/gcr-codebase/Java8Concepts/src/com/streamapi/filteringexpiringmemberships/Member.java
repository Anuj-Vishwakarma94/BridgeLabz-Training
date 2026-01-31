package com.streamapi.filteringexpiringmemberships;

import java.time.LocalDate;

public class Member {
	private String name;
	private LocalDate expiryDate;
	
	public Member( String name, String expiryDate )
	{
		this.name = name;
		this.expiryDate = LocalDate.parse(expiryDate);
	}
	
	public String getName() { return name; }
    public LocalDate getExpiryDate() { return expiryDate; }

    @Override
    public String toString()
    {
    	return "Member: " + name + " (Expires: " + expiryDate + ")";
    }
}
