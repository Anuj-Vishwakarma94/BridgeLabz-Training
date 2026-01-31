package com.foreachmethod.stockpricelogger;

import java.time.LocalTime;
import java.util.*;

public class StockLoggerMain {
	public static void main( String args[] )
	{
		List<Stock> stockFeed = Arrays.asList(
	            new Stock("AAPL", 175.50),
	            new Stock("GOOGL", 142.10),
	            new Stock("AMZN", 178.35),
	            new Stock("MSFT", 405.00),
	            new Stock("TSLA", 202.45)
	        );
		
		System.out.println("--- LIVE STOCK FEED STARTED ---");
		
		stockFeed.stream()
        .forEach(stock -> {
            // Simulating a log entry with a timestamp
            String timestamp = LocalTime.now().toString();
            System.out.println(timestamp + " | INFO | " + stock);
        });
		
		System.out.println("--- FEED ENDED ---");
	}
}
