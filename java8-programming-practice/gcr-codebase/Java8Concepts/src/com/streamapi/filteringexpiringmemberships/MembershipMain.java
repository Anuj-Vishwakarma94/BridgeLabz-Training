package com.streamapi.filteringexpiringmemberships;

import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class MembershipMain 
{
	public static void main ( String args[] )
	{
		LocalDate today = LocalDate.of(2024, 6, 1); 
        LocalDate thirtyDaysFromNow = today.plusDays(30);
        
        System.out.println("Current Date: " + today);
        System.out.println("Warning Window: Up to " + thirtyDaysFromNow);
        System.out.println();
        System.out.println("====# Members Expiring Soon #==== ");
        
        List<Member> members = Arrays.asList(
        		new Member("Alice", "2024-06-05"),  
                new Member("Bob", "2024-06-25"),    
                new Member("Charlie", "2024-08-10"),
                new Member("David", "2024-05-20"),  
                new Member("Eve", "2024-06-30")     
            );
        
        List <Member> expiringMembers = members.stream()
        		.filter(m -> !m.getExpiryDate().isBefore(today) && 
                        !m.getExpiryDate().isAfter(thirtyDaysFromNow))   
        		.collect(Collectors.toList());
        
        if (expiringMembers.isEmpty()) {
            System.out.println("No memberships expiring in the next 30 days.");
        } else {
            expiringMembers.forEach(System.out::println);
        }
        
        
        System.out.println("====#       ThankYou        #==== ");
	}
	
}
