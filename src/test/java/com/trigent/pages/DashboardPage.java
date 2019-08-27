package com.trigent.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trigent.base.BaseTest;
import com.trigent.utils.Locators;

public class DashboardPage extends BaseTest{
	
	WebDriver driver;
	
	@FindBy(xpath = Locators.welcome)
	public WebElement welcome;
	
	//pim menu locators
	@FindBy(xpath = Locators.pim)
	public WebElement pimMenu;
	
	@FindBy(xpath = Locators.addEmployee)
	public WebElement addEmpSubMenu;	 
	
	@FindBy (xpath = "//ul//li/a[contains(text(),'Administration')]")
	WebElement administrationMenu;	
	
	@FindBy (xpath = "//ul//li/a[contains(text(),'Employer List')]")
	WebElement EmployerList;	
		
	
	public DashboardPage(WebDriver dr){
		driver = dr;		
	}
	public void clickOnAdministration() {
		administrationMenu.click();			
	}
	
	public void clickOnEmployerList() {
		EmployerList.click();
	}
	
	
	public boolean isWelcomeDisplayed() {
		boolean value = false;
		try {
			if(welcome.isDisplayed()) {
				return true;
			}else {
				return value;
			}			
		}catch(Exception e){
			System.out.println("Exception message ===> "+e);
			return value;
		}
	}
	
	
	public void VerifyEmployeeLogin() {
		boolean Admin = administrationMenu.isDisplayed();
				
		if(Admin == true) {
			System.out.println("Administration is enable for this Login.");
			}
		else{
			System.out.println("Administration is not enable for this Login");
			}
	}	
	

}
