package com.trigent.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.xml.fastinfoset.sax.Properties;
import com.trigent.base.BaseTest;
import com.trigent.pages.DashboardPage;
import com.trigent.pages.EmployeeClasses;
import com.trigent.pages.EmployerList;
import com.trigent.pages.LoginPage;
import com.trigent.pages.PlanInformation;
import com.trigent.pages.UploadCensusPage;
import com.trigent.pages.BillingPage;


 
public class VerifyGenerateBills extends BaseTest {
	LoginPage loginPage;
	DashboardPage dashBoardPage;
	BillingPage Billing;
	
	Properties config = new Properties(); 
	
		@Test
		
		public void Billing() throws InterruptedException
		{
			//Click Administration Menu
			DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPage.clickOnAdministration(); 
			 
			//Click Billing Sub-menu
			Billing=PageFactory.initElements(driver, BillingPage.class); 	
			Billing.BillingSubmenu();

			//Verify the Page
			Billing.VerifyGenerateBillingpage();
			
			//Process the Billing
			Billing.GenerateBilling(); 
			
		}

}
