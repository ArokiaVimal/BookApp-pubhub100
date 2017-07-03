package com.bookappcore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.bookappcore.user.User;
import com.bookappcore.util.ConnectionUtil;

public class UserDAO {

	public boolean register(User user) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pst = connection.prepareStatement("Insert into users(Name,Email,Password) Values(?,?,?)");
		pst.setString(1, user.getName());
		pst.setString(2, user.getEmail());
		pst.setString(3, user.getPsw());
		int n = 0;
		try {
			 n=pst.executeUpdate();
		}
		catch(Exception e) {
			//response.getWriter().println("This username or Email-ID alreay Exists");
			System.out.println(e.getMessage());
		}
		System.out.println("\t"+n);
		return n>0;
	}

	/*public boolean login(User user) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		int count=0;
		PreparedStatement pst=connection.prepareStatement("Select Name from users where email = ? and password = ?");
		pst.setString(1, user.getEmail());
		pst.setString(2, user.getPsw());
		ResultSet rs=pst.executeQuery(); 
		while(rs.next())
			count++;
		System.out.println("\n\t"+count);
	    return rs.next();
	    }*/
	public boolean login(User user)throws Exception{
		Connection connection = ConnectionUtil.getConnection();
		String sql="select name from users where email=? and password=?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, user.getEmail());
		pst.setString(2, user.getPsw());
        ResultSet rs=pst.executeQuery();
        return rs.next();

	}
}

