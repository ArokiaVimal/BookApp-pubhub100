package com.bookappcore.user;

public class TestUser {

	public static void main(String[] args) {
		User user = new User();
		user.setId(1);
		user.setName("Abi");
		user.setEmail("abi@gmail.com");
		user.setPsw("pass1234");
		user.setActive(1);
		
System.out.println(user.getName());
System.out.println(user);
	}
}
