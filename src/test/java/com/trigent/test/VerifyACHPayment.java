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
import com.trigent.pages.PaymentTypes;

public class VerifyACHPayment extends BaseTest {
	LoginPage loginPage;
	DashboardPage dashBoardPage;	
	EmployeeClasses employeeClassesPage;	
	BillingPage Billing;
	PaymentTypes CreditPayment;
	
	Properties config = new Properties();  
	

		@Test
		
		public void PaythroACH() throws InterruptedException 
		{
			//Click Employer by verifying the status Active
			employeeClassesPage =PageFactory.initElements(driver, EmployeeClasses.class); 
			employeeClassesPage.SelectEmployerStatusA();
			
			//Click Invoice Tab 
			CreditPayment=PageFactory.initElements(driver, PaymentTypes.class); 
		    CreditPayment.ClickInvoiceTab();  
		    
		    //Verify the Unpaid status and proceed to pay through Credit
		    CreditPayment.VerifyUnpaidStatustopayACH();
		    
		    //Verify the Message and the Amount Paid
		    CreditPayment.CoverageandPay();   
		    
		}
}