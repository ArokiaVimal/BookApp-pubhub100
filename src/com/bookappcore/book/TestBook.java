package com.bookappcore.book;

public class TestBook {
	public static void main(String[] args) {
		Book book = new Book();
		book.setBookid(0012);
		book.setName("Hp");
		book.setPrice(500);
		
		System.out.println(book.getName());
		System.out.println(book);
	}
}