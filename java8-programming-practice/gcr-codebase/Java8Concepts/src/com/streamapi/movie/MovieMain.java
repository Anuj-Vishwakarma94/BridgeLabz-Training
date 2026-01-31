package com.streamapi.movie;

import java.util.*;
import java.util.stream.Collectors;

public class MovieMain 
{
	public static void main(String args[])
	{
		List<Movie> movies = Arrays.asList(
				new Movie("The Godfather", 9.2, 1972),
	            new Movie("Inception", 8.8, 2010),
	            new Movie("Dune: Part Two", 8.9, 2024),
	            new Movie("Oppenheimer", 8.6, 2023),
	            new Movie("Madame Web", 3.8, 2024),
	            new Movie("Poor Things", 8.1, 2023),
	            new Movie("The Dark Knight", 9.0, 2008),
	            new Movie("Civil War", 7.6, 2024),
	            new Movie("Inside Out 2", 8.0, 2024),
	            new Movie("Barbie", 7.0, 2023)
	            );
		System.out.println(" ========== Top 5 trending Movies ========== ");
		
		List<Movie> top5Trending = movies.stream()
				.filter(movie -> movie.getReleaseYear() >= 2023)
				.sorted(Comparator.comparingDouble(Movie::getRating).reversed())
				.limit(5)
				.collect(Collectors.toList());
		
		top5Trending.forEach(System.out::println);
	}
}
