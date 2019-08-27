package com.trigent.test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.trigent.base.BaseTest;
import com.trigent.pages.VerifyEmailpage;

public class VerifyWelcomeEmail extends BaseTest {
	Properties config = new Properties();
	VerifyEmailpage emailpage;
	
	@Test
	public void testELogin() throws Exception  {
		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		VerifyEmailpage emailpage = PageFactory.initElements(driver, VerifyEmailpage.class);
		emailpage.Emaillogin(Config.getProperty("emailuname"));
		emailpage.Password(Config.getProperty("pwd"));
		System.out.println("Login with valid credentials Test Starts");
		PageFactory.initElements(driver, VerifyEmailpage.class);
		System.out.println("Logged into Gmail successfully");
		emailpage.searchelement(Config.getProperty("searchkey"));
		
		//check the mail
		emailpage.checktheTitle_TimeofMail();
		Thread.sleep(3000);
		}
	 
	
	@AfterMethod(alwaysRun = true)
	public void tearDownAfterMethod() throws InterruptedException{
		System.out.println("After method starts");
		driver.quit();
		System.out.println("Driver Quit");
		System.out.println("After method ends");
	}
	 
}