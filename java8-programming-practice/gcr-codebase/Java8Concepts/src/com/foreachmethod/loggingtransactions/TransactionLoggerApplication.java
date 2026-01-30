package com.foreachmethod.loggingtransactions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class TransactionLoggerApplication 
{
	public static void main( String args[] )
	{
		List<String> transactionIds = Arrays.asList(
	            "TXN-1001",
	            "TXN-1002",
	            "TXN-1003",
	            "TXN-1004",
	            "TXN-1005"
	        );
		
		System.out.println("#====# Starting Transaction Log #====#");
		
		transactionIds.forEach(id -> 
		{	
			LocalDateTime now = LocalDateTime.now();
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedTime = now.format(formatter);
            
            System.out.println(formattedTime + " - Transaction: " + id);
            
            try { Thread.sleep(100); } catch (InterruptedException e) { }
		});
		
		System.out.println("#====# Log Complete #====#");
		
	}
	
}
