package com.trigent.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.trigent.base.BaseTest;
import com.trigent.pages.DashboardPage;
import com.trigent.pages.EmployeePage;
import com.trigent.pages.EmployerListPage;

public class VerifyEmployeeDetails extends BaseTest {
EmployeePage employeepage;
	
	@Test
	public void verifyEmployee() throws InterruptedException {
		//click Employer List
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.clickOnEmployerList();
		Thread.sleep(5000);
		
		//Click any employer from the grid
	    EmployerListPage employerlistPage = PageFactory.initElements(driver, EmployerListPage.class);
		employerlistPage.checkEmployerStatus();
		Thread.sleep(5000);	 
		
		//Click Employees Button 
		employerlistPage.clickEmployeeTab();
		Thread.sleep(5000);
		
		//Verify employees in the grid
		employerlistPage.verify_Employees();	
		
		//Click the first employee
		employerlistPage.clickFirstEmployee();		
		
		//Print EmployeeName
		EmployeePage employeepage = PageFactory.initElements(driver, EmployeePage.class);
		employeepage.EmployeeName();
		
		//Print Employer Class Name
		employeepage.VerifyEmployerClass();
		
		//Print Employee Coverage
		employeepage.VerifyEmployeeCoverage();
		
	}
}
