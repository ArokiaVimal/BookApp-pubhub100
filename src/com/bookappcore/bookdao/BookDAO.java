package com.bookappcore.bookdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.bookappcore.book.Book;
import com.bookappcore.bookutil.BookConnectionUtil;

public class BookDAO {

	public void AddBook(Book book) throws Exception {
		Connection connection = BookConnectionUtil.getConnection();
		PreparedStatement pst = connection.prepareStatement("insert into books (name,price) values (?,?)");
		pst.setString(1, book.getName());
		pst.setDouble(2, book.getPrice());
		pst.executeUpdate();

	} 

	public boolean DeleteBook(Book book) throws Exception {
		Connection connection = BookConnectionUtil.getConnection();
		PreparedStatement pst = connection.prepareStatement("delete from books where book_id = ?");
		System.out.println("\n\t" + book.getBookid());
		pst.setInt(1, book.getBookid());
		int n = pst.executeUpdate();
		System.out.print(n);
		return n > 0;
	}

	public boolean updatePrice(Book book) throws Exception {
		Connection connection = BookConnectionUtil.getConnection();
		String sql = "update books set price= ? where name= ?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setDouble(1, book.getPrice());
		pst.setString(2, book.getName());
		return pst.executeUpdate()>0;
		
	}

	public ArrayList<Book> FindAll() throws Exception {
		ArrayList<Book> data=new ArrayList<>();
		Connection connection = BookConnectionUtil.getConnection();
		Statement pst = connection.createStatement();
		ResultSet rs = pst.executeQuery("Select book_id,Name,Price from books");
		while (rs.next()) {
			Book bookbuff = new Book();
			bookbuff.setBookid(rs.getInt(1));
			bookbuff.setName(rs.getString(2));
			bookbuff.setPrice(rs.getInt(3));
			data.add(bookbuff);
		}
		return data;
	}

	
	 public ResultSet ByName(String name) throws Exception {
		 Connection connection = BookConnectionUtil.getConnection();
		 PreparedStatement pst = connection.prepareStatement("Select book_id,Name,Price from books where Name like ?");
		 pst.setString(1, name);
		 return pst.executeQuery();
	 }
}