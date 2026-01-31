package com.streamapi.insuranceclaimanalysis;

import java.util.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InsuranceAnalysisMain {
	public static void main( String args[] )
	{
		List<InsuranceClaim> claims = Arrays.asList(
	            new InsuranceClaim(101, "Auto", 5000.0),
	            new InsuranceClaim(102, "Health", 1200.50),
	            new InsuranceClaim(103, "Home", 200.0),
	            new InsuranceClaim(104, "Auto", 3000.0),
	            new InsuranceClaim(105, "Health", 800.0),
	            new InsuranceClaim(106, "Home", 15000.0),
	            new InsuranceClaim(107, "Auto", 1000.0),
	            new InsuranceClaim(108, "Travel", 450.0)
	        );
		
		System.out.println(" =====# Average Claim Amount by Type #===== ");
		
		Map<String, Double> averageByType = claims.stream()
	            .collect(Collectors.groupingBy(
	                InsuranceClaim::getClaimType,          // Key: Group by Type
	                Collectors.averagingDouble(InsuranceClaim::getAmount) // Value: Average of Amount
	            ));
		
		averageByType.forEach((type, avg) -> 
        System.out.printf("Type: %-10s | Average Claim: $%.2f%n", type, avg));
	}
}
