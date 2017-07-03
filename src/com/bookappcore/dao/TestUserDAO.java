package com.bookappcore.dao;

import com.bookappcore.user.User;

public class TestUserDAO {

	public static void main(String[] args) throws Exception {
                  User user = new User();
                  user.setName("Haris");
                  user.setEmail("haris@gmail.com");
                  user.setPsw("pass1234");
                  
                UserDAO userDAO = new UserDAO();
                userDAO.login(user);
	}

}
