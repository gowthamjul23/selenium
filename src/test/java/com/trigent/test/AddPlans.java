package com.trigent.test;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.trigent.base.BaseTest;
import com.trigent.pages.DashboardPage;
import com.trigent.pages.EmployeePage;
import com.trigent.pages.EmployerListPage;

public class AddPlans extends BaseTest{
EmployeePage employeepage;
	
	@Test
	public void verifyAddPlan() throws InterruptedException {
		//click Employer List
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.clickOnEmployerList();
		Thread.sleep(5000);
		
		//Click any employer from the grid
	    EmployerListPage employerlistPage = PageFactory.initElements(driver, EmployerListPage.class);
		employerlistPage.checkEmployerStatus();
		Thread.sleep(5000);	
		
		employerlistPage.clickPlanInformationTab();
		Thread.sleep(3000);
		
		employerlistPage.clickAddPlan();
		
		employerlistPage.EnterDetailsinAddPlan();
		
		employerlistPage.ClickSavePlan();
		Thread.sleep(6000);
		
		employerlistPage.AssertLastRowofPlanTable();
		Thread.sleep(5000);
	}


}
