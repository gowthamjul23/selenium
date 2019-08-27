package com.trigent.test;
import java.awt.AWTException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.trigent.base.BaseTest;
import com.trigent.pages.DashboardPage;
import com.trigent.pages.EmployerListPage;

public class ActivateEmployer extends BaseTest {
	
	@Test 
	public void ActivatingEmployer() throws InterruptedException {
	
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.clickOnEmployerList();
		Thread.sleep(5000);
		
		//Verify Employer Status U
		EmployerListPage employerlistpage = PageFactory.initElements(driver, EmployerListPage.class);
		employerlistpage.VerifyEmployerStatus_U();
		Thread.sleep(5000);
		
		//Click Edit Button in Employer Page
		employerlistpage.ClickEditEmployer(); 
		Thread.sleep(5000); 
		
		//Activate Employer
		employerlistpage.click_Employer_checkbox ();
		Thread.sleep(5000);

}

}
