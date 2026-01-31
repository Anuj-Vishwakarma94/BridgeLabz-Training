package com.streamapi.transformingnamesfordisplay;

import java.util.*;
import java.util.stream.Collectors;

public class CustomerDisplayMain 
{
	public static void main( String args[] )
	{
		List<String> customers = Arrays.asList(
	            "john doe", 
	            "alice smith", 
	            "charlie day", 
	            "bob brown", 
	            "david lee",
	            "eve miller"
	        );
		
		System.out.println("--- Formatted Customer List ---");
		
		List<String> formattedNames = customers.stream()
				.map(String::toUpperCase)
				.sorted()
				.collect(Collectors.toList());
		
		formattedNames.forEach(System.out::println);
	}

}
