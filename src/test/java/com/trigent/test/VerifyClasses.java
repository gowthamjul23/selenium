package com.trigent.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.sun.xml.fastinfoset.sax.Properties;
import com.trigent.base.BaseTest;
import com.trigent.pages.DashboardPage;
import com.trigent.pages.EmployeeClasses;
import com.trigent.pages.EmployerList;
import com.trigent.pages.LoginPage;
import com.trigent.pages.PlanInformation;

public class VerifyClasses extends BaseTest{
	LoginPage loginPage;
	DashboardPage dashBoardPage;
	EmployerList employerListPage;
	PlanInformation planInformationPage;
	EmployeeClasses employeeClassesPage;
	Properties config = new Properties();
	 
	
	@Test
	public void verifyclass() throws InterruptedException
	{
		//click on Employer List
		employerListPage=PageFactory.initElements(driver, EmployerList.class);
		employerListPage.clickOnEmployerList();
		
		//Select the Employer
		employeeClassesPage=PageFactory.initElements(driver, EmployeeClasses.class);
		employeeClassesPage.Selectemployer();
		
		//Select the Classes
		employeeClassesPage.Selectclass();
		Thread.sleep(5000);
		
		//List the Classes
		employeeClassesPage.listclass();
	}
	 
}
