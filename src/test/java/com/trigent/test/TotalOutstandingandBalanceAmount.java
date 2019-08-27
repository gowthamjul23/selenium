package com.trigent.test;
import java.awt.AWTException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.trigent.base.BaseTest;
import com.trigent.pages.DashboardPage;
import com.trigent.pages.EmployerListPage;

public class TotalOutstandingandBalanceAmount extends BaseTest{

	
	@Test 
	public void InvoiceAndPaymentsDetails() throws InterruptedException {
	
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.clickOnEmployerList();
		Thread.sleep(5000);
		
			
		EmployerListPage employerlistpage = PageFactory.initElements(driver, EmployerListPage.class);
		employerlistpage .VerifyEmployerStatus_A();	
		employerlistpage.clickInvoiceandPayment();
		
		employerlistpage.VerifyInvoiceOutstandingBalance();
		Thread.sleep(5000);		
		
	}
}
