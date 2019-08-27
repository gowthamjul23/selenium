package com.trigent.test;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.trigent.base.BaseTest;
import com.trigent.pages.DashboardPage;
import com.trigent.pages.EmployeePage;
import com.trigent.pages.EmployerListPage;

public class VerifyEmployeeCoveragewithVolumeMonthlyPremium extends BaseTest{
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
		
		//Click the first employee
		employerlistPage.clickFirstEmployee();		
		
		//Print EmployeeName
		EmployeePage employeepage = PageFactory.initElements(driver, EmployeePage.class);
		employeepage.EmployeeName();
		Thread.sleep(3000);
		
		employeepage.VerifyEmployeeCoverage_Volume_MonthlyPremium();
		Thread.sleep(3000);
		
	}

}
