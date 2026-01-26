package com.constructors.level1;

public class Book {

		private String title;
		private String author;
		private float price;
		
		private String[] books = {"Atomic Life","Freedom to Live","The Art of Living"};
		private boolean[] availibility= {true, false,true};
		
		public boolean isAvailable(String input) {
			for ( int i =0; i < books.length; i++) {
				if( books[i].equals(input))
				  return availibility[i];
			}
			return false;
		}
		
		public Book() {
			this.title = "Atomic Life";
			this.author = "James Clark";
			this.price = 90.23f;
		}
		
		
		public Book(String title, String author, float price) {
			this.title = title;
			this.author = author;
			this.price = price;
		}
		
		
		public void setData(String title, String author, float price) {
			this.title = title;
			this.author = author;
			this.price = price;
		}
		
		public String getData() {
			return title + " " + author + "  " + price;
		}
		
		
		
		
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			Book book1 = new Book();		
			Book book2 = new Book("Freedom to Live", "Albert Johnson", 1000.0f);
			Book book3 = new Book();
			
			book3.setData("The Art of Living", "Dr Bridgestone", 0.20f);
			
			String book1Data = book1.getData();
			String book2Data = book2.getData();
			String book3Data = book3.getData();
			
			System.out.println(book1Data);
			System.out.println(book2Data);
			System.out.println(book3Data);

	}
}