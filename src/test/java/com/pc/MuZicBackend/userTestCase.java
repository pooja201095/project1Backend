package com.pc.MuZicBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;



import com.DaoImpl.UserDaoImpl;
import com.Model.User;

/**
 * Unit test for simple App.
 */
class userTestCase{
	public static void main(String agrs[]){
	
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.*");
		
		context.refresh();
		
		UserDaoImpl userImpl=(UserDaoImpl)context.getBean("userDaoImpl");
		
		
		User user=new User();
		
		user.setName("AnujaM");
		
		user.setAddress("Aalandi");
		
		user.setPassword("anum");
		
		user.setEmail("Anuja@gmail.com");
		user.setPhone("9785641233");
		
		user.setRole("User");
		
		
		userImpl.insertUser(user);		
		System.out.println("User Inserted");
		
	}
}
