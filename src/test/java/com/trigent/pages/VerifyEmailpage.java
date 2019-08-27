package com.trigent.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class VerifyEmailpage {
	public WebDriver driver;
	
	@FindBy(xpath="//input[@id='identifierId']")
	WebElement emailid;
	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement next;
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement pnext;
	@FindBy(xpath="//input[@class='gb_Qe' and @ty='text']")
	WebElement search;
	
	@FindBy(xpath="//*[@id=':lu']")
	WebElement TitleofMail;
	
	@FindBy(xpath="//*[@id=':lw']")
	WebElement TimeofMail;
	
	public VerifyEmailpage(WebDriver dr){
		driver = dr;		
	}
	
	public void Emaillogin (String emailuname) throws InterruptedException {
		emailid.sendKeys(emailuname);
		next.click();
		Thread.sleep(3000);
	}
		
		public void Password(String pwd) {
		password.sendKeys(pwd); 
		pnext.click();
			
	}

		public void searchelement(String searchkey) throws AWTException, InterruptedException {
	    search.sendKeys(searchkey);
	    Robot robot = new Robot(); 
	    robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
			
		}
		
		public void checktheTitle_TimeofMail() throws InterruptedException {
			TitleofMail.getText();
			Thread.sleep(3000);
			TimeofMail.getText();
		}
	
}
