package com.bookappcore.bookdao;

import com.bookappcore.book.Book;

public class TestBookDAO {

	public static void main(String[] args) throws Exception {
		Book book = new Book();
		book.setName("Java");
		book.setPrice(500);

		BookDAO bookDAO = new BookDAO();
		bookDAO.AddBook(book);
	}
}
