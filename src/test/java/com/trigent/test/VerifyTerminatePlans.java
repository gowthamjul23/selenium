package com.trigent.test;
import java.awt.AWTException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.trigent.base.BaseTest;
import com.trigent.pages.DashboardPage;
import com.trigent.pages.EmployeePage;
import com.trigent.pages.EmployerListPage;

public class VerifyTerminatePlans extends BaseTest {
	@Test 
	public void VerifyTermination() throws InterruptedException {
	DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
	dashboardPage.clickOnEmployerList();
	Thread.sleep(5000);
	
	//Check Employer Status
	EmployerListPage employerlistpage = PageFactory.initElements(driver, EmployerListPage.class);
	employerlistpage.checkEmployerStatus();
	
	//Click Employee Tab
	employerlistpage .ClickEmpTab();
	employerlistpage.clickFirstEmployee();	
	
	EmployeePage employeepage = PageFactory.initElements(driver, EmployeePage.class);
	
	employeepage. EmployeeName(); 
	
	//Click Terminate Button
	employeepage.ClickTerminate();
	employeepage. EnterTerminationDate();
	
	//Confirm Termination
	employeepage.ClickConfirm ();
	
	//employeepage.ClickClose();
	
	 
	
	
	
	}
}