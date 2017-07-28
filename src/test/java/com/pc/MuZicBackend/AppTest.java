/*package com.pc.MuZicBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.DaoImpl.userDaoImpl;
import com.Model.User;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

*//**
 * Unit test for simple App.
 *//*
class userTestcase{
	public static void main(String agrs[]){
		
AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.OnlineKartZone.CKartonline");
//		
		context.refresh();
		
		
		userDaoImpl userImpl=(userDaoImpl)context.getBean("UserDaoImpl");
		
		
		User user=new User();
		
		user.setName("AnujaM");
		
		user.setAddress("Aalandi");
		
		user.setName("Anuja Mane");
		
		user.setPassword("anum");
		
		user.setEmail("Anuja@gmail.com");
		user.setPhone("9785641233");
		
		user.setRole("User");
		
		
		userImpl.insertUser(user);		
		System.out.println("User Inserted");
		
	}
}
public class AppTest 
    extends TestCase
{
    *//**
     * Create the test case
     *
     * @param testName name of the test case
     *//*
    public AppTest( String testName )
    {
        super( testName );
    }

    *//**
     * @return the suite of tests being tested
     *//*
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    *//**
     * Rigourous Test :-)
     *//*
    public void testApp()
    {
        assertTrue( true );
    }
    
    
}
*/