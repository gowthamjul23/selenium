package com.trigent.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trigent.utils.Locators;

public class LoginPage{
	
	public WebDriver driver;
	
	// username field
	@FindBy(xpath = Locators.userName)
	public WebElement username;
	
	@FindBy(xpath = Locators.userPassword)
	public WebElement password;
	
	@FindBy(xpath = Locators.loginButton)
	public WebElement login;
	
	@FindBy(xpath = Locators.invalidLoginMsg)
	public WebElement invalidLoginMsg;
	
	
	public LoginPage(WebDriver dr){
		driver = dr;		
	}
	
	public DashboardPage login(String uname, String pword) {
		username.sendKeys(uname);
		password.sendKeys(pword);
		login.click();
		return PageFactory.initElements(driver, DashboardPage.class);
	}
	
	public String getInvalidCredentialMsg() {
		System.out.println("Text displayed on using invalid credentials: "+invalidLoginMsg.getText());
		return invalidLoginMsg.getText();
	}
}
